package org.hqf.tutorials.spring;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
public class JdbcContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setJdbcType(String jdbcType) {
        contextHolder.set(jdbcType);
    }

    public static void setSlave() {
        setJdbcType("slave");
    }

    public static void setMaster() {
        clearJdbcType();
    }

    public static String getJdbcType() {
        return (String) contextHolder.get();
    }

    public static void clearJdbcType() {
        contextHolder.remove();
    }
}
