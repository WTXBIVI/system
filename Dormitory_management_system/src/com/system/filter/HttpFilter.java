package com.system.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HttpFilter
 */
public abstract class HttpFilter implements Filter {

	private FilterConfig filterConfig;
    public HttpFilter() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rs = (HttpServletResponse)response;
		doFilter(rq, rs, chain);
	}
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

	
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}


	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	
}
