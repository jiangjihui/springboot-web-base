package com.jjh.business.system.user.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 更新角色权限关联 表单
 *
 * @author jjh
 * @date 2019/12/3
 **/
@Data
public class UpdateRolePermissionForm {

    /** 角色ID*/
    @NotBlank(message = "角色ID不能为空")
    @Schema(description = "角色ID")
    private String roleId;

    /** 原有权限ID*/
    @Schema(description = "原有权限ID")
    private String permissionIds;

    /** 新权限ID*/
    @Schema(description = "新权限ID")
    private String lastPermissionIds;

}
