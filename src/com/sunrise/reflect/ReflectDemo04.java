package com.sunrise.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo04 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.获取类对象字节码文件
        Class personClass = Person.class;
        //2.指定获取方法
        Method test = personClass.getMethod("test");
        //3.创建对象
        Person p = new Person();
        //4.获取方法中传入对象
        test.invoke(p);
        System.out.println("============================");

        Method test1 = personClass.getMethod("test", String.class);
        test1.invoke(p,"张一");
        System.out.println("============================");

        //获取类对象所有方法，继承了Object对象
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            //获取方法名称
            String name = method.getName();
            System.out.println(name);
        }

        //获取类名
        String name = personClass.getName();
        System.out.println(name);
    }

}
