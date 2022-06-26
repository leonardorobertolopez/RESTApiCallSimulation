package org.wso2.carbon.extension.identity.authenticator.entities.status;

public class JSONObjectStatus {

	private String authnAttemptId;
	private String removeAttemptId;

	public JSONObjectStatus() {
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

	public JSONObjectStatus(String authnAttemptId, String removeAttemptId) {
		super();
		this.authnAttemptId = authnAttemptId;
		this.removeAttemptId = removeAttemptId;
	}

	@Override
	public String toString() {
		return "Status [authnAttemptId=" + authnAttemptId + ", removeAttemptId=" + removeAttemptId + "]";
	}

}
