package cn.baoyi.luyue.service.domain.web;

import cn.baoyi.luyue.service.domain.service.IHelloService;
import cn.baoyi.luyue.service.domain.service.PersonalService;
import cn.baoyi.luyue.service.domain.service.RpcClientProxy;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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

//        RpcClientProxy proxy = new RpcClientProxy();
//        IHelloService helloService = proxy.clientProxy(IHelloService.class, "127.0.0.1", 12345);
//        String name = helloService.sayHello("张三");
//        System.out.println(name);

        String[] ocurrences = findOcurrences("alice is a good girl she is a good student", "a", "good");
        System.out.println(ocurrences.length);

        try {
            String a = null;
            a.substring(1);
        } catch (Exception ex) {
            System.out.println("错误如下：" + getExceptionAllinformation(ex));
        }


    }

    public static String[] findOcurrences(String text, String first, String second) {

        List<String> result = new ArrayList<>();
        String spilt = first + " " + second;
        String leftText;
        leftText = text;
        while (leftText.contains(spilt)) {
            int index = leftText.indexOf(spilt);
            String substring;
            if (index == 0) {
                substring = leftText.substring(spilt.length()).trim();
            } else {
                substring = leftText.substring(index + spilt.length()).trim();
            }
            if (substring.contains(" ")) {
                result.add(substring.substring(0, substring.indexOf(" ")));
            } else {
                result.add(substring);
            }
            leftText = substring;
        }
        return result.toArray(new String[result.size()]);

    }

    /**
     *  * 获取Exception详情
     *  * @param ex
     *  * @return
     *  
     */
    static String getExceptionAllinformation(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        try {
            pout.close();
            out.close();
        } catch (Exception e) {
            System.out.println("流关闭异常：" + e);
        }
        return ret;
    }

}
