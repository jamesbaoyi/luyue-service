package cn.baoyi.luyue.service.management.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/5 15:48
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/getAllDatas")
    private String getAllDatas() {
        return "hello world";
    }
}
