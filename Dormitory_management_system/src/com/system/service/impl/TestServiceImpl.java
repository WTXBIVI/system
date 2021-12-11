package com.system.service.impl;

import java.util.List;

import com.system.bean.Test;
import com.system.dao.TestDao;
import com.system.dao.impl.TestDaoImpl;
import com.system.service.TestService;

public class TestServiceImpl implements TestService {

	private TestDao testDao = new TestDaoImpl();
	
	@Override
	public List<Test> getTestAll() {
		List<Test> list = testDao.getTestAll();
		return list;
	}

}
