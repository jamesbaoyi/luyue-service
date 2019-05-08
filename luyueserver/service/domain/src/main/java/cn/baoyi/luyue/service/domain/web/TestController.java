package cn.baoyi.luyue.service.domain.web;

import cn.baoyi.luyue.service.domain.service.PersonalContactService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: qijigui
 * @CreateDate: 2019/5/7 9:58
 * @Description:
 */

@RestController
public class TestController {

    @Autowired
    private PersonalContactService personalContactService;

    @ApiOperation("测试事务")
    @GetMapping("/test")
    public void test() {

        personalContactService.addPersonalContact();

    }
}
