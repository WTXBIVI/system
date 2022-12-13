package com.system.service.impl;

import java.util.List;

import com.system.bean.Repair;
import com.system.dao.RepairDao;
import com.system.dao.impl.RepairDaoImpl;
import com.system.service.RepairService;

public class RepairServiceImpl implements RepairService {

	private RepairDao repairDao = new RepairDaoImpl();
	@Override
	public List<Repair> listRepairAll() {
		List<Repair> listRepair = repairDao.listRepairAll();
		return listRepair;
	}
	@Override
	public String updateContentByRid(String content, String rid) {
		String msg = repairDao.updateContentByRid(content, rid);
		return msg;
	}
	@Override
	public String updateRepair(Repair repair, String rid_back) {
		String msg = repairDao.updateRepair(repair,rid_back);
		return msg;
	}
	@Override
	public String deleteBill(String rid) {
		String msg = repairDao.deleteBill(rid);
		return msg;
	}
	@Override
	public String addBill(Repair repair) {
		String msg = repairDao.addBill(repair);
		return msg;
	}

}
