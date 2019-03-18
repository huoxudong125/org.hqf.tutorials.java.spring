package org.hqf.tutorials.spring;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // 获取当前数据源连接
        return JdbcContextHolder.getJdbcType();
    }
}
