package org.hqf.tutorials.spring.test;

import org.hqf.tutorials.spring.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

    @Test
    public void getUserBySpring(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_HelloWorld.xml");
        User user = (User) context.getBean("user");

        Assert.assertNotNull(user);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserByStaticFactory(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_HelloWorld.xml");
        User user = (User) context.getBean("userByStaticFactory");
        Assert.assertNotNull(user);

        System.out.println("userByStaticFactory user = " + user);
    }

    @Test
    public void getUserByFactory(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_HelloWorld.xml");
        User user = (User) context.getBean("userByFactory");
        Assert.assertNotNull(user);

        System.out.println(" userByStaticFactory user = " + user);
    }

}
