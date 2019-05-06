package cn.baoyi.luyue.entity.management;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/6 14:31
 * @Description:
 */
@Entity
@Data
@Table(name = "t_user")
public class User {

    @Id
    private Integer id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户姓名")
    private String userRealName;

    @ApiModelProperty("手机")
    private String mobile;

}
