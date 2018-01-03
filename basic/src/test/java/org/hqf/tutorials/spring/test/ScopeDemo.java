package org.hqf.tutorials.spring.test;

import org.hqf.tutorials.spring.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemo {
    @Test
    public void getUserBySpring(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Scope.xml");
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");

        Assert.assertNotNull(user1);
        Assert.assertNotEquals(user1,user2);
        System.out.println("user = " + user1);

    }

    /**
     * Scope = Singleton
     * */

    @Test
    public void getUserSingletonBySpring(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Scope.xml");
        User user1 = (User) context.getBean("userSingleton");
        User user2 = (User) context.getBean("userSingleton");

        Assert.assertNotNull(user1);
        Assert.assertEquals(user1,user2);
        System.out.println("user = " + user1);

    }
}
