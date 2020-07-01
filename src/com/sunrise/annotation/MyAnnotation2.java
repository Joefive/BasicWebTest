package com.sunrise.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解：用来描述注解的注解
 * @Target描述能够作用的位置
 * @Retention描述保留的阶段
 * @Document描述注解是否会被抽取到文档中
 * @Inherited描述注解是否被子类继承
 */

@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD}) //注解作用与类、方法、变量
@Retention(RetentionPolicy.RUNTIME) //注解会被保留在字节码文件中，
public @interface MyAnnotation2 {
}
