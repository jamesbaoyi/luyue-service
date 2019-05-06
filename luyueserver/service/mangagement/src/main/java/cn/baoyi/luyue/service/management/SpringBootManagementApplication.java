package cn.baoyi.luyue.service.management;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/30 16:52
 * @Description:
 */
@SpringCloudApplication
@EnableDiscoveryClient
public class SpringBootManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootManagementApplication.class, args);

    }
}
