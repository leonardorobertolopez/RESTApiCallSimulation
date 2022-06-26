package com.securid.entities.response.Initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder({ "authnAttemptId", "messageId", "inResponseTo" })
public class Context {
	
	    private String authnAttemptId;
	    private String messageId;
	    private String inResponseTo;

	    public Context() {
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	    
	    public Context(String authnAttemptId, String messageId, String inResponseTo ) {
			this.authnAttemptId = authnAttemptId;
			this.messageId = messageId;
			this.inResponseTo = inResponseTo;
		}




		public String getInResponseTo ()
	    {
	        return inResponseTo;
	    }

	    public void setInResponseTo (String inResponseTo)
	    {
	        this.inResponseTo = inResponseTo;
	    }

	    public String getAuthnAttemptId ()
	    {
	        return authnAttemptId;
	    }

	    public void setAuthnAttemptId (String authnAttemptId)
	    {
	        this.authnAttemptId = authnAttemptId;
	    }

	    public String getMessageId ()
	    {
	        return messageId;
	    }

	    public void setMessageId (String messageId)
	    {
	        this.messageId = messageId;
	    }




		@Override
		public String toString() {
			return "Context [authnAttemptId=" + authnAttemptId + ", messageId=" + messageId + ", inResponseTo="
					+ inResponseTo + "]";
		}

	   
}
