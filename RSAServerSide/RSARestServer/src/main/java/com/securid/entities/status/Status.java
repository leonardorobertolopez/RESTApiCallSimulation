package com.securid.entities.status;

public class Status {

	private String authnAttemptId;
	private String removeAttemptId;

	public Status() {
		// TODO Auto-generated constructor stub
	}

	public String getAuthnAttemptId() {
		return authnAttemptId;
	}

	public void setAuthnAttemptId(String authnAttemptId) {
		this.authnAttemptId = authnAttemptId;
	}

	public String getRemoveAttemptId() {
		return removeAttemptId;
	}

	public void setRemoveAttemptId(String removeAttemptId) {
		this.removeAttemptId = removeAttemptId;
	}

	public Status(String authnAttemptId, String removeAttemptId) {
		super();
		this.authnAttemptId = authnAttemptId;
		this.removeAttemptId = removeAttemptId;
	}

	@Override
	public String toString() {
		return "Status [authnAttemptId=" + authnAttemptId + ", removeAttemptId=" + removeAttemptId + "]";
	}

}
