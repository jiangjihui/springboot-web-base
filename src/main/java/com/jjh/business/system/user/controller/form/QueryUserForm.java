package com.jjh.business.system.user.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 查询用户表单
 *
 * @author jjh
 * @date 2019/9/20
 **/
@Data
public class QueryUserForm {

    @Schema(description = "账号")
    private String username_WithLike;

    /** 性别 */
    @Schema(description = "性别")
    private Integer sex;

    /** 电话 */
    @Schema(description = "电话")
    private String phone;

    /** 状态  */
    @Schema(description = "状态")
    private Integer status;

    /** 电子邮件 */
    @Schema(description = "电子邮件")
    private String email;

    @Schema(description = "创建日期（起始）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime_WithGreatEqual;

    @Schema(description = "创建日期（结束）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime_WithLessEqual;

}
