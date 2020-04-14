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
 * ʹ��spring����ģ���ṩ�Ĳ��������ܣ�����crud�����׼ȷ��
 * spring4���Ե�ʱ����Ҫservlet3.0����֧��
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
	
	
	//����mvc���󣬻�ȡ��������
	MockMvc mocMvc;
	
	
	//����junit��before��������ʾ��һ��ִ�еķ���
	@Before
	public void initMockMvc(){
		
		mocMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//ģ�ⷢ�������õ�����ֵ -----��perform����
		MvcResult andReturn = mocMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
	
	   //����ɹ��Ժ��������л���pageInfo�����ǿ���ȡ��pageinfo������֤
		MockHttpServletRequest request = andReturn.getRequest();
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
	
		System.out.println("��ǰҳ��"+pi.getPageNum());
		System.out.println("��ҳ��"+pi.getPages());
		System.out.println("�ܼ�¼��"+pi.getTotal());
		System.out.println("��ҳ����Ҫ������ʾ��ҳ��");
		int[] nums = pi.getNavigatepageNums();
	
		for (int i : nums) {
			System.out.print(" "+i);
		}
		
		//��ȡԱ������
		List<Emp> list = pi.getList();
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
		
	}

}
