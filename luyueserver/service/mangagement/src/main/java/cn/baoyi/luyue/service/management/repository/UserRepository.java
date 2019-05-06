package cn.baoyi.luyue.service.management.repository;

import cn.baoyi.luyue.entity.management.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/6 14:41
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
