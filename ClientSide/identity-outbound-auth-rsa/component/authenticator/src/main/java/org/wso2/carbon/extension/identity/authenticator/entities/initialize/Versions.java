package org.wso2.carbon.extension.identity.authenticator.entities.initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"versionId", "methodAttributes" , "valueRequired" , "referenceId" , "prompt" })
public class Versions {
	private String versionId;
    private MethodAttributes[] methodAttributes;
    private String valueRequired;
    private String referenceId;
    private Prompt prompt;

    public Versions() {
		// TODO Auto-generated constructor stub
	}
    
    

    public Versions(String versionId, MethodAttributes[] methodAttributes, String valueRequired, String referenceId,
			Prompt prompt) {
		super();
		this.versionId = versionId;
		this.methodAttributes = methodAttributes;
		this.valueRequired = valueRequired;
		this.referenceId = referenceId;
		this.prompt = prompt;
	}



	public String getVersionId ()
    {
        return versionId;
    }

    public void setVersionId (String versionId)
    {
        this.versionId = versionId;
    }

    public MethodAttributes[] getMethodAttributes ()
    {
        return methodAttributes;
    }

    public void setMethodAttributes (MethodAttributes[] methodAttributes)
    {
        this.methodAttributes = methodAttributes;
    }

    public String getValueRequired ()
    {
        return valueRequired;
    }

    public void setValueRequired (String valueRequired)
    {
        this.valueRequired = valueRequired;
    }

    public Prompt getPrompt ()
    {
        return prompt;
    }

    public void setPrompt (Prompt prompt)
    {
        this.prompt = prompt;
    }

    public String getReferenceId ()
    {
        return referenceId;
    }

    public void setReferenceId (String referenceId)
    {
        this.referenceId = referenceId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [versionId = "+versionId+", methodAttributes = "+methodAttributes+", valueRequired = "+valueRequired+", prompt = "+prompt+", referenceId = "+referenceId+"]";
    }
}
