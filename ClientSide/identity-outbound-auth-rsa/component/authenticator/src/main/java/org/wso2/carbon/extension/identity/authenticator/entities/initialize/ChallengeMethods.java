package org.wso2.carbon.extension.identity.authenticator.entities.initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"challenges" })

public class ChallengeMethods {
	private Challenges[] challenges;
   
	public ChallengeMethods() {
		// TODO Auto-generated constructor stub
	}
	
	
	
    public ChallengeMethods(Challenges[] challenges) {
		super();
		this.challenges = challenges;
	}



	public Challenges[] getChallenges ()
    {
        return challenges;
    }

    public void setChallenges (Challenges[] challenges)
    {
        this.challenges = challenges;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [challenges = "+challenges+"]";
    }
}
