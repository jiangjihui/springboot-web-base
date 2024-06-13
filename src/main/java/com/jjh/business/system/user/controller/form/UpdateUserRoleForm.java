package com.jjh.business.system.user.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 更新用户角色关联 表单
 *
 * @author jjh
 * @date 2019/12/3
 **/
@Data
public class UpdateUserRoleForm {

    /** 用户ID*/
    @NotBlank(message = "用户ID不能为空")
    @Schema(description = "用户ID")
    private String userId;

    /** 角色ID*/
    @Schema(description = "角色ID")
    private String roleIds;

}
