package com.sunrise.reflect;

/**反射：就是把类中属性封装到一起；
 * 例如：1.成员变量进行封装；2.构造方法进行封装；3.成员方法进行封装。
 * 反射的获取方式：
 * 1.Class.forName("全类名"),多用于配置文件，类名定义在配置文件中进行加载；
 * 2.类名.class，多用于参数传递；
 * 3.对象.getClass(),Object对象中定义，多用于对象的获取字节码的方式。
 *
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls1 = Class.forName("com.sunrise.reflect.Person");
        System.out.println(cls1);
        Class cls2 = Person.class;
        System.out.println(cls2);
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
        boolean a = cls1==cls2;
        System.out.println(a);
        System.out.println(cls1==cls3);


    }
}
