package cn.baoyi.luyue.service.domain.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/10 11:21
 * @Description:
 */
@RestController
@Api("线程学习")
public class ThreadController {

    @ApiOperation("线程测试")
    @GetMapping("/printNumber")
    public void printNumber() throws InterruptedException {


        PrintClass printClass = new PrintClass();
        for (int i = 1; i <= 100; i++) {
            printClass.setTemp(i);
            if (i % 2 == 0) {
                Thread thread1 = new java.lang.Thread(printClass, "线程一");
                thread1.start();
                synchronized (thread1) {
                    thread1.wait(2);
                    thread1.notify();
                }
            } else {
                Thread thread2 = new java.lang.Thread(printClass, "线程二");
                thread2.start();
                synchronized (thread2) {
                    thread2.wait(2);
                    thread2.notify();
                }
            }
        }


    }

    private class PrintClass implements Runnable {
        private volatile int temp;

        public void setTemp(int temp) {
            this.temp = temp;
        }

        public void print() {
            System.out.println(temp + Thread.currentThread().getName());
        }

        @Override
        public void run() {
            print();
        }
    }
}
