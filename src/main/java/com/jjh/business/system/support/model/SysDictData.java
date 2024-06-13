package com.jjh.business.system.support.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jjh.common.model.AuditBaseEntity;
import com.jjh.framework.plugin.excel.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import static com.jjh.business.system.support.model.SysDictData.TABLE_NAME;

/**
 * 字典数据
 */
@Data
@TableName(TABLE_NAME)
public class SysDictData extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"sys_dict_data";

    /** 字典数据名称 */
    @Excel(name = "字典数据名称")
    @NotBlank(message = "字典数据名称不能为空")
    @Schema(description = "字典数据名称", required = true)
    private String name;

    /** 字典数据码值 */
    @Excel(name = "字典数据码值")
    @NotBlank(message = "字典数据码值不能为空")
    @Schema(description = "字典数据码值", required = true)
    private String code;

    /** 字典类型（Code） */
    @Excel(name = "字典类型")
    @NotBlank(message = "字典类型不能为空")
    @Schema(description = "字典类型", required = true)
    private String dictType;

    /** 排序 */
    @Excel(name = "排序")
    @Schema(description = "排序")
    private Integer sortNo;

    /** 是否默认 */
    @Excel(name = "是否默认")
    @Schema(description = "是否默认")
    private Integer canDefault;

    /** 状态 */
    @Excel(name = "状态")
    @Schema(description = "状态", required = true)
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    @Schema(description = "备注")
    private String remark;

}
