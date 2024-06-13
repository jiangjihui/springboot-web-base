package com.jjh.common.web.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * 查询表单
 *
 * @author jjh
 * @date 2019/6/1
 **/
public class SimpleForm {

    @NotBlank(message = "ID不能为空")
    @Schema(description = "ID", required = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
