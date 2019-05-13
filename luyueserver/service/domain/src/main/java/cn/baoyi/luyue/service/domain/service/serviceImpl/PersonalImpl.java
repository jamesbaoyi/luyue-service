package cn.baoyi.luyue.service.domain.service.serviceImpl;

import cn.baoyi.luyue.service.domain.annoation.Pay;
import cn.baoyi.luyue.service.domain.repository.PersonalRepository;
import cn.baoyi.luyue.service.domain.service.Strategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/13 14:29
 * @Description:
 */
@Pay(personalId = 1)
@Component
public class PersonalImpl implements ApplicationContextAware, Strategy {

    private static ApplicationContext applicationContext;

    @Autowired
    private PersonalRepository personalRepository;

    @Override
    public String strategy(Integer personalId) {

        Object bean = applicationContext.getBean("personalRepository");
        personalRepository = (PersonalRepository) bean;

        return personalRepository.findById(personalId).get().getPersonalName();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
