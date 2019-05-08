package cn.baoyi.luyue.entity.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/8 10:41
 * @Description:
 */

@Data
@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("姓名")
    private String personalName;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("手机")
    private String mobile;
}
