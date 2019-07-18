package org.hqf.tutorials.spring.domain;

import lombok.Data;

import java.util.Date;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/18
 */
public class Customer {

    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        System.out.println(new Date().toString() +" address = " + address);
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
