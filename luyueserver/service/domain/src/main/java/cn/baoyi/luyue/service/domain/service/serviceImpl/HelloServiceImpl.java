package cn.baoyi.luyue.service.domain.service.serviceImpl;

import cn.baoyi.luyue.service.domain.service.IHelloService;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/3 10:07
 * @Description:
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "你好，" + name;
    }
}
