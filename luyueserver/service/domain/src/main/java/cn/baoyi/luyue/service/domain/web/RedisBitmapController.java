package cn.baoyi.luyue.service.domain.web;

import redis.clients.jedis.Jedis;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/20 9:57
 * @Description:
 */
public class RedisBitmapController {

    public static void main(String[] args) {
        Jedis redis = new Jedis("192.168.3.2", 4307);
        redis.auth("redis123456");
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0)
                redis.setbit("online", i, "1");
        }
        Long online = redis.bitcount("online");
        System.out.println("在线用户数：" + online);
    }
}
