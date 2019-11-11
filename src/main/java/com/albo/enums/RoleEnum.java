package com.albo.enums;

public enum RoleEnum {

	COLORIST("colorist"),
	WRITER("writer"),
	EDITOR("editor");


	String value;

	private RoleEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
