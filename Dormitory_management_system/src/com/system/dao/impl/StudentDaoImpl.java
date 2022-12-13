package com.system.dao.impl;

import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.system.bean.Student;
import com.system.dao.BaseDao;
import com.system.dao.StudentDao;

public class StudentDaoImpl extends BaseDao<Student> implements StudentDao{

	
	@Override
	public Student getStudent(Student student) {
		String sql = "SELECT * FROM student WHERE sid = ? AND `password` = ?";
		Student stu = this.getBean(sql, student.getSid(),student.getPassword());
		return stu;
	}

	@Override
	public List<Student> getStudentAll() {
		String sql = "select * from student";
		List<Student> list = this.getBeanList(sql);
		return list;
	}

	@Override
	public List<Student> listStudentPage(Map<String, Object> paramMap) {
		String condition = (String)paramMap.get("condition");
		Integer pageSize = (Integer)paramMap.get("pageSize");
		Integer pageNum = pageSize*((Integer)paramMap.get("pageNum")-1);
		if(StringUtils.isEmpty(condition)) {
			String sql = "select * from student limit ?,?";
			List<Student> list = this.getBeanList(sql,pageNum,pageSize);
			return list;
		}else {
			String sql = "select * from student where name like ? limit ?,?";
			List<Student> list = this.getBeanList(sql,"%"+condition+"%",pageNum,pageSize);
			return list;
		}
		
	}

	@Override
	public Integer getTotal(String condition) {
		if(StringUtils.isEmpty(condition)) {
			String sql1 = "select count(*) from student";
			Integer total = Integer.parseInt(this.getSingleValue(sql1)+"");;
			return total;
		}else {
			String sql1 = "select count(*) from student where name like ?";
			Integer total = Integer.parseInt(this.getSingleValue(sql1,"%"+condition+"%")+"");
			return total;
		}
		
	}

	@Override
	public Student getStudentById(String sid) {
		String sql = "select * from student where sid = ?";
		Student student = this.getBean(sql, sid);
		return student;
	}

	@Override
	public Boolean updateStudent(String sidback,Student student) {
		try {
			String sql = "UPDATE student SET sid = ?,name = ?,gender = ?,telephone = ?,did = ?,password = ? WHERE sid = ?";
			this.update(sql, student.getSid(),student.getName(),student.getGender(),student.getTelephone(),student.getDid(),student.getPassword(),sidback);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteStudentById(String sid) {
		try {
			String sql = "delete from student where sid = ?";
			this.update(sql, sid);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean addStudent(Student student) {
		try {
			String sql = "insert into student(sid,name,gender,telephone,did,password) values(?,?,?,?,?,?)";
			this.update(sql, student.getSid(),student.getName(),student.getGender(),student.getTelephone(),student.getDid(),student.getPassword());
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> listStudentByDid(String did) {
		String sql="SELECT * FROM student WHERE did = ?";
		List<Student> beanList = this.getBeanList(sql, did);
		return beanList;
	}

	@Override
	public String deleteStudentDid(String sid) {
		try {
			String sql="update student set did = '0' WHERE sid = ?";
			this.update(sql, sid);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no";
	}

	
}
