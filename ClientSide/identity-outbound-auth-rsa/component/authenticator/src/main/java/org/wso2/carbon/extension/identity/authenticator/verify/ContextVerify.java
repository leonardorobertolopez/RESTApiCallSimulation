package org.wso2.carbon.extension.identity.authenticator.verify;

public class ContextVerify {

	@Override
	public String toString() {
		return "Context [authnAttemptId=" + authnAttemptId + ", messageId=" + messageId + ", inResponseTo="
				+ inResponseTo + "]";
	}

	private String authnAttemptId;
	private String messageId;
	private String inResponseTo;

	public String getInResponseTo() {
		return inResponseTo;
	}

	public void setInResponseTo(String inResponseTo) {
		this.inResponseTo = inResponseTo;
	}

	public String getAuthnAttemptId() {
		return authnAttemptId;
	}

	public void setAuthnAttemptId(String authnAttemptId) {
		this.authnAttemptId = authnAttemptId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public ContextVerify() {
		// TODO Auto-generated constructor stub
	}

	public ContextVerify(String authnAttemptId, String messageId, String inResponseTo) {
		this.authnAttemptId = authnAttemptId;
		this.messageId = messageId;
		this.inResponseTo = inResponseTo;
	}

	
	
	
}
