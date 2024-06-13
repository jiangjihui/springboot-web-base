package com.jjh.business.system.support.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jjh.common.model.AuditBaseEntity;
import com.jjh.framework.plugin.excel.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

import static com.jjh.business.system.support.model.SysCategory.TABLE_NAME;

/**
 * 分类字典
 *
 * @author jjh
 * @date 2019/12/12
 */
@Data
@TableName(TABLE_NAME)
public class SysCategory extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"sys_category";

    /** 名称 */
    @Excel(name = "名称")
    @NotBlank(message = "名称不能为空")
    @Schema(description = "名称")
    private String name;

    /** 编码 */
    @Excel(name = "编码")
    @NotBlank(message = "编码不能为空")
    @Schema(description = "编码")
    private String code;

    /** 上级编号 */
    @Excel(name = "上级编号")
    @Schema(description = "上级编号")
    private String parentId;

    /** 状态 */
    @Excel(name = "状态")
    @Schema(description = "状态")
    private Integer status;

    /** 子分类 */
    @Schema(description = "子分类")
    @TableField(exist = false)
    private List<SysCategory> children;
}
