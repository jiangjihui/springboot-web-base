package com.jjh.business.system.support.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jjh.common.model.AuditBaseEntity;
import com.jjh.framework.plugin.excel.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

import static com.jjh.business.system.support.model.SysDictType.TABLE_NAME;

/**
 * 字典类型
 */
@Data
@TableName(TABLE_NAME)
public class SysDictType extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"sys_dict_type";

    /** 字典分类名称 */
    @Excel(name = "字典分类名称")
    @NotBlank(message = "字典分类名称不能为空")
    @Schema(description = "字典分类名称", required = true)
    private String name;

    /** 字典分类码值 */
    @Excel(name = "字典分类码值")
    @NotBlank(message = "字典分类码值不能为空")
    @Schema(description = "字典分类码值", required = true)
    private String code;

    /** 状态 */
    @Excel(name = "状态")
    @Schema(description = "状态", required = true)
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    @Schema(description = "备注")
    private String remark;


    /** 字典数据（回显使用） */
    @Schema(description = "字典数据（回显使用）")
    @TableField(exist = false)
    private List<SysDictData> dictData;

}
