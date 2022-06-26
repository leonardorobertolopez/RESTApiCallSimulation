package com.securid.entities.response.Initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "methodId", "methodResponseCode", "methodReasonCode", "authnAttributes" })

public class CredentialValidationResults {

	private String methodId;

	private String methodResponseCode;

	private String methodReasonCode;
	private AuthnAttributes[] authnAttributes;

	public CredentialValidationResults() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthnAttributes[] getAuthnAttributes() {
		return authnAttributes;
	}

	public void setAuthnAttributes(AuthnAttributes[] authnAttributes) {
		this.authnAttributes = authnAttributes;
	}

	public String getMethodId() {
		return methodId;
	}

	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	public String getMethodResponseCode() {
		return methodResponseCode;
	}

	public void setMethodResponseCode(String methodResponseCode) {
		this.methodResponseCode = methodResponseCode;
	}

	public String getMethodReasonCode() {
		return methodReasonCode;
	}

	public void setMethodReasonCode(String methodReasonCode) {
		this.methodReasonCode = methodReasonCode;
	}

	@Override
	public String toString() {
		return "ClassPojo [authnAttributes = " + authnAttributes + ", methodId = " + methodId
				+ ", methodResponseCode = " + methodResponseCode + ", methodReasonCode = " + methodReasonCode + "]";
	}

	public CredentialValidationResults(String methodId, String methodResponseCode, String methodReasonCode,
			AuthnAttributes[] authnAttributes) {

		this.methodId = methodId;
		this.methodResponseCode = methodResponseCode;
		this.methodReasonCode = methodReasonCode;
		this.authnAttributes = authnAttributes;
	}

}
