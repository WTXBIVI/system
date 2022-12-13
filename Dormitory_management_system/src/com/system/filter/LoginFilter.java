package com.system.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.bean.Student;

public class LoginFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user")==null) {
			request.setAttribute("msg", "未登录请先登录");
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

}
