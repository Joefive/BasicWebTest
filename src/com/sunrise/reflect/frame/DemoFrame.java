package com.sunrise.reflect.frame;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类，可以创建任意类的对象，在不改变任何代码前提，可以创建任意对象并执行方法
 * 依赖：1.配置文件；2.反射机制。
 */
public class DemoFrame {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties pro = new Properties();
        //2.获取类的字节码文件
        ClassLoader classLoader = DemoFrame.class.getClassLoader();
        //3.字节码文件获取资源文件
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        //4.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //5.加载类进内存
        Class cls = Class.forName(className);
        //6.创建对象
        Object obj = cls.newInstance();
        //7.获取方法
        Method method = cls.getMethod(methodName);
        //8.执行方法
        method.invoke(obj);

    }
}
