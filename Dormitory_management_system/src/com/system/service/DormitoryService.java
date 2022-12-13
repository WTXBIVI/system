package com.system.service;

import java.util.List;

import com.system.bean.Dormitory;

public interface DormitoryService {

	List<Dormitory> listDormitoryAll();

	String updateScore(String did, String score);

}
