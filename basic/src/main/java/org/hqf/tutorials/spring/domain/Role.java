package org.hqf.tutorials.spring.domain;

public class Role {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role:" + name;
    }
}
