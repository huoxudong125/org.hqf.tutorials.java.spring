package org.hqf.spring.transcaction.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.hqf.spring.transcaction.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTranactionDemo {
		@Resource(name="accountService")
	private AccountService as;
	
	@Test
	public void fun1(){
		
		as.transfer(1, 2, 100d);
		
	}
}
