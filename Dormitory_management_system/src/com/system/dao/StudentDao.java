package com.system.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.system.bean.Admin;
import com.system.bean.Student;

public interface StudentDao {

	Student getStudent(Student student);

	List<Student> getStudentAll();

	List<Student> listStudentPage(Map<String, Object> paramMap);

	Integer getTotal(String condition);

	Student getStudentById(String sid);

	Boolean updateStudent(String sidback,Student student);

	Boolean deleteStudentById(String sid);

	Boolean addStudent(Student student);

	List<Student> listStudentByDid(String did);

	String deleteStudentDid(String sid);


}
