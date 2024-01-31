package com.polishchuk.mschool.enums;

public enum QuestionType {
	RADIOBUTTON("radio"),
	CHECKBOX("check"),
	TEXTFIELD("text"),
	COMPLIANCE("comp");

	private final String tag;

	QuestionType(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public static QuestionType getQTypeByTag(String tag) {

		for (QuestionType qtype : values())
			if (qtype.getTag().equals(tag))
				return qtype;

		return null;
	}
}
