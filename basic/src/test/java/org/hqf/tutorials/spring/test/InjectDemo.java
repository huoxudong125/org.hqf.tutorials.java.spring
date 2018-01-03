package org.hqf.tutorials.spring.test;

import org.hqf.tutorials.spring.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectDemo {

    @Test
    public void getUserBySpringPropertyInject(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Inject.xml");
        User user = (User) context.getBean("user");

        Assert.assertNotNull(user);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserBySpringConstructorInject(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Inject.xml");
        User user = (User) context.getBean("userConstructor");

        Assert.assertNotNull(user);
        System.out.println("user = " + user);
    }



}
