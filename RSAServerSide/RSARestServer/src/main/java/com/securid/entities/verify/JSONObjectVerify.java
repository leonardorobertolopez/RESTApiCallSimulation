package com.securid.entities.verify;

import java.util.Arrays;

public class JSONObjectVerify {
	
    private SubjectCredentials[] subjectCredentials;
    private Context context;
    
    public Context getContext ()
    {
        return context;
    }

    public void setContext (Context context)
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

	public JSONObjectVerify(SubjectCredentials[] subjectCredentials, Context ctx) {
		this.subjectCredentials = subjectCredentials;
		this.context = ctx;
	}


	@Override
	public String toString() {
		return "JSONObjectVerify [subjectCredentials=" + Arrays.toString(subjectCredentials) + ", context=" + context
				+ "]";
	}
    
    
    
}
