package com.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.bean.Test;
import com.system.service.TestService;
import com.system.service.impl.TestServiceImpl;

public class TestServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    
    private TestService testService = new TestServiceImpl();
    
    
    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	List<Test> list = testService.getTestAll();
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("/pages/test.jsp").forward(request, response);
    }
    
	 public void sum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	
	    	String parameter = request.getParameter("num");
	    	int num = Integer.parseInt(parameter);
	    	int result=0;
	    	for(int i = 1; i <= num ; i+=2) {
	    		result+=i;
	    	}
	    	request.setAttribute("result", result);
	    	request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
//	    	PrintWriter writer = response.getWriter();
//	    	Integer num1 = new Integer(result);
//	    	writer.write(num1.toString());
	   }
}
