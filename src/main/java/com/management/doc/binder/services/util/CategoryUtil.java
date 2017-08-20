/**
 * 
 */
package com.management.doc.binder.services.util;

import com.management.doc.binder.service.impl.Category;

/**
 * @author ambarrana
 *
 */
public class CategoryUtil {
	
	public static Category getCategoryType(String category){
		
		switch(category){
			case "bachelor":
				return Category.EDUCATION.BACHELOR;
			case "advance":
				return Category.EDUCATION.ADVANCE;
			case "secondary":
				return Category.EDUCATION.SECONDARY;
			
			case "personal":
				return Category.PERSONAL_DOC.PERSONAL;
				
			case "electric":
				return Category.HOUSEHOLD.ELECTRICITY_BILL;
		
			case "internet":
				return Category.HOUSEHOLD.INTERNET_BILL;
			default:
				return Category.TAX.INCOME_TAX;
				
		}
		
	}
}
