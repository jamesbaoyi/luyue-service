package cn.baoyi.luyue.service.domain.web;

import cn.baoyi.luyue.service.domain.service.PersonalContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/13 17:06
 * @Description:
 */
@RestController
public class AutoWiredController {

    @GetMapping("/testAutowired")
    private void testAutowired() {

        PersonalContactService personalContactService = new PersonalContactService();
        personalContactService.addPersonalContact();

    }

    public static void main(String[] args) {



    }
}
