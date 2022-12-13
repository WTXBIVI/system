package com.system.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.bean.Admin;
import com.system.bean.Student;
import com.system.service.AdminService;
import com.system.service.StudentService;
import com.system.service.impl.AdminServiceImpl;
import com.system.service.impl.StudentServiceImpl;

public class LoginServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentService studentService = new StudentServiceImpl();
	private AdminService adminService = new AdminServiceImpl();
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() +"/pages/login.jsp");
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		if("0".equals(type)) {
			Student student = new Student();
			student.setSid(username);
			student.setPassword(password);
			Student user = studentService.getStudent(student);//验证登录，如果有该用户，则返回该用户的所有信息
			if(user==null) {
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() +"/pages/home.jsp");
			}
		
		}else {
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			Admin user = adminService.getAdmin(admin);
			if(user==null) {
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() +"/pages/home.jsp");
			}
		}
		
		
	}
}
