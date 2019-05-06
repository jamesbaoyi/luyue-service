package cn.baoyi.luyue.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/5 11:17
 * @Description:
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringBootDiscoveryApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDiscoveryApplication.class, args);

    }
}
