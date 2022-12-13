package com.system.service.impl;

import java.util.List;

import com.system.bean.Dormitory;
import com.system.dao.DormitoryDao;
import com.system.dao.impl.DormitoryDaoImpl;
import com.system.service.DormitoryService;

public class DormitoryServiceImpl implements DormitoryService {

	private DormitoryDao dormitoryDao = new DormitoryDaoImpl();
	
	@Override
	public List<Dormitory> listDormitoryAll() {
		List<Dormitory> list = dormitoryDao.listDormitoryAll();
		return list;
	}

	@Override
	public String updateScore(String did, String score) {
		String msg = dormitoryDao.updateScore(did,score);
		return msg;
	}

}
