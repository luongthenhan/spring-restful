/*
 *  Copyright 2016 luongthenhan
 */
package vn.khmt.spring.restful;

/**
 *
 * @author TheNhan
 */
class User {

    String name;
    int age;

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

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age=" + age + '}';
    }

}
