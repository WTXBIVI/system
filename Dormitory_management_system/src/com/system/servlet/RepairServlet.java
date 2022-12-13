package com.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.system.bean.Repair;
import com.system.service.RepairService;
import com.system.service.impl.RepairServiceImpl;

public class RepairServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RepairService repairService = new RepairServiceImpl();
	
	public void toRepairIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath()+"/pages/repair/repairIndex.jsp");
		
	}
	
	public void init(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Repair> listRepair = repairService.listRepairAll();
		response.getWriter();
		response.setContentType("text/json");
		PrintWriter writer = response.getWriter();
		writer.print((JSON.toJSON(listRepair).toString()));
		
	}
	
	public void updateContentByRid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String content = request.getParameter("content");
		String rid = request.getParameter("rid");
		String msg = repairService.updateContentByRid(content,rid);
		PrintWriter writer = response.getWriter();
		writer.write(msg);
	}
	
	
	public void updateRepair(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rid_back = request.getParameter("rid_back");
		String rid = request.getParameter("rid");
		String sid = request.getParameter("sid");
		String time = request.getParameter("time");
		String situation = request.getParameter("situation");
		
		Repair repair = new Repair();
		
		repair.setRid(rid);
		repair.setSid(sid);
		repair.setTime(time);
		repair.setSituation(situation);
		String msg = repairService.updateRepair(repair,rid_back);
		PrintWriter writer = response.getWriter();
		writer.write(msg);
	}
	
	
	public void deleteBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rid = request.getParameter("rid");
		String msg = repairService.deleteBill(rid);
		
		PrintWriter writer = response.getWriter();
		writer.write(msg);
	}
	
	
	public void addBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rid = request.getParameter("rid");
		String sid = request.getParameter("sid");
		String time = request.getParameter("time");
		String situation = request.getParameter("situation");
		Repair repair = new Repair();
		
		repair.setRid(rid);
		repair.setSid(sid);
		repair.setTime(time);
		repair.setSituation(situation);
		String msg = repairService.addBill(repair);
		
		PrintWriter writer = response.getWriter();
		writer.write(msg);
	}
	
	

}
