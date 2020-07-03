package com.sunrise.annotation;

import java.lang.reflect.Method;

/**
 * 目的：不改变任何代码，可以任意创建对象，可以调用任意方法
 * 自定义注解的作用：注解后期作用主要用来替换配置文件
 */

@AnnoUser(className = "com.sunrise.annotation.AnnoDemo1",methodName = "show")
public class AnnotationUse {
    public static void main(String[] args) throws Exception {
        //1.获取类的字节码文件
        Class<AnnotationUse> au = AnnotationUse.class;
        //2.获取注解对象
        AnnoUser an = au.getAnnotation(AnnoUser.class);
        //3.调用注解中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //创建对象及调用方法
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);

    }
}
