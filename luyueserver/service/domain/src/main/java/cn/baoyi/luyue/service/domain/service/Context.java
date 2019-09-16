package cn.baoyi.luyue.service.domain.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/13 9:28
 * @Description:
 */

@Service("context")
public class Context {

    public String getPersonalName(Integer personalId) throws Exception {
        StrategyFactory strategyFactory = StrategyFactory.getInstance();
        Strategy strategy = strategyFactory.create(personalId);
        return strategy.strategy(personalId);
    }

}
