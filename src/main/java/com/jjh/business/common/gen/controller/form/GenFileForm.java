package com.jjh.business.common.gen.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Map;

/**
 * 生成指定文件 表单
 * 自定义模板和参数进行指定文件生成
 *
 * @author jjh
 * @date 2019/12/26
 **/
@Data
public class GenFileForm {

    /** 模板文件路径*/
    @NotBlank(message = "模板文件路径不能为空")
    @Schema(description = "模板文件路径", example = "vm/java/Repository.java.vm")
    private String templateFilePath;

    /** 目标文件路径*/
    @NotBlank(message = "目标文件路径不能为空")
    @Schema(description = "目标文件路径", example = "D:\\gg\\Repository.java")
    private String targetFilePath;

    /** 模板参数*/
    @Schema(description = "模板参数")
    private Map<String,Object> params;

}
