package com.sunrise.reflect;

import java.lang.reflect.Constructor;

/**
 * getConstructor(par1,par2)创建构造器方法，要看对象原构造器中是否有参
 * 如果构造使用空参，操作就可以简化，可以使用Class.newInstance();
 */
public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Object o1 = constructor.newInstance("张一", 30);
        System.out.println(o1);
        System.out.println("============================");

        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        Object o2 = constructor1.newInstance();
        System.out.println(o2);
        System.out.println("============================");

        Object o = personClass.newInstance();
        System.out.println(o);
        System.out.println("============================");


    }
}
