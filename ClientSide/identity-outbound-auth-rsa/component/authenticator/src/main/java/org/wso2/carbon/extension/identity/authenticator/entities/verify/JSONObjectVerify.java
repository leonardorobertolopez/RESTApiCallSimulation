package org.wso2.carbon.extension.identity.authenticator.entities.verify;

import org.wso2.carbon.extension.identity.authenticator.entities.initialize.SubjectCredentials;

import java.util.Arrays;



public class JSONObjectVerify {
	
    private SubjectCredentials[] subjectCredentials;
    private ContextVerify context;
    
    public ContextVerify getContext ()
    {
        return context;
    }

    public void setContext (ContextVerify context)
    {
        this.context = context;
    }

    public SubjectCredentials[] getSubjectCredentials ()
    {
        return subjectCredentials;
    }

    public void setSubjectCredentials (SubjectCredentials[] subjectCredentials)
    {
        this.subjectCredentials = subjectCredentials;
    }

    public JSONObjectVerify() {
		// TODO Auto-generated constructor stub
	}

	public JSONObjectVerify(SubjectCredentials[] subjectCredentials, ContextVerify ctx) {
		this.subjectCredentials = subjectCredentials;
		this.context = ctx;
	}


	@Override
	public String toString() {
		return "JSONObjectVerify {subjectCredentials=" + Arrays.toString(subjectCredentials) + ", context=" + context
				+ "]";
	}
    
    
    
}
