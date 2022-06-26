package com.securid.entities.cancel;

public class JSONObjectCancel {

	private String reason;
	private String authnAttemptId;
	private boolean removeAttemptId;
	
	
	public JSONObjectCancel() {
		// TODO Auto-generated constructor stub
	}


	public JSONObjectCancel(String reason, String authnAttemptId, boolean removeAttemptId) {
		super();
		this.reason = reason;
		this.authnAttemptId = authnAttemptId;
		this.removeAttemptId = removeAttemptId;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getAuthnAttemptId() {
		return authnAttemptId;
	}


	public void setAuthnAttemptId(String authnAttemptId) {
		this.authnAttemptId = authnAttemptId;
	}


	public boolean isRemoveAttemptId() {
		return removeAttemptId;
	}


	public void setRemoveAttemptId(boolean removeAttemptId) {
		this.removeAttemptId = removeAttemptId;
	}
	
	
}
