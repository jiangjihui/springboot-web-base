package com.jjh.business.system.user.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 登录表单
 *
 * @author jjh
 * @date 2019/9/20
 **/
@Data
public class LoginForm {

    @NotBlank(message = "用户名不能为空")
    @Schema(description = "账号", example = "admin")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码", example = "123456")
    private String password;

}
