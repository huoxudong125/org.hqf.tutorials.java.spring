package org.hqf.tutorials.spring.constants;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
public enum DataSourceTypeEnum {
    // 主库
    Master("master"),

    // 从库
    Slave("slave"),

    //  主库
    GoldMaster("master"),

    //  从库
    GoldSlave("slave");

    private DataSourceTypeEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
