package cn.baoyi.luyue.service.domain.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pay {

    //修饰member支持下面几种类型
    //1. A primitive type ： 基本类型（java的八种基本类型：byte、short、int、long、float、double、char、boolean）
    //2. String ： 字符串
    //3. Class ：Class
    //4. An enum type ： 枚举
    //5. An annotation type ：注解
    //6. An array type ：类型为以上任一类型的数组

    int personalId();

}
