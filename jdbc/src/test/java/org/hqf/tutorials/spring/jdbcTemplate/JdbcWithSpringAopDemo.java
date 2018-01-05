package org.hqf.tutorials.spring.jdbcTemplate;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.hqf.tutorials.spring.jdbcTemplate.bean.User;

//演示JDBC模板
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_jdbc.xml")
public class JdbcWithSpringAopDemo {

	@Resource(name="userDao")
	private UserDao ud;

	@Test
	public void Add() throws Exception{
		User u = new User();
		u.setName("tom");
		ud.save(u);
	}
	@Test
	public void fun3() throws Exception{
		User u = new User();
		u.setId(2);
		u.setName("jack");
		ud.update(u);
		
	}
	
	@Test
	public void fun4() throws Exception{
		ud.delete(2);
	}
	
	@Test
	public void fun5() throws Exception{
		System.out.println(ud.getTotalCount());
	}
	
	@Test
	public void fun6() throws Exception{
		System.out.println(ud.getById(1));
	}
	
	@Test
	public void fun7() throws Exception{
		System.out.println(ud.getAll());
	}
	
}
