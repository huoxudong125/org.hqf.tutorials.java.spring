package org.hqf.tutorials.spring;

import org.hqf.tutorials.spring.constants.DataSourceTypeEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicDataSourceTest {

    private DynamicDataSource dynamicDataSource;

    @BeforeEach
    void setUp() {
        dynamicDataSource = new DynamicDataSource();
        // Clear any existing context before each test
        JdbcContextHolder.clear(); 
    }

    @AfterEach
    void tearDown() {
        // Ensure context is cleared after each test
        JdbcContextHolder.clear();
    }

    @Test
    void determineCurrentLookupKey_noContextSet() {
        // When no data source type is set in JdbcContextHolder, 
        // it should return the default (or null, depending on unmocked AbstractRoutingDataSource behavior)
        // For this test, we expect null or the default if one were configured in DynamicDataSource.
        // As per current DynamicDataSource, it will delegate to AbstractRoutingDataSource which might return null.
        Object key = dynamicDataSource.determineCurrentLookupKey();
        assertNull(key, "Lookup key should be null when no context is set");
    }

    @Test
    void determineCurrentLookupKey_masterSet() {
        JdbcContextHolder.set(DataSourceTypeEnum.MASTER);
        Object key = dynamicDataSource.determineCurrentLookupKey();
        assertEquals(DataSourceTypeEnum.MASTER, key, "Lookup key should be MASTER");
    }

    @Test
    void determineCurrentLookupKey_slaveSet() {
        JdbcContextHolder.set(DataSourceTypeEnum.SLAVE);
        Object key = dynamicDataSource.determineCurrentLookupKey();
        assertEquals(DataSourceTypeEnum.SLAVE, key, "Lookup key should be SLAVE");
    }

    @Test
    void determineCurrentLookupKey_setAndClear() {
        JdbcContextHolder.set(DataSourceTypeEnum.MASTER);
        assertEquals(DataSourceTypeEnum.MASTER, dynamicDataSource.determineCurrentLookupKey(), "Lookup key should be MASTER initially");
        
        JdbcContextHolder.clear();
        assertNull(dynamicDataSource.determineCurrentLookupKey(), "Lookup key should be null after clearing");
    }
    
    @Test
    void determineCurrentLookupKey_switchSource() {
        JdbcContextHolder.set(DataSourceTypeEnum.MASTER);
        assertEquals(DataSourceTypeEnum.MASTER, dynamicDataSource.determineCurrentLookupKey(), "Lookup key should be MASTER");
        
        JdbcContextHolder.set(DataSourceTypeEnum.SLAVE);
        assertEquals(DataSourceTypeEnum.SLAVE, dynamicDataSource.determineCurrentLookupKey(), "Lookup key should be SLAVE after switching");
    }
}
