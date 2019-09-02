package com.hqf.tutorails.spring.el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

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
public class Hello {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println("message = " + message);
    }

}
