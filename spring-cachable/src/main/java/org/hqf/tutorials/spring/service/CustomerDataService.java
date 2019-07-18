package org.hqf.tutorials.spring.service;

import org.hqf.tutorials.spring.domain.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

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
@Component
public class CustomerDataService {

    @Cacheable(value = "addresses", key = "#customer.name")
    public String getAddress(Customer customer) {
        return customer.getAddress();
    }
}