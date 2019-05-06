package cn.baoyi.luyue.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/30 16:46
 * @Description:
 */

@SpringCloudApplication
@EnableDiscoveryClient
public class SpringBootDomainApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDomainApplication.class, args);

    }
}

