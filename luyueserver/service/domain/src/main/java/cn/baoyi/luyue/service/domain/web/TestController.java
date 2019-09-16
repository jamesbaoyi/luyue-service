package cn.baoyi.luyue.service.domain.web;

import cn.baoyi.luyue.service.domain.service.IHelloService;
import cn.baoyi.luyue.service.domain.service.PersonalService;
import cn.baoyi.luyue.service.domain.service.RpcClientProxy;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.DelayQueue;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/7 9:58
 * @Description:
 */

@RestController
public class TestController {


    @Autowired
    private PersonalService personalService;

    @ApiOperation("测试事务")
    @GetMapping("/test")

    protected void test() {

        personalService.addPersonal();

    }


    public static void main(String[] args) {

        RpcClientProxy proxy = new RpcClientProxy();
        IHelloService helloService = proxy.clientProxy(IHelloService.class, "127.0.0.1", 12345);
        String name = helloService.sayHello("张三");
        System.out.println(name);

    }
}
