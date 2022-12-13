package com.system.service.impl;

import com.system.bean.Admin;
import com.system.dao.AdminDao;
import com.system.dao.impl.AdminDaoImpl;
import com.system.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao = new AdminDaoImpl();
	
	@Override
	public Admin getAdmin(Admin admin) {
		Admin adm = adminDao.getAdmin(admin);
		return adm;
	}

}
