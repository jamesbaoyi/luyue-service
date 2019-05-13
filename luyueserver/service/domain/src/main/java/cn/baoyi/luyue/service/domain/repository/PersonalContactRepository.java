package cn.baoyi.luyue.service.domain.repository;

import cn.baoyi.luyue.entity.domain.PersonalContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/8 11:06
 * @Description:
 */
@Repository
public interface PersonalContactRepository extends JpaRepository<PersonalContact, Integer> {
}
