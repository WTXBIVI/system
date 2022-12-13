package com.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.system.bean.Student;
import com.system.service.StudentService;
import com.system.service.impl.StudentServiceImpl;

public class StudentServlet extends BaseServlet {
	
	private StudentService studentService = new StudentServiceImpl();
	
	public void toStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		Integer pageSize = 2;
		
		if(StringUtils.isEmpty(request.getParameter("pageNum"))) {
			pageNum=1;
		}
		String condition = request.getParameter("condition");
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("condition", condition);
		paramMap.put("pageSize", pageSize);
		paramMap.put("pageNum", pageNum);
	    List<Student> page = studentService.listStudentPage(paramMap);
	    Integer total = studentService.getTotal(condition);
	    Integer totalPage = total/2;
	    int z = total%2;
	    if(z>0) {
	    	totalPage+=1;
	    }
	    request.setAttribute("total", total);
	    request.setAttribute("totalPage", totalPage);
	    request.setAttribute("page", page);
	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("pageSize", pageSize);
	    request.setAttribute("pageSize", pageSize);
	    request.setAttribute("condition", condition);
		request.getRequestDispatcher("/pages/student/student.jsp").forward(request, response);
		
	}
	
	
	public void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		Student student = studentService.getStudentById(sid);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/pages/student/update.jsp").forward(request, response);
	}
	
	
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		String condition = request.getParameter("condition");
		
		
		
		String sid = request.getParameter("sid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String telephone = request.getParameter("telephone");
		String did = request.getParameter("did");
		String password = request.getParameter("password");
		String sidback = request.getParameter("sidback");
		
		Student student = new Student();
		
		student.setSid(sid);
		student.setName(name);
		student.setGender(gender);
		student.setTelephone(telephone);
		student.setDid(Integer.parseInt(did));
		student.setPassword(password);
		System.out.println(student.toString());
		Boolean bool = studentService.updateStudent(sidback,student);
		
		response.sendRedirect(request.getContextPath()+"/StudentServlet?method=toStudent&pageNum="+pageNum+"&condition="+condition);
		
		
	}
	
	
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("sid");
		String pageNum = request.getParameter("pageNum");
		String condition = request.getParameter("condition");
		
		Boolean bool = studentService.deleteStudentById(sid);
		request.getRequestDispatcher("/StudentServlet?method=toStudent&pageNum="+pageNum+"&condition="+condition).forward(request, response);

	}
	
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/pages/student/update.jsp").forward(request, response);
		
	}
	public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		String condition = request.getParameter("condition");
		
		String sid = request.getParameter("sid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String telephone = request.getParameter("telephone");
		String did = request.getParameter("did");
		String password = request.getParameter("password");

		Student student = new Student();
		
		student.setSid(sid);
		student.setName(name);
		student.setGender(gender);
		student.setTelephone(telephone);
		student.setDid(Integer.parseInt(did));
		student.setPassword(password);
		
		Boolean bool = studentService.addStudent(student);
		response.sendRedirect(request.getContextPath()+"/StudentServlet?method=toStudent&pageNum="+pageNum+"&condition="+condition);
	}
	
	
	public void listStudentByDid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String did = request.getParameter("did");
		List<Student> list = studentService.listStudentByDid(did);
		response.setContentType("text/json");
		PrintWriter writer = response.getWriter();
		writer.print((JSON.toJSON(list).toString()));
		
	}

	public void deleteStudentDid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String result = studentService.deleteStudentDid(sid);
		PrintWriter writer = response.getWriter();
		if("ok".equals(result)) {
			writer.write("ok");
		}else {
			writer.write("no");
		}
		
	}
}
