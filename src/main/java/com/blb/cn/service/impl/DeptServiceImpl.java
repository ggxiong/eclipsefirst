package com.blb.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.cn.bean.Dept;
import com.blb.cn.dao.DeptMapper;
import com.blb.cn.service.DeptServiceInterface;


@Service
public class DeptServiceImpl implements DeptServiceInterface {

	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<Dept> getAll() {
		// TODO Auto-generated method stub
		return deptMapper.selectByExample(null);
	}
	
	
	
	
	
}
