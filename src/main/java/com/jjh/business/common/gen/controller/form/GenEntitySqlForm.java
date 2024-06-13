package com.jjh.business.common.gen.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 生成实体SQL 表单
 *
 * @author jjh
 * @date 2020/05/15
 **/
@Data
public class GenEntitySqlForm {

    /** 类名全路径 */
    @NotBlank(message = "类名全路径不能为空")
    @Schema(description = "类名全路径（类的包名+类名）", example = "com.jjh.business.system.user.model.SysUser")
    private String classPackageName;

    /** 是否包含基础字段 */
    @Schema(description = "是否包含基础字段", example = "true")
    private Boolean baseColumnFlag;

}
