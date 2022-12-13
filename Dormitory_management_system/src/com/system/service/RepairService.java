package com.system.service;

import java.util.List;

import com.system.bean.Repair;

public interface RepairService {

	List<Repair> listRepairAll();

	String updateContentByRid(String content, String rid);

	String updateRepair(Repair repair, String rid_back);

	String deleteBill(String rid);

	String addBill(Repair repair);

}
