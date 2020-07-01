package com.sunrise.annotation;

/**
 * 自定义注解
 * 注解本质：public interface com.sunrise.annotation.MyAnnotation extends java.lang.annotation.Annotation {}
 * 属性：1.整型、字符串、枚举对象，数组，注解类型；2.对应属性需要赋值；3.属性只有1个并且名称是value，可以省略属性
 */
public @interface MyAnnotation {
    //注解方法:
    int value();
     /*
    int show1();
    String show2();
    Person p1();
    String[] str();
    */
}
