package com.management.doc.binder.service.impl;

/**
 * @author pratapsapkota
 *
 */
public interface Category {

	/*
	 * VEHICLE("vehicle"), EDUCATION("education"), INSURANCE("insurance"),
	 * HEALTH("health"), TAX("tax"), BANK("bank"), HOUSEHOLD("household"),
	 * PERSONALIDENTIFACTION("personIdentification"),
	 * PERSONALDOCUMENT("personalDocument"), MISCELLANEOUS("miscellaneous");
	 * 
	 * private String name;
	 * 
	 * private Category(String name){ this.name = name; }
	 * 
	 * public String getName() { return name; }
	 */
	enum HEALTH implements Category {
		RECORD, BILL,
	}

	enum INSURACE implements Category {
		HEALTH_INSURANCE, VEHICLE_INSURANCE, HOUSE_INSURANCE,
	}

	enum HOUSEHOLD implements Category {
		ELECTRICITY_BILL, INTERNET_BILL, SEWEGE_BILL, WATER_BILL, KITCHEN_BILL,
	}

	enum TAX implements Category {
		INCOME_TAX,

	}
	
	enum PERSONAL_DOC implements Category {
		PERSONAL,
	}

	enum EDUCATION implements Category {
		BACHELOR, ADVANCE, HIGHER, SECONDARY
	}

	enum BANK implements Category {
		STATEMENT, CHEQUE
	}

}
