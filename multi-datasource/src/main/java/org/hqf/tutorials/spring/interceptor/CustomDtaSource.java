package org.hqf.tutorials.spring.interceptor;

import org.hqf.tutorials.spring.constants.DataSourceTypeEnum;

import java.lang.annotation.*;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public  @interface CustomDtaSource {
    DataSourceTypeEnum value() default DataSourceTypeEnum.Master;
}
