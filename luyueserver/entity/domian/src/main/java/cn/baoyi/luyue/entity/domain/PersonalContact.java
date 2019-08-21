package cn.baoyi.luyue.entity.domain;

import cn.baoyi.luyue.common.utils.DataConvert;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/8 11:01
 * @Description:
 */

@Entity
@Data
@Table(name = "personal_contact")
public class PersonalContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("联系人姓名")
    @DataConvert(type = "1", oldData = "", newData = "")
    private String contName;

    @ApiModelProperty("联系人关系")
    private String contRelation;

    @ApiModelProperty("联系人手机")
    private String contMobile;

}
