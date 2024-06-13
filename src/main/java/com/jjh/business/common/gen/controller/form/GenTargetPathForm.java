package com.jjh.business.common.gen.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 生成指定路径下的代码 表单
 *
 * 示例：
 * {"params":{"entityName":"Client","entityPackage":"client","columns":[{"fieldName":"code","filedComment":"单位编号","fieldType":"String"},{"fieldName":"name","filedComment":"客户名称","fieldType":"String","nullable":"N"}]},"targetFilePath":"D:/gg/ClientList.vue","templateFilePath":"vm/java/List.vue.vm"}
 *
 * @author jjh
 * @date 2019/11/20
 **/
@Data
public class GenTargetPathForm {

    /**
     * 代码绝对路径（包含到model包名）
     */
    @NotBlank(message = "代码绝对路径")
    @Schema(description = "代码绝对路径（包含到model包名）", example = "D:\\Temp\\IDEA\\ecom_analysis_backend\\src\\main\\java\\com\\jjh\\business\\system\\support\\model")
    private String packagePath;

    /** 作者（比如：jjh）*/
    @NotBlank(message = "作者不能为空")
    @Schema(description = "作者")
    private String author;

    /** 目标文件类型*/
    @Schema(description = "目标文件类型（,号分隔；为空时默认生成全部目标文件类型）", example = "Service,Controller")
    private String targetFile;

    /** 包含项*/
    @Schema(description = "包含项（为空时默认包含全部）", example = "SysUse")
    private String includeEntity;

    /** 排除项*/
    @Schema(description = "排除项（为空时则不存在排除项）", example = "UserInfo,RoInfo")
    private String excludeEntity;

    /** 是否生成导入导出代码*/
    @Schema(description = "是否生成导入导出代码", example = "false")
    private Boolean importAndExport;
}
