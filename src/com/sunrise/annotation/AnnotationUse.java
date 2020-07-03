package com.sunrise.annotation;

/**
 * 目的：不改变任何代码，可以任意创建对象，可以调用任意方法
 * 自定义注解的作用：注解后期作用主要用来替换配置文件
 */

@AnnoUser(className = "com.sunrise.annotation.demo1",methodName = "show")
public class AnnotationUse {
    public static void main(String[] args) {
        //1.获取类的字节码文件
        Class<AnnotationUse> au = AnnotationUse.class;
        //2.获取注解对象
        AnnoUser an = au.getAnnotation(AnnoUser.class);
        //3.调用注解中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);
    }
}
