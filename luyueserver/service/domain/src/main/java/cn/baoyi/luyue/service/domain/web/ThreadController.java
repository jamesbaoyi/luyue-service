package cn.baoyi.luyue.service.domain.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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

    /**
     * 简单的futureTask示例
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(2);
        FutureTask<Integer> futureTask = new FutureTask<>(() -> atomicInteger.incrementAndGet());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        System.out.println("执行完毕");
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
