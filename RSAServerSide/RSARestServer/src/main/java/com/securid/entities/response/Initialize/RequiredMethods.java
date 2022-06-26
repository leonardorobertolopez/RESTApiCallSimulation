package com.securid.entities.response.Initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "methodId", "displayName", "priority", "versions" })
public class RequiredMethods {
	private String methodId;
	private String displayName;
	private String priority;
	private Versions[] versions;

	public RequiredMethods() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public RequiredMethods(String methodId, String displayName, String priority, Versions[] versions) {
		super();
		this.methodId = methodId;
		this.displayName = displayName;
		this.priority = priority;
		this.versions = versions;
	}



	public Versions[] getVersions() {
		return versions;
	}

	public void setVersions(Versions[] versions) {
		this.versions = versions;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getMethodId() {
		return methodId;
	}

	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "ClassPojo [versions = " + versions + ", displayName = " + displayName + ", methodId = " + methodId
				+ ", priority = " + priority + "]";
	}
}
