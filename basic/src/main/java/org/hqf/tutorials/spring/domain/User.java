package org.hqf.tutorials.spring.domain;

public class User {
    private long id;
    private String name;
    private int age;

    public User(){

    }

    public User(String name, int age, Role role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void destory() {
        System.out.println("destroy User");
    }

    private void init() {
        System.out.println("init User");
    }


    @Override
    public String toString() {
        return String.format("Id:{%s},name:{%s},age:{%s},role:{%s}", id, name, age, role);
    }


}