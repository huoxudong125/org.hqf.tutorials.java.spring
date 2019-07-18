package org.hqf.tutorials.spring;

import org.hqf.tutorials.spring.domain.Customer;
import org.hqf.tutorials.spring.service.CustomerDataService;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

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
@EnableSpringConfigured
public class CachableTest {

    private static ClassPathXmlApplicationContext context;

    private CustomerDataService customerDataService;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("spring-main.xml");

        CachableTest cachableTest = new CachableTest();
        cachableTest.testCache();

    }

    private void testCache() {
        customerDataService = (CustomerDataService) context.getBean("customerDataService");
        Customer customer = new Customer();
        customer.setName("zhangsan");
        customer.setAddress("beijing");

        for (int i = 0; i < 100; i++) {

            String address = customerDataService.getAddress(customer);
            System.out.println("address = " + address);
        }
    }


}
