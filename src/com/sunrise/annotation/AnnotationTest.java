package com.sunrise.annotation;

import java.util.Date;

@SuppressWarnings("all") //去掉警告
@MyAnnotation2
public class AnnotationTest {
    @Override //重写
    public String toString() {
        return super.toString();
    }
    @Deprecated  //过时
    public static void show(){
        System.out.println("show1");
    }
    public static void show2(){
        System.out.println("show2");
    }

    public static void main(String[] args) {
        show();
        show2();
        Date d = new Date();
        d.getDate();
    }
}
