package com.system.dao.impl;

import java.util.List;

import com.system.bean.Repair;
import com.system.dao.BaseDao;
import com.system.dao.RepairDao;

public class RepairDaoImpl extends BaseDao<Repair> implements RepairDao {

	@Override
	public List<Repair> listRepairAll() {
		String sql = "select * from repair";
		List<Repair> listRepair = this.getBeanList(sql);
		return listRepair;
	}

	@Override
	public String updateContentByRid(String content, String rid) {
		try {
			String sql = "update repair set content = ? where rid = ?";
			this.update(sql,content,rid);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	@Override
	public String updateRepair(Repair repair, String rid_back) {
		try {
			String sql = "update repair set rid = ?,sid = ?,time = ?,situation = ? where rid = ?";
			this.update(sql, repair.getRid(),repair.getSid(),repair.getTime(),repair.getSituation(),rid_back);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	@Override
	public String deleteBill(String rid) {
		try {
			String sql = "delete from repair where rid = ?";
			this.update(sql, rid);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
		
	}

	@Override
	public String addBill(Repair repair) {
		try {
			String sql = "insert into repair(rid,sid,time,situation) values(?,?,?,?)";
			this.update(sql, repair.getRid(),repair.getSid(),repair.getTime(),repair.getSituation());
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

}
