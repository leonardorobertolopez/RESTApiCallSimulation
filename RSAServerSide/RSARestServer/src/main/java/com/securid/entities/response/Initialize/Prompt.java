package com.securid.entities.response.Initialize;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "promptResourceId", "defaultText", "formatRegex", "defaultValue", "valueBeingDefined", "sensitive",
		"minLength", "maxLength", "promptArgs" })
public class Prompt {
	private String promptResourceId;
	private String defaultText;
	private String formatRegex;
	private String defaultValue;
	private String valueBeingDefined;
	private String sensitive;
	private String minLength;
	private String maxLength;
	private String[] promptArgs;

	public Prompt() {
		// TODO Auto-generated constructor stub
	}

	public Prompt(String promptResourceId, String defaultText, String formatRegex, String defaultValue,
			String valueBeingDefined, String sensitive, String minLength, String maxLength, String[] promptArgs) {
		super();
		this.promptResourceId = promptResourceId;
		this.defaultText = defaultText;
		this.formatRegex = formatRegex;
		this.defaultValue = defaultValue;
		this.valueBeingDefined = valueBeingDefined;
		this.sensitive = sensitive;
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.promptArgs = promptArgs;
	}

	public String getFormatRegex() {
		return formatRegex;
	}

	public void setFormatRegex(String formatRegex) {
		this.formatRegex = formatRegex;
	}

	public String getValueBeingDefined() {
		return valueBeingDefined;
	}

	public void setValueBeingDefined(String valueBeingDefined) {
		this.valueBeingDefined = valueBeingDefined;
	}

	public String[] getPromptArgs() {
		return promptArgs;
	}

	public void setPromptArgs(String[] promptArgs) {
		this.promptArgs = promptArgs;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getMinLength() {
		return minLength;
	}

	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}

	public String getDefaultText() {
		return defaultText;
	}

	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
	}

	public String getSensitive() {
		return sensitive;
	}

	public void setSensitive(String sensitive) {
		this.sensitive = sensitive;
	}

	public String getPromptResourceId() {
		return promptResourceId;
	}

	public void setPromptResourceId(String promptResourceId) {
		this.promptResourceId = promptResourceId;
	}

	public String getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public String toString() {
		return "Prompt [promptResourceId=" + promptResourceId + ", defaultText=" + defaultText + ", formatRegex="
				+ formatRegex + ", defaultValue=" + defaultValue + ", valueBeingDefined=" + valueBeingDefined
				+ ", sensitive=" + sensitive + ", minLength=" + minLength + ", maxLength=" + maxLength + ", promptArgs="
				+ Arrays.toString(promptArgs) + "]";
	}
}
