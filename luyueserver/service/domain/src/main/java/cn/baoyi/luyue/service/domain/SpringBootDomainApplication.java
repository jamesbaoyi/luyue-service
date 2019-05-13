package cn.baoyi.luyue.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/30 16:46
 * @Description:
 */

@SpringCloudApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {"cn.baoyi.luyue.entity.domain"})
@EnableTransactionManagement
public class SpringBootDomainApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDomainApplication.class, args);

    }
}

