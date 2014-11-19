package com.blackice.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomerUtils implements Filter {

	
	public static String getCustomer() {
		
		return null;
	}

	 private static ThreadLocal conversation = new ThreadLocal();
	  
	  public void doFilter(ServletRequest request, ServletResponse response,
	      FilterChain chain) throws IOException, ServletException {
	    String conversationId = null;
	    if (request instanceof HttpServletRequest) {
	      conversationId = ((HttpServletRequest) request).getRequestURI();
	    }
	    conversation.set(conversationId);
	    try {
	      chain.doFilter(request, response);
	    } finally {
	      conversation.remove();
	    }
	  }

	  public void init(FilterConfig config) throws ServletException {
	  }

	  public void destroy() {
	  }

	public static String getConversationId() {
		
		return "";
	}
}
