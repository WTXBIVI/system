package com.system.service.impl;

import java.util.List;

import com.system.bean.Bill;
import com.system.dao.BillDao;
import com.system.dao.impl.BillDaoImpl;
import com.system.service.BillService;

public class BillServiceImpl implements BillService {

	private BillDao billDao = new BillDaoImpl();
	
	@Override
	public List<Bill> listBillAll() {
		List<Bill> billList = billDao.listBillAll();
		return billList;
	}

	@Override
	public String updateBill(Bill bill,String bid_back) {
		String msg = billDao.updateBill(bill,bid_back);
		return msg;
	}

	@Override
	public String deleteBill(String bid) {
		String msg = billDao.deleteBill(bid);
		return msg;
	}

	@Override
	public String addBill(Bill bill) {
		String msg = billDao.addBill(bill);
		return msg;
	}

}
