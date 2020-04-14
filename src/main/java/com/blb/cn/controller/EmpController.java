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
		//����PageHelper��ҳ�����ʵ�ַ�ҳЧ��
		//��ѯ֮ǰֻ�����PageHelper
		PageHelper.startPage(pn, 5);
		
		List<Emp> emps =  empService.getAll();
		//�ѻ�õļ��Ϸ�װ��PageInfo�����У����Ի�úܶ�����ֵ
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps);
		
		map.put("pageInfo", pageInfo);
		
		return "list";
	}
	
	
	/**
	 * ����json���ݵķ���
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsByJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn
			) {
		//����PageHelper��ҳ�����ʵ�ַ�ҳЧ��
		//��ѯ֮ǰֻ�����PageHelper
		PageHelper.startPage(pn, 5);
		
		List<Emp> emps =  empService.getAll();
		//�ѻ�õļ��Ϸ�װ��PageInfo�����У����Ի�úܶ�����ֵ
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(emps);
		
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	
	
	//@Valid����Ҫ�õ�JSR303У�飬
	@RequestMapping("/emps")
	@ResponseBody
	public Msg saveEmp(@Valid Emp emp ,BindingResult result,Map<String, Object> map) {
		if(result.hasErrors()) {
			//У��ʧ�ܣ�Ӧ�÷���ʧ�ܣ���ҳ��ʵ��У��ʧ�ܵĴ�����Ϣ
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			for (FieldError fieldError : fieldErrors) {
				System.out.println("������ֶΣ�"+fieldError.getField());
				System.out.println("������Ϣ:"+fieldError.getDefaultMessage());
				//�Ѵ������Ϣ����map�����У���ҳ��ͨ��������ȡ����
			    map.put(fieldError.getField(), fieldError.getDefaultMessage());
				
			}
			
			return Msg.fail().add("error", map);
			
		}else {
			
			empService.getAll();
			return Msg.success();
		}
		
	}
	

}
