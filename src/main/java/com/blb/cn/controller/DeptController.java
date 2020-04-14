package com.blb.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blb.cn.bean.Dept;
import com.blb.cn.bean.Msg;
import com.blb.cn.service.DeptServiceInterface;

@Controller
public class DeptController {
	
	@Autowired
	DeptServiceInterface deptService;
	
	
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDept() {
		
		List<Dept> all = deptService.getAll();
		
		
		return Msg.success().add("dept", all);
	}
	
	

}
