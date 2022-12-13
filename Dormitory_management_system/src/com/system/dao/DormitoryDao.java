package com.system.dao;

import java.util.List;

import com.system.bean.Dormitory;

public interface DormitoryDao {

	List<Dormitory> listDormitoryAll();

	String updateScore(String did, String score);

}
