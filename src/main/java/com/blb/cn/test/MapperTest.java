package com.blb.cn.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blb.cn.bean.Dept;
import com.blb.cn.bean.Emp;
import com.blb.cn.dao.DeptMapper;
import com.blb.cn.dao.EmpMapper;



/**
 * ����dao�㹤��
 * �Ƽ�spring����Ŀ����ʹ��spring�ĵ�Ԫ���ԣ������ص�ע��������Ҫ�����
 * 1.����spring-testģ�飨jar����
 * 2.@ContextConfigurationָ��spring�����ļ���λ��
 * 3.@RunWith(SpringJUnit4ClassRunner.class)
 * 4.ʹ��@Autowired���Զ�װ������Ҫ�����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MapperTest {
	
	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	DeptMapper deptMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		
		
		//1.���뼸������
//		deptMapper.insertSelective(new Dept(null, "������"));
//		deptMapper.insertSelective(new Dept(null, "���Բ�"));
//		deptMapper.insertSelective(new Dept(null, "���۲�"));
		deptMapper.insertSelective(new Dept(null, "���ݲ�"));
		
		
//		System.out.println(empMapper);
//		System.out.println(deptMapper);
		
		//2.����Ա�����ݣ�����Ա������
		
//		empMapper.insertSelective(new Emp(null, "Jerry", "M", "Jerry@blb.com", 1));
		
		//3.����������Ա����������ʹ�ÿ���ִ��������sqlSession
//		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//		for(int i=0;i<1000;i++) {
//			String uuid = UUID.randomUUID().toString().substring(0, 5)+i;
//			mapper.insertSelective(new Emp(null, uuid, "M", uuid+"@blb.com", 1));
//		}
//		System.out.println("�������");
		
		
	}
	

}
