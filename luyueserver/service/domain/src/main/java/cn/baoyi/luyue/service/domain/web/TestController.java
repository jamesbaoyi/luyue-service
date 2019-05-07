package cn.baoyi.luyue.service.domain.web;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/7 9:58
 * @Description:
 */

@RestController
public class TestController {

    private String sayHello() {
        return "hello";
    }
}
