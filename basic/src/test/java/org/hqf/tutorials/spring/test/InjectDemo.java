package org.hqf.tutorials.spring.test;

import org.hqf.tutorials.spring.domain.CollectionBean;
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


    @Test
    public void getUserBySpringNamespaceInject(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Inject.xml");
        User user = (User) context.getBean("userNamespaceInject");

        Assert.assertNotNull(user);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserBySpringExpressionLanguageInject(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Inject.xml");
        User user = (User) context.getBean("userSpringExpressionLanguage");

        Assert.assertNotNull(user);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserBySpringComplexInject(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Inject.xml");
        CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");

        Assert.assertNotNull(collectionBean);
        System.out.println("collectionBean = " + collectionBean);
    }



}
