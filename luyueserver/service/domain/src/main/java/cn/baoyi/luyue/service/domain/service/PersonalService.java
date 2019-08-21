package cn.baoyi.luyue.service.domain.service;

import cn.baoyi.luyue.entity.domain.Personal;
import cn.baoyi.luyue.service.domain.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/8 11:11
 * @Description:
 */
@Service("personalService")
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private PersonalContactService personalContactService;


    @Transactional
    public void addPersonal() {
        Personal personal = new Personal();
        personal.setPersonalName("张三");
        personal.setIdCard("123456");
        personal.setMobile("456123");
        personalRepository.save(personal);

        personalContactService.addPersonalContact();

    }
}
