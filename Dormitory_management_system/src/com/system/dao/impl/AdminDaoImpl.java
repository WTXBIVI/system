package com.system.dao.impl;

import com.system.bean.Admin;
import com.system.bean.Student;
import com.system.dao.AdminDao;
import com.system.dao.BaseDao;

public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {

	@Override
	public Admin getAdmin(Admin admin) {
		String sql = "SELECT * FROM admin WHERE username = ? AND `password` = ?";
		Admin adm = this.getBean(sql, admin.getUsername(),admin.getPassword());
		return adm;
	}

}
