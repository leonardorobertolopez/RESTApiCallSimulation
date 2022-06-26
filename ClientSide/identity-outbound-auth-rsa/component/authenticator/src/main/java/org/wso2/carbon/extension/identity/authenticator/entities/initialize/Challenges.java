package org.wso2.carbon.extension.identity.authenticator.entities.initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"methodSetId", "requiredMethods" })
public class Challenges {
	 private String methodSetId;

	    private RequiredMethods[] requiredMethods;

	    
	    public Challenges() {
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	    public Challenges(String methodSetId, RequiredMethods[] requiredMethods) {
			super();
			this.methodSetId = methodSetId;
			this.requiredMethods = requiredMethods;
		}



		public String getMethodSetId ()
	    {
	        return methodSetId;
	    }

	    public void setMethodSetId (String methodSetId)
	    {
	        this.methodSetId = methodSetId;
	    }

	    public RequiredMethods[] getRequiredMethods ()
	    {
	        return requiredMethods;
	    }

	    public void setRequiredMethods (RequiredMethods[] requiredMethods)
	    {
	        this.requiredMethods = requiredMethods;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [methodSetId = "+methodSetId+", requiredMethods = "+requiredMethods+"]";
	    }
}
