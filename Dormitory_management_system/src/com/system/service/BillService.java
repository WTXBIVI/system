package com.system.service;

import java.util.List;

import com.system.bean.Bill;

public interface BillService {

	List<Bill> listBillAll();

	String updateBill(Bill bill,String bid_back);

	String deleteBill(String bid);

	String addBill(Bill bill);


}
