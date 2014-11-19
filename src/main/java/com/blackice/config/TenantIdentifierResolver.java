package com.blackice.config;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver{
	
	 @Autowired
	private HttpServletRequest request;
	 
	@Override
	public String resolveCurrentTenantIdentifier() {
//		Map<String, String> map = new HashMap<String, String>();
//		 
//		Enumeration headerNames = request.getHeaderNames();
//		while (headerNames.hasMoreElements()) {
//			String key = (String) headerNames.nextElement();
//			String value = request.getHeader(key);
//			map.put(key, value);
//		}
//		System.out.println("*********** resolveCurrentTenantIdentifier ");
		System.out.println(request);
		return "id1";
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		// TODO Auto-generated method stub
		return false;
	}

}
