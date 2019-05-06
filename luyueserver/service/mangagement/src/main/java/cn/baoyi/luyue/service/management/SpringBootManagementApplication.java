package cn.baoyi.luyue.service.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/30 16:52
 * @Description:
 */
@SpringCloudApplication
@EnableDiscoveryClient
@EntityScan({"cn.baoyi.luyue.entity.management*"})
@EnableJpaRepositories(basePackages = {"cn.baoyi.luyue.service.management.repository"})
public class SpringBootManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootManagementApplication.class, args);

    }
}
