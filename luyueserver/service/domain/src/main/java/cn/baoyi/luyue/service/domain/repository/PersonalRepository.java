package cn.baoyi.luyue.service.domain.repository;

import cn.baoyi.luyue.entity.domain.Personal;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/8 10:56
 * @Description:
 */

public interface PersonalRepository extends JpaRepository<Personal, Integer> {

}
