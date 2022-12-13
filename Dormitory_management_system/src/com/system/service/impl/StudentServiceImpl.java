package com.system.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.system.bean.Admin;
import com.system.bean.Student;
import com.system.dao.StudentDao;
import com.system.dao.impl.StudentDaoImpl;
import com.system.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao =new StudentDaoImpl(); 
	
	@Override
	public Student getStudent(Student student) {
		Student stu = studentDao.getStudent(student);
		return stu;
	}

	@Override
	public List<Student> getStudentAll() {
		List<Student> list = studentDao.getStudentAll();
		return list;
	}

	@Override
	public List<Student> listStudentPage(Map<String, Object> paramMap) {
		List<Student> page = studentDao.listStudentPage(paramMap);
		return page;
	}

	@Override
	public Integer getTotal(String condition) {
		Integer total = studentDao.getTotal(condition);
		return total;
	}

	@Override
	public Student getStudentById(String sid) {
		Student student = studentDao. getStudentById(sid);
		return student;
	}

	@Override
	public Boolean updateStudent(String sidback,Student student) {
		Boolean bool = studentDao.updateStudent(sidback,student);
		return bool;
	}

	@Override
	public Boolean deleteStudentById(String sid) {
		Boolean bool = studentDao.deleteStudentById(sid);
		return bool;
	}

	@Override
	public Boolean addStudent(Student student) {
		Boolean bool = studentDao.addStudent(student);
		return bool;
	}

	@Override
	public List<Student> listStudentByDid(String did) {
		List<Student> list = studentDao.listStudentByDid(did);
		return list;
	}

	@Override
	public String deleteStudentDid(String sid) {
		String result = studentDao.deleteStudentDid(sid);
		return result;
	}


}
