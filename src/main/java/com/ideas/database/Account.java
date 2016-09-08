package com.ideas.database;

public class Account {

	private String name2;

	private String birtDate2;

	private String type2;

	public String getName2() {
		return name2;
	}

	public String getBirtDate2() {
		return birtDate2;
	}

	public String getType2() {
		return type2;
	}

	public String getMobile2() {
		return mobile2;
	}

	public String getPan_no2() {
		return pan_no2;
	}

	private String mobile2;

	private String pan_no2;

	public Account(String name, String birtDate, String type, String mobile, String pan_no) {
		name2 = name;
		birtDate2 = birtDate;
		type2 = type;
		mobile2 = mobile;
		pan_no2 = pan_no;

	}

}
