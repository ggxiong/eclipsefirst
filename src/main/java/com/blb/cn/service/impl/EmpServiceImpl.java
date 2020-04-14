package com.blb.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.cn.bean.Emp;
import com.blb.cn.dao.EmpMapper;
import com.blb.cn.service.EmpServcieInterface;

@Service
public class EmpServiceImpl implements  EmpServcieInterface{

	@Autowired
	EmpMapper empMapper;
	
	/**
	 * 查询所有员工
	 */
	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return empMapper.selectByExampleWithDept(null);
	}

	
}
