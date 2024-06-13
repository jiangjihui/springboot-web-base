package com.jjh.business.system.user.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 用户冻结/解冻 表单
 */
@Data
public class UserFrozenForm {

    @NotBlank(message = "ID不能为空")
    @Schema(description = "用户编号")
    private String id;

    @NotBlank(message = "（冻结）状态不能为空")
    @Schema(description = "（冻结）状态")
    private Integer status;

}
