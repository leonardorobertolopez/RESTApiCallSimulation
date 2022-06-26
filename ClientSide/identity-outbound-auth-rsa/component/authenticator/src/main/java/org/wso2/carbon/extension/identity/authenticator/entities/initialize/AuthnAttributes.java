package org.wso2.carbon.extension.identity.authenticator.entities.initialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "value", "dataType" })
public class AuthnAttributes {

	private String name;
	private String value;
	private String dataType;

	public AuthnAttributes() {
		// TODO Auto-generated constructor stub
	}

	public AuthnAttributes(String name, String value, String dataType) {
		this.name = name;
		this.value = value;
		this.dataType = dataType;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AuthnAttributes [name=" + name + ", value=" + value + ", dataType=" + dataType + "]";
	}

	
}
