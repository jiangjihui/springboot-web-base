package com.jjh.business.system.user.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 查询角色表单
 *
 * @author jjh
 * @date 2020/04/13
 **/
@Data
public class QueryRoleForm {

    @Schema(description = "名称")
    private String name_WithLike;

    @Schema(description = "创建日期（起始）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime_WithGreatEqual;

    @Schema(description = "创建日期（结束）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime_WithLessEqual;

}
