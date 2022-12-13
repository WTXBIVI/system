package com.system.dao.impl;

import java.util.List;

import com.system.bean.Bill;
import com.system.dao.BaseDao;
import com.system.dao.BillDao;

public class BillDaoImpl extends BaseDao<Bill> implements BillDao {

	@Override
	public List<Bill> listBillAll() {
		String sql = "select * from bill";
		List<Bill> billList = this.getBeanList(sql);
		return billList;
	}

	@Override
	public String updateBill(Bill bill,String bid_back) {
		try {
			String sql = "UPDATE bill SET bid = ?,did = ?,money = ?,situation = ? WHERE bid = ?";
			this.update(sql, bill.getBid(),bill.getDid(),bill.getMoney(),bill.getSituation(),bid_back);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	@Override
	public String deleteBill(String bid) {
		try {
			String sql = "delete from bill where bid = ?";
			this.update(sql, bid);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	@Override
	public String addBill(Bill bill) {
		try {
			String sql = "insert into bill values(?,?,?,?)";
			this.update(sql, bill.getBid(),bill.getDid(),bill.getMoney(),bill.getSituation());
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	
}
