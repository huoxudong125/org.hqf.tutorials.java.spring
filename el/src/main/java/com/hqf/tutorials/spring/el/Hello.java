package com.hqf.tutorials.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/09/02
 */
@Configuration
public class Hello {


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        System.out.println("init the spring context finished. ");

        ElDemo elDemo = (ElDemo) ctx.getBean("elDemo");
        elDemo.invokeMethod();
    }


}
