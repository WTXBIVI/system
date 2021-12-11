package com.system.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		String method = request.getParameter("method");
		//使用反射通过方法名动态获取方法对象,从而执行方法，好处是以后不管方法名或方法的个数怎么改，都不需要再改调用方法的语句（即下面的语句）
		try {
			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			method2.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
//		if(method.equals("login")) {
//			//loginServlet
//			login(request,response);
//		}else {
//			//registServlet
//			regist(request,response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

