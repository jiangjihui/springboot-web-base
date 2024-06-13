package com.jjh.business.system.user.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 修改密码 表单
 */
@Data
public class ResetPasswordForm {

    @NotBlank(message = "ID不能为空")
    @Schema(description = "用户编号")
    private String id;

    @NotBlank(message = "新密码不能为空")
    @Schema(description = "新密码")
    private String newPassword;

}
