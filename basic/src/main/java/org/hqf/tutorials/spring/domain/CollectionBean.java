package org.hqf.tutorials.spring.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollectionBean {

    private Object[] array;

    private List list;

    private Map map;

    private Properties props;

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "CollectioBean{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", map=" + map +
                ", props=" + props +
                '}';
    }
}
