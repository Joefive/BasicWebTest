package com.sunrise.reflect;

public class Person {
    private String name;
    private int age;

    public String a;
    public String b;


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public void test() {
        System.out.println("Person...test...used!");
    }

    public void test(String name) {
        System.out.println(name + "Person...test...used!");
    }
}
