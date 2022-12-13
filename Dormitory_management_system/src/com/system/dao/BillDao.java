package com.system.dao;

import java.util.List;

import com.system.bean.Bill;

public interface BillDao {

	List<Bill> listBillAll();

	String updateBill(Bill bill,String bid_back);

	String deleteBill(String bid);

	String addBill(Bill bill);

}
