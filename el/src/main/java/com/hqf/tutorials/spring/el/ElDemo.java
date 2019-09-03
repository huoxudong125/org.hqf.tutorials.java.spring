package com.hqf.tutorials.spring.el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/09/03
 */
@Component("elDemo")
public class ElDemo {

    @Resource
    private Customer customer;

    public ElDemo() {
        System.out.println("init ElDemo");
        simpleFunc();
        invokeMethod();
    }

    private void simpleFunc() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println("message = " + message);
    }

    public void invokeMethod() {
        System.out.println(customer);
    }
}
