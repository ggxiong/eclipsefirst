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
 * 测试dao层工作
 * 推荐spring的项目可以使用spring的单元测试，可以重点注入我们需要的组件
 * 1.导入spring-test模块（jar包）
 * 2.@ContextConfiguration指定spring配置文件的位置
 * 3.@RunWith(SpringJUnit4ClassRunner.class)
 * 4.使用@Autowired来自动装配我们要的组件
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
		
		
		//1.插入几个部门
//		deptMapper.insertSelective(new Dept(null, "开发部"));
//		deptMapper.insertSelective(new Dept(null, "测试部"));
//		deptMapper.insertSelective(new Dept(null, "销售部"));
		deptMapper.insertSelective(new Dept(null, "数据部"));
		
		
//		System.out.println(empMapper);
//		System.out.println(deptMapper);
		
		//2.生成员工数据，测试员工插入
		
//		empMapper.insertSelective(new Emp(null, "Jerry", "M", "Jerry@blb.com", 1));
		
		//3.批量插入多个员工，批量，使用可以执行批量的sqlSession
//		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//		for(int i=0;i<1000;i++) {
//			String uuid = UUID.randomUUID().toString().substring(0, 5)+i;
//			mapper.insertSelective(new Emp(null, uuid, "M", uuid+"@blb.com", 1));
//		}
//		System.out.println("批量完成");
		
		
	}
	

}
