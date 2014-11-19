package com.blackice.utils;

import com.blackice.beans.CentralDbService;

public class SpringUtils {

	public static CentralDbService getBean(Class<CentralDbService> class1) {
		System.out.println("_________ SpringUtils.getBean(" + class1.getSimpleName() + ")");
		return null;
	}

}
