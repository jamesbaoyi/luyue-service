package cn.baoyi.luyue.service.domain.service;

import cn.baoyi.luyue.service.domain.annoation.Pay;
import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/13 9:39
 * @Description:
 */
@Configuration
public class StrategyFactory {


    private static HashMap<Integer, String> sourceMap = new HashMap<>();


    static {

        Reflections reflections = new Reflections("cn.baoyi.luyue.service.domain.service.serviceImpl");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Pay.class);
        for (Class clazz : classSet) {
            Pay pay = (Pay) clazz.getAnnotation(Pay.class);
            sourceMap.put(pay.personalId(), clazz.getCanonicalName());
        }

    }


    public Strategy create(Integer personalId) throws Exception {
        String clazz = sourceMap.get(personalId);
        Class aClass = Class.forName(clazz);
        return (Strategy) aClass.newInstance();
    }


}
