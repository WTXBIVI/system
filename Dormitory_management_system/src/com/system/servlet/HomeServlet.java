package com.system.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.bean.Student;
import com.system.service.StudentService;
import com.system.service.impl.StudentServiceImpl;

public class HomeServlet extends BaseServlet{

	private StudentService studentService = new StudentServiceImpl();	
	
	
	public void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
//		request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
	}
	
	

	public void toHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath()+"/pages/home.jsp");
	}
}
