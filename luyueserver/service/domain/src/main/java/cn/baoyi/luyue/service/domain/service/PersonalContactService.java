package cn.baoyi.luyue.service.domain.service;

import cn.baoyi.luyue.entity.domain.PersonalContact;
import cn.baoyi.luyue.service.domain.repository.PersonalContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/8 11:08
 * @Description:
 */
@Service("personalContactService")
public class PersonalContactService {

    @Autowired
    private PersonalContactRepository personalContactRepository;

    @Transactional
    public void addPersonalContact() {

        PersonalContact personalContact = new PersonalContact();
        personalContact.setContMobile("15091890736");
        personalContact.setContName("james");
        personalContact.setContRelation("朋友");
        personalContactRepository.save(personalContact);

    }


}
