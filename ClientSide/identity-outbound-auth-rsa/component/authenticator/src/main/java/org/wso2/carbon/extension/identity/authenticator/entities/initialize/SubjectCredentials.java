package org.wso2.carbon.extension.identity.authenticator.entities.initialize;

import java.util.Arrays;

public class SubjectCredentials {
	private String methodId;
    private String referenceId;
    private String versionId;
    private CollectedInputs[] collectedInputs;
    
    public String getVersionId ()
    {
        return versionId;
    }

    public void setVersionId (String versionId)
    {
        this.versionId = versionId;
    }

    public CollectedInputs[] getCollectedInputs ()
    {
        return collectedInputs;
    }

    public void setCollectedInputs (CollectedInputs[] collectedInputs)
    {
        this.collectedInputs = collectedInputs;
    }

    public String getMethodId ()
    {
        return methodId;
    }

    public void setMethodId (String methodId)
    {
        this.methodId = methodId;
    }

    public String getReferenceId ()
    {
        return referenceId;
    }

    public void setReferenceId (String referenceId)
    {
        this.referenceId = referenceId;
    }

    public SubjectCredentials() {
		// TODO Auto-generated constructor stub
	}

	public SubjectCredentials(String methodId, String referenceId, String versionId,
			CollectedInputs[] collectedInputs) {
		super();
		this.methodId = methodId;
		this.referenceId = referenceId;
		this.versionId = versionId;
		this.collectedInputs = collectedInputs;
	}

	@Override
	public String toString() {
		return "SubjectCredentials [methodId=" + methodId + ", referenceId=" + referenceId + ", versionId=" + versionId
				+ ", collectedInputs=" + Arrays.toString(collectedInputs) + "]";
	}
    
    
    
}
