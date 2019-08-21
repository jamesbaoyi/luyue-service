package cn.baoyi.luyue.common.utils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: qijigui
 * @CreateDate: 2019/8/15 10:38
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataConvert {

    /**
     * 原始数据
     *
     * @return
     */
    String oldData();

    /**
     * 转化后的数据
     *
     * @return
     */
    String newData();

    /**
     * 类型
     */
    String type();
}
