package com.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.system.bean.Bill;
import com.system.service.BillService;
import com.system.service.impl.BillServiceImpl;

public class BillServlet extends BaseServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BillService billService = new BillServiceImpl(); 

	public void toBill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		List<Bill> BillList = billService.listBillAll();
//		request.setAttribute("billList", BillList);
//		request.getRequestDispatcher("/pages/bill/billIndex.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/pages/bill/billIndex.jsp");
	}
	
	public void init(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Bill> BillList = billService.listBillAll();
		request.setAttribute("billList", BillList);
//		request.getRequestDispatcher("/pages/bill/billIndex.jsp").forward(request, response);
		response.getWriter();
		response.setContentType("text/json");
		PrintWriter writer = response.getWriter();
		writer.print((JSON.toJSON(BillList).toString()));
	}
	
	
	
	public void updateBill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String bid = request.getParameter("bid");
		String did = request.getParameter("did");
		String money = request.getParameter("money");
		String situation = request.getParameter("situation");
		
		String bid_back = request.getParameter("bid_back");
		
		
		Bill bill = new Bill();
		bill.setBid(bid);
		bill.setDid(did);
		bill.setMoney(Double.parseDouble(money));
		bill.setSituation(situation);
		String msg = billService.updateBill(bill,bid_back);
		
		PrintWriter writer = response.getWriter();
		writer.write(msg);

		
	}
	
	public void deleteBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bid = request.getParameter("bid");
		String msg = billService.deleteBill(bid);
		PrintWriter writer = response.getWriter();
		writer.write(msg);
	}
	public void addBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String bid = request.getParameter("bid");
		String did = request.getParameter("did");
		String money = request.getParameter("money");
		String situation = request.getParameter("situation");
		Bill bill = new Bill();
		bill.setBid(bid);
		bill.setDid(did);
		bill.setMoney(Double.parseDouble(money));
		bill.setSituation(situation);
		String msg = billService.addBill(bill);
		PrintWriter writer = response.getWriter();
		writer.write(msg);
	}
}
