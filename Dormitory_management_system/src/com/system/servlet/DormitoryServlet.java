package com.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.bean.Dormitory;
import com.system.service.DormitoryService;
import com.system.service.impl.DormitoryServiceImpl;


public class DormitoryServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DormitoryService dormitoryService = new DormitoryServiceImpl();
	
	public void toDormitory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		List<Dormitory> list = dormitoryService.listDormitoryAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/pages/dormitory/dormitory.jsp").forward(request, response);
		
	}
	
	
	public void updateScore(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String did = request.getParameter("did");
		String score = request.getParameter("score");
		String msg = dormitoryService.updateScore(did,score);
		PrintWriter writer = response.getWriter();
		writer.write(msg);
	}
}
