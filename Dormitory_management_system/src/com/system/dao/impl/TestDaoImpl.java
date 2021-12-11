package com.system.dao.impl;

import java.util.List;

import com.system.bean.Test;
import com.system.dao.BaseDao;
import com.system.dao.TestDao;

public class TestDaoImpl extends BaseDao<Test> implements TestDao {

	@Override
	public List<Test> getTestAll() {
		String sql = "select id,name from test";
		List<Test> list = this.getBeanList(sql, null);
		return list;
	}

}
