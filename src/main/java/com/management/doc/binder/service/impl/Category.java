package com.management.doc.binder.service.impl;

/**
 * @author pratapsapkota
 *
 */
public enum Category {

	VEHICLE("vehicle"),
	EDUCATION("education"),
	INSURANCE("insurance"),
	HEALTH("health"),
	TAX("tax"),
	BANK("bank"),
	HOUSEHOLD("household"),
	PERSONALIDENTIFACTION("personIdentification"),
	PERSONALDOCUMENT("personalDocument"),
	MISCELLANEOUS("miscellaneous");
	
	private String name;
	
	private Category(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
