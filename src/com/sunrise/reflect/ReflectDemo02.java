package com.sunrise.reflect;

import java.lang.reflect.Field;

/**
 * 1.获取成员变量getFields(),只能获取public修饰符变量；
 *
 */
public class ReflectDemo02 {
    public static void main(String[] args) {
        Class p1 = Person.class;
        Field[] field = p1.getFields();
        for (Field f : field) {
            System.out.println(f);
        }
    }
}
