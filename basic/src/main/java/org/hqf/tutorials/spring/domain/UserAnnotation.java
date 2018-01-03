package org.hqf.tutorials.spring.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component("userAnnotation")
//@Service
//@Controller
//@Repository
@Scope(scopeName = "prototype")
public class UserAnnotation {
    private long id;

    @Value("Frank Huo")//通过反射直接赋值
    private String name;

    private int age;

    public UserAnnotation() {

    }

    public UserAnnotation(String name, int age, Role role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    private Role role;
    private CarAnnotaion car;


    public CarAnnotaion getCar() {
        return car;
    }

    @Resource(name = "car")
    public void setCar(CarAnnotaion car) {
        this.car = car;
    }


    public Role getRole() {
        return role;
    }

    //
//    @Autowired
//    @Qualifier("")
//@Resource(role)
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
        System.out.println("Set User Name");
    }

    public int getAge() {
        return age;
    }

    @Value("19")//通过Set方法复制，推荐使用方法
    public void setAge(int age) {
        this.age = age;
        System.out.println("Set User Age");
    }

    private void destory() {
        System.out.println("destroy User");
    }

    private void init() {
        System.out.println("init User");
    }


    @Override
    public String toString() {
        return String.format("Id:{%s},name:{%s},age:{%s},role:{%s},car:{%s}", id, name, age, role, car);
    }


}