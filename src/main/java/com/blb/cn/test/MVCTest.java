package com.blb.cn.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.blb.cn.bean.Emp;
import com.github.pagehelper.PageInfo;

/**
 * 使用spring测试模块提供的测试请求功能，测试crud请求的准确性
 * spring4测试的时候，需要servlet3.0以上支持
 * 
 * @author Shinelon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:springmvc.xml"})
public class MVCTest {
	
	@Autowired
	WebApplicationContext  context;
	
	
	//虚拟mvc请求，获取到处理结果
	MockMvc mocMvc;
	
	
	//这是junit的before，用来表示第一个执行的方法
	@Before
	public void initMockMvc(){
		
		mocMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//模拟发送请求拿到返回值 -----》perform方法
		MvcResult andReturn = mocMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
	
	   //请求成功以后，请求域中会有pageInfo；我们可以取出pageinfo进行验证
		MockHttpServletRequest request = andReturn.getRequest();
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
	
		System.out.println("当前页码"+pi.getPageNum());
		System.out.println("总页码"+pi.getPages());
		System.out.println("总记录数"+pi.getTotal());
		System.out.println("在页面需要连续显示的页码");
		int[] nums = pi.getNavigatepageNums();
	
		for (int i : nums) {
			System.out.print(" "+i);
		}
		
		//获取员工数据
		List<Emp> list = pi.getList();
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
		
	}

}
