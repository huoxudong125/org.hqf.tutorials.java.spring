package org.hqf.tutorials.spring.test;

import org.hqf.tutorials.spring.domain.UserAnnotation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {

    @Test
    public void getUserBySpring(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_Annotation.xml");
        UserAnnotation user = (UserAnnotation) context.getBean("userAnnotation");

        Assert.assertNotNull(user);
        System.out.println("user = " + user);
    }
}
