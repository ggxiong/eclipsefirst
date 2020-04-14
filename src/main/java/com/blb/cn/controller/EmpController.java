package com.blb.cn.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blb.cn.bean.Emp;
import com.blb.cn.bean.Msg;
import com.blb.cn.service.EmpServcieInterface;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmpController {
	
	@Autowired
	EmpServcieInterface empService;
	
//	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn
			,Map<String, Object> map) {
		//引用PageHelper分页插件，实现分页效果
		//查询之前只需调用PageHelper
		PageHelper.startPage(pn, 5);
		
		List<Emp> emps =  empService.getAll();
		//把获得的集合封装到PageInfo对象中，可以获得很多属性值
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps);
		
		map.put("pageInfo", pageInfo);
		
		return "list";
	}
	
	
	/**
	 * 返回json数据的方法
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsByJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn
			) {
		//引用PageHelper分页插件，实现分页效果
		//查询之前只需调用PageHelper
		PageHelper.startPage(pn, 5);
		
		List<Emp> emps =  empService.getAll();
		//把获得的集合封装到PageInfo对象中，可以获得很多属性值
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps);
		
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	
	
	//@Valid代表要用到JSR303校验，
	@RequestMapping("/emps")
	@ResponseBody
	public Msg saveEmp(@Valid Emp emp ,BindingResult result,Map<String, Object> map) {
		if(result.hasErrors()) {
			//校验失败，应该返回失败，在页面实现校验失败的错误信息
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			for (FieldError fieldError : fieldErrors) {
				System.out.println("错误的字段："+fieldError.getField());
				System.out.println("错误信息:"+fieldError.getDefaultMessage());
				//把错误的信息放入map集合中，在页面通过作用域取出来
			    map.put(fieldError.getField(), fieldError.getDefaultMessage());
				
			}
			
			return Msg.fail().add("error", map);
			
		}else {
			
			empService.getAll();
			return Msg.success();
		}
		
	}
	

}
