package com.securid.entities;



public class JSONObjectInitialize {
	private int authnAttemptTimeout;
	private String clientId;
	private String subjectName;
	private String lang;
	private String assurancePolicyId;
	private Context context;
	
	
	public int getAuthnAttemptTimeout() {
		return authnAttemptTimeout;
	}

	public void setAuthnAttemptTimeout(int authnAttemptTimeout) {
		this.authnAttemptTimeout = authnAttemptTimeout;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getAssurancePolicyId() {
		return assurancePolicyId;
	}

	public void setAssurancePolicyId(String assurancePolicyId) {
		this.assurancePolicyId = assurancePolicyId;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public JSONObjectInitialize(int authnAttemptTimeout, String clientId, String subjectName, String lang,
			String assurancePolicyId, Context context) {
		super();
		this.authnAttemptTimeout = authnAttemptTimeout;
		this.clientId = clientId;
		this.subjectName = subjectName;
		this.lang = lang;
		this.assurancePolicyId = assurancePolicyId;
		this.context = context;
	}

	public JSONObjectInitialize() {
	}
}
