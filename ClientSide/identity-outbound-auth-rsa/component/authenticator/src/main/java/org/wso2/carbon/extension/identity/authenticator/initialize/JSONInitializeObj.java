package org.wso2.carbon.extension.identity.authenticator.initialize;

public class JSONInitializeObj {
	private String clientId;

	private String assurancePolicyId;

	private String authnAttemptTimeout;

	private Context context;

	private String lang;

	private String subjectName;

	public JSONInitializeObj() {
		// TODO Auto-generated constructor stub
	}

	public JSONInitializeObj(String authnAttemptTimeout, String clientId, String subjectName, String lang,
			String assurancePolicyId, Context context) {
		super();
		this.clientId = clientId;
		this.assurancePolicyId = assurancePolicyId;
		this.authnAttemptTimeout = authnAttemptTimeout;
		this.context = context;
		this.lang = lang;
		this.subjectName = subjectName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAssurancePolicyId() {
		return assurancePolicyId;
	}

	public void setAssurancePolicyId(String assurancePolicyId) {
		this.assurancePolicyId = assurancePolicyId;
	}

	public String getAuthnAttemptTimeout() {
		return authnAttemptTimeout;
	}

	public void setAuthnAttemptTimeout(String authnAttemptTimeout) {
		this.authnAttemptTimeout = authnAttemptTimeout;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "[clientId : " + clientId + ", assurancePolicyId = " + assurancePolicyId
				+ ", authnAttemptTimeout = " + authnAttemptTimeout + ", context = " + context + ", lang = " + lang
				+ ", subjectName = " + subjectName + "]";
	}
}
