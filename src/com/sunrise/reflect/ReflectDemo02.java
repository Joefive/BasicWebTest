package com.sunrise.reflect;

import java.lang.reflect.Field;

/**
 * 1.获取成员变量  Field[] getFields(),只能获取public修饰符变量；
 *  getField()方法
 *  Field[] getDeclaredFields(),获取所有包括private修饰符变量；
 *  getDeclaredField()方法访问private成员变量，需要忽略安全监测setAccessible(true)，暴力反射
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        Class p1 = Person.class;
        Field[] field = p1.getFields();
        for (Field f : field) {
            System.out.println(f);
        }
        System.out.println("===================");

        Field a = p1.getField("a");
        Person p = new Person();
        Object o = a.get(p);
        System.out.println(o);
        a.set(p,"张三");
        System.out.println(p);
        System.out.println("===================");

        Field[] declaredFields = p1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("===================");

        Field age = p1.getDeclaredField("age");
        age.setAccessible(true);
        Object o1 = age.get(p);
        System.out.println(o1);


    }
}
