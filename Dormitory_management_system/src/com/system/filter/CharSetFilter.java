package com.system.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharSetFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String code = this.getFilterConfig().getInitParameter("code");
		request.setCharacterEncoding(code);
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);
	}
}
