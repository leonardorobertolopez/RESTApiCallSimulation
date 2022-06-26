package org.wso2.carbon.extension.identity.authenticator.entities.initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "context", "credentialValidationResults", "attemptResponseCode", "attemptReasonCode",
		"challengeMethods" })
public class MyPojo {
	// context, credentialValidationResults, attemptResponseCode,
	// attemptReasonCode,challengeMethods
	private Context context;
	private CredentialValidationResults[] credentialValidationResults;
	private String attemptResponseCode;
	private String attemptReasonCode;
	private ChallengeMethods challengeMethods;

	public String getAttemptResponseCode() {
		return attemptResponseCode;
	}

	public void setAttemptResponseCode(String attemptResponseCode) {
		this.attemptResponseCode = attemptResponseCode;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public CredentialValidationResults[] getCredentialValidationResults() {
		return credentialValidationResults;
	}

	public void setCredentialValidationResults(CredentialValidationResults[] credentialValidationResults) {
		this.credentialValidationResults = credentialValidationResults;
	}

	public String getAttemptReasonCode() {
		return attemptReasonCode;
	}

	public void setAttemptReasonCode(String attemptReasonCode) {
		this.attemptReasonCode = attemptReasonCode;
	}

	public ChallengeMethods getChallengeMethods() {
		return challengeMethods;
	}

	public void setChallengeMethods(ChallengeMethods challengeMethods) {
		this.challengeMethods = challengeMethods;
	}

	public MyPojo() {
		// TODO Auto-generated constructor stub
	}

	// context, credentialValidationResults, attemptResponseCode, attemptReasonCode,
	// challengeMethods

	public MyPojo(Context context, CredentialValidationResults[] credentialValidationResults,
			String attemptResponseCode, String attemptReasonCode, ChallengeMethods challengeMethods) {

		this.context = context;
		this.credentialValidationResults = credentialValidationResults;
		this.attemptResponseCode = attemptResponseCode;
		this.attemptReasonCode = attemptReasonCode;
		this.challengeMethods = challengeMethods;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MyPojo " + "\n" + "[context=" + context + ",\n" + "credentialValidationResults="
				+ Arrays.toString(credentialValidationResults) + ",\n" + "attemptResponseCode=" + attemptResponseCode
				+ "\n" + " attemptReasonCode=" + attemptReasonCode + "\n" + " challengeMethods=" + challengeMethods + "\n" + "]";
	}

}
