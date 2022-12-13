package com.system.dao.impl;

import java.util.List;

import com.system.bean.Dormitory;
import com.system.dao.BaseDao;
import com.system.dao.DormitoryDao;

public class DormitoryDaoImpl extends BaseDao<Dormitory> implements DormitoryDao {

	@Override
	public List<Dormitory> listDormitoryAll() {
		String sql = "select * from dormitory";
		List<Dormitory> list = this.getBeanList(sql);
		return list;
	}

	@Override
	public String updateScore(String did, String score) {
		try {
			String sql = "update dormitory set score = ? where did = ?";
			this.update(sql, score, did);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

}
