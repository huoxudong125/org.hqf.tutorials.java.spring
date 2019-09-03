package com.hqf.tutorials.spring.el;

import lombok.Data;
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
@Component("priceBean")
@Data
public class Price {
    private long specialPrice;

    public Price() {
        System.out.println("init price");
        specialPrice = 10L;
    }
}
