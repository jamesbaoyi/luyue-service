package cn.baoyi.luyue.service.domain.web;

import cn.baoyi.luyue.service.domain.service.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/13 9:25
 * @Description:
 */

@RestController
public class FactoryController {

    @Autowired
    private Context context;


    @GetMapping("/getPersonal")
    private void getPersonal() throws Exception {

        System.out.println(context.getPersonalName(1));
    }

}
