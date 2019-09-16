package cn.baoyi.luyue.service.domain.web;

import javax.annotation.security.RunAs;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Semaphore;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/10 10:37
 * @Description:
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3, false);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + "进" +
                        "入，当前系统的并发数是：" + (3 - semaphore.availablePermits()));

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + "即将离开");
                semaphore.release();
                System.out.println("Thread " + Thread.currentThread().getName() + " 已经离开，当前系统的并发数是：" + (3 - semaphore.availablePermits()));
            };
            executorService.execute(runnable);
        }
    }
}
