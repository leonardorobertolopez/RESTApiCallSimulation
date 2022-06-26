package com.securid.entities.status;

import java.util.Arrays;

public class MyPojoStatus {
	private String attemptResponseCode;
	private String attemptReasonCode;
	private String subjectName;
	private String authnPolicyId;
	private String assuranceLevel;
	private SessionAttributes[] sessionAttributes;
	private String[] successfulMethods;
	private String attemptExpires;

	public MyPojoStatus() {
		// TODO Auto-generated constructor stub
	}

	public MyPojoStatus(String attemptResponseCode, String attemptReasonCode, String subjectName, String authnPolicyId,
			String assuranceLevel, SessionAttributes[] sessionAttributes, String[] successfulMethods,
			String attemptExpires) {
		super();
		this.attemptResponseCode = attemptResponseCode;
		this.attemptReasonCode = attemptReasonCode;
		this.subjectName = subjectName;
		this.authnPolicyId = authnPolicyId;
		this.assuranceLevel = assuranceLevel;
		this.sessionAttributes = sessionAttributes;
		this.successfulMethods = successfulMethods;
		this.attemptExpires = attemptExpires;
	}

	public String getAttemptResponseCode() {
		return attemptResponseCode;
	}

	public void setAttemptResponseCode(String attemptResponseCode) {
		this.attemptResponseCode = attemptResponseCode;
	}

	public String getAttemptReasonCode() {
		return attemptReasonCode;
	}

	public void setAttemptReasonCode(String attemptReasonCode) {
		this.attemptReasonCode = attemptReasonCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getAuthnPolicyId() {
		return authnPolicyId;
	}

	public void setAuthnPolicyId(String authnPolicyId) {
		this.authnPolicyId = authnPolicyId;
	}

	public String getAssuranceLevel() {
		return assuranceLevel;
	}

	public void setAssuranceLevel(String assuranceLevel) {
		this.assuranceLevel = assuranceLevel;
	}

	public SessionAttributes[] getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(SessionAttributes[] sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public String[] getSuccessfulMethods() {
		return successfulMethods;
	}

	public void setSuccessfulMethods(String[] successfulMethods) {
		this.successfulMethods = successfulMethods;
	}

	public String getAttemptExpires() {
		return attemptExpires;
	}

	public void setAttemptExpires(String attemptExpires) {
		this.attemptExpires = attemptExpires;
	}

	@Override
	public String toString() {
		return "MyPojoStatus [attemptResponseCode=" + attemptResponseCode + ", attemptReasonCode=" + attemptReasonCode
				+ ", subjectName=" + subjectName + ", authnPolicyId=" + authnPolicyId + ", assuranceLevel="
				+ assuranceLevel + ", sessionAttributes=" + Arrays.toString(sessionAttributes) + ", successfulMethods="
				+ Arrays.toString(successfulMethods) + ", attemptExpires=" + attemptExpires + "]";
	}

}
