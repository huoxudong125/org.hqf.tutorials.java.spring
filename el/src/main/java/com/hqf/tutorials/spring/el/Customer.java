package com.hqf.tutorials.spring.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
@Component("customerBean")
public class Customer {

    @Value("#{'hqf'.toUpperCase()}")
    private String name;

    @Value("#{priceBean.getSpecialPrice()}")
    private double amount;

    //getter and setter...省略

    @Override
    public String toString() {
        return "Customer [name=" + name + ", amount=" + amount + "]";
    }

    public Customer() {
        System.out.println("init customer bean");
    }
}
