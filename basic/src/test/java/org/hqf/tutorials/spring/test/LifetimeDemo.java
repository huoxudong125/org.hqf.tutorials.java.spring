package org.hqf.tutorials.spring.test;

import org.hqf.tutorials.spring.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifetimeDemo {

    @Test
    public void getUserBySpring(){

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Lifetime.xml");
        User user = (User) context.getBean("user");

        Assert.assertNotNull(user);
        System.out.println("user = " + user);

        context.close();
    }


}
