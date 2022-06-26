/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.carbon.extension.identity.authenticator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.AbstractApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.LocalApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.config.ConfigurationFacade;
import org.wso2.carbon.identity.application.authentication.framework.config.model.StepConfig;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.exception.AuthenticationFailedException;
import org.wso2.carbon.identity.application.authentication.framework.model.AuthenticatedUser;
import org.wso2.carbon.identity.application.authentication.framework.util.FrameworkConstants;
import org.wso2.carbon.identity.application.authentication.framework.util.FrameworkUtils;
import org.wso2.carbon.identity.core.util.IdentityTenantUtil;
import org.wso2.carbon.user.api.UserRealm;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.service.RealmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static org.wso2.carbon.extension.identity.authenticator.securidRestClient.ClientSide.principal;

/**
 * RSA SecurId 2-Factor Authenticator
 */
public class RSASecurIdAuthenticator extends AbstractApplicationAuthenticator
        implements LocalApplicationAuthenticator {
    private static final Log log = LogFactory.getLog(RSASecurIdAuthenticator.class);

    /**
     * Get the friendly name of the RSA SecurID Authenticator
     *
     * @return RSA SecurId Authenticator Friendly Name
     */
    @Override
    public String getFriendlyName() {
        if (log.isDebugEnabled()) {
            log.debug("Authenticator friendly name: " + RSASecurIdAuthenticatorConstants.AUTHENTICATOR_FRIENDLY_NAME);
        }
        return RSASecurIdAuthenticatorConstants.AUTHENTICATOR_FRIENDLY_NAME;
    }

    /**
     * Check authentication request can be handled or not.
     *
     * @param request http servlet request to the authenticator
     * @return TRUE if RSA_USER_PASSCODE exists otherwise FALSE
     */
    @Override
    public boolean canHandle(HttpServletRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("Inside RSA SecurId Authenticator canHandle()");
        }
        String pin = request.getParameter(RSASecurIdAuthenticatorConstants.RSA_USER_PIN);
        String token = request.getParameter(RSASecurIdAuthenticatorConstants.RSA_USER_TOKEN);
        if (log.isDebugEnabled()) {
            log.debug("RSA PIN is not empty: " + StringUtils.isNotEmpty(pin) + ", RSA token is not empty: "
                    + StringUtils.isNotEmpty(token));
        }
        return (StringUtils.isNotEmpty(pin) && StringUtils.isNotEmpty(token));
    }

    /**
     * Allowing user for retrying another attempt
     *
     * @return TRUE or FALSE
     */
    protected boolean retryAuthenticationEnabled() {
        return true;
    }

    /**
     * Initiating th authentication request to RSA Authenticator
     *
     * @param request               http servlet request to the authentication framework
     * @param response              http servlet response from authentication framework
     * @param authenticationContext authenticationContext contains information about authentication
     *                              flow
     * @throws AuthenticationFailedException Throwing the authenticationFailedException
     */
    @Override
    protected void initiateAuthenticationRequest(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 AuthenticationContext authenticationContext)
            throws AuthenticationFailedException {

        log.debug("Hola Mundo");
        if (log.isDebugEnabled()) {
            log.debug("Inside the initiateAuthenticationRequest of RSA SecurID Authenticator");
        }
        Map<String, String> rsaSecurIdParameters = getAuthenticatorConfig().getParameterMap();
        String login = rsaSecurIdParameters.get(RSASecurIdAuthenticatorConstants.RSASECURID_AUTHENTICATION_ENDPOINT_URL);
        String rsaLoginPage;
        String retryParam = "";
        try {
            if (authenticationContext.isRetrying()) {
                if (log.isDebugEnabled()) {
                    log.debug("Retrying is enabled for RSA SecurID Authenticator");
                }
                retryParam = RSASecurIdAuthenticatorConstants.RETRY_PARAMS;
            }
            rsaLoginPage = ConfigurationFacade.getInstance().getAuthenticationEndpointURL()
                    .replace(RSASecurIdAuthenticatorConstants.LOGIN_PAGE, login);
            String queryParams = FrameworkUtils
                    .getQueryStringWithFrameworkContextId(authenticationContext.getQueryParams(),
                            authenticationContext.getCallerSessionKey(),
                            authenticationContext.getContextIdentifier());
            response.sendRedirect(response.encodeRedirectURL(rsaLoginPage
                    + "?" + queryParams + retryParam));
        } catch (IOException e) {
            throw new AuthenticationFailedException("RSA SecurId Authenticator could not handle the inputs " +
                    "and outputs", e);
        }
    }

    /**
     * Get the previously authenticated local user
     *
     * @param authenticationContext authenticationContext contains information about authentication
     * @return authenticatedUser information
     */
    private AuthenticatedUser getUsername(AuthenticationContext authenticationContext) {
        AuthenticatedUser authenticatedUser = null;
        for (int i = 1; i <= authenticationContext.getSequenceConfig().getStepMap().size(); i++) {
            StepConfig stepConfig = authenticationContext.getSequenceConfig().getStepMap().get(i);
            if (stepConfig.getAuthenticatedUser() != null && stepConfig.getAuthenticatedAutenticator()
                    .getApplicationAuthenticator() instanceof LocalApplicationAuthenticator) {
                authenticatedUser = stepConfig.getAuthenticatedUser();
                break;
            }
        }
        return authenticatedUser;
    }

    /**
     * Get the context identifier of authentication flow
     *
     * @param request http servlet request to the authentication framework
     * @return sessionDataKey
     */
    @Override
    public String getContextIdentifier(HttpServletRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("Context Identifier( SESSION_DATA_KEY ): " + request.getParameter(FrameworkConstants.SESSION_DATA_KEY));
        }
        return request.getParameter(FrameworkConstants.SESSION_DATA_KEY);
    }

    /**
     * Get the name of the RSA SecurId authenticator
     *
     * @return name of the authenticator
     */
    @Override
    public String getName() {
        return RSASecurIdAuthenticatorConstants.AUTHENTICATOR_NAME;
    }

    /**
     * Processing and validating the authentication
     *
     * @param request               http servlet request to the authentication framework
     * @param response              http servlet response from the authentication framework
     * @param authenticationContext authenticationContext contains information about authentication
     *                              flow
     * @throws AuthenticationFailedException
     */
    @Override
    protected void processAuthenticationResponse(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 AuthenticationContext authenticationContext)
            throws AuthenticationFailedException {
        if (log.isDebugEnabled()) {
            log.debug("Inside the processAuthenticationResponse of RSA SecurID Authenticator");
        }
        Map<String, String> rsaSecurIdParameters = getAuthenticatorConfig().getParameterMap();
        int authStatus;
        AuthenticatedUser authenticatedUser = getUsername(authenticationContext);
        String username = authenticatedUser.getAuthenticatedSubjectIdentifier().split("@")[0];
        if (log.isDebugEnabled()) {
            log.debug("User name: " + username);
        }
        String tenantDomain = authenticatedUser.getTenantDomain();
        int tenantId = IdentityTenantUtil.getTenantId(tenantDomain);
        RealmService realmService = IdentityTenantUtil.getRealmService();
        UserRealm userRealm;
        String rsaUserId;
        try {
            userRealm = realmService.getTenantUserRealm(tenantId);
            if (log.isDebugEnabled()) {
                log.debug("User Realm is not null: " + (userRealm != null));
            }
            rsaUserId = userRealm.getUserStoreManager()
                    .getUserClaimValue(username, RSASecurIdAuthenticatorConstants.RSASecurId_CLAIM, null);
            if (log.isDebugEnabled()) {
                log.debug("RSA User ID: " + rsaUserId);
            }
        } catch (UserStoreException e) {
            if (log.isDebugEnabled()) {
                log.debug(e);
            }
            throw new AuthenticationFailedException("Error occurred while loading user realm or user store manager : ",
                    e);
        }
        String pin = request.getParameter(RSASecurIdAuthenticatorConstants.RSA_USER_PIN);
        String token = request.getParameter(RSASecurIdAuthenticatorConstants.RSA_USER_TOKEN);
        String passCode = pin.concat(token);
        /*
        AuthSessionFactory authSessionFactory;
        if (StringUtils.isNotEmpty(rsaUserId) && StringUtils.isNotEmpty(passCode)) {
            AuthSession session = null;
            if (log.isDebugEnabled()) {
                log.debug("RSA Second Step Authentication Started.");
            }
            String configPath = rsaSecurIdParameters.get(RSASecurIdAuthenticatorConstants.RSASECURID_PROPERTY_FILE);
            if (log.isDebugEnabled()) {
                log.debug("RSA ConfigPath: " + configPath);
            }
            try {
                authSessionFactory = AuthSessionFactory.getInstance(configPath);
                if (log.isDebugEnabled()) {
                    log.debug("Auth session factory is not null: " + (authSessionFactory != null));
                }
            } catch (Throwable e) {
                String message = "Error in :"+configPath;
                if (log.isDebugEnabled()) {
                    log.debug(message, e);
                }
                throw new AuthenticationFailedException(message, e);
            }
            try {
                session = authSessionFactory.createUserSession();
                if (log.isDebugEnabled()) {
                    log.debug("Auth session is not null: " + (session != null));
                }
                session.lock(rsaUserId);
                if (log.isDebugEnabled()) {
                    log.debug("RSA UserId Locked");
                }
                authStatus = session.check(rsaUserId, passCode);
                if (log.isDebugEnabled()) {
                    log.debug("Auth Status: " + authStatus);
                }
                if (authStatus == AuthSession.ACCESS_OK) {
                    authenticationContext.setSubject(authenticatedUser);
                } else {
                    String message= "User enters invalid pass code";
                    if (log.isDebugEnabled()) {
                        log.debug(message);
                    }
                    throw new AuthenticationFailedException(message);
                }
            } catch (Throwable e) {
                String message = "Authentication Agent failed to create connection to authSessionFactory.";
                if (log.isDebugEnabled()) {
                    log.debug(message,e);
                }
                throw new AuthenticationFailedException(message, e);
            } finally {
                if (authSessionFactory != null) {
                    try {
                        session.close();
                        authSessionFactory.shutdown();
                    } catch (Throwable e) {
                        log.error("AuthSessionFactory does not shutdown", e);
                    }
                }
            }
        } else {
            String message = "RSA pass code is empty";
            if (log.isDebugEnabled()) {
                log.debug(message);
            }
            throw new AuthenticationFailedException(message);

        }
*/

        //REST API CALL
        //Read the Radiobutton option selected in the Front
        String value = request.getParameter("command");
        principal(value);

        //We go back to the Front (only for demo purposes)
        try {
            request.setAttribute("nombre", "Hola");
            request.getRequestDispatcher("login.do").forward(request, response);
            //request.getRequestDispatcher("https://localhost:9443/authenticationendpoint/retry.do?sp=travelocity.com/tenantDomain=carbon.super").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}