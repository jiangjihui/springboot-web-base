package com.jjh.business.system.record.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jjh.common.model.AuditBaseEntity;
import com.jjh.framework.plugin.excel.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

import static com.jjh.business.system.record.model.SysOperationLog.TABLE_NAME;

/**
 * 操作日志
 *
 * @author jjh
 * @date 2020/04/26
 */
@Data
@TableName(TABLE_NAME)
public class SysOperationLog extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"sys_operation_log";

    /** 系统模块 */
    @Excel(name = "系统模块")
    @Schema(description = "系统模块")
    private String title;

    /**
     * 操作类型
     * （0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据）
     *  */
    @Excel(name = "操作类型", dictConverter = "system:operationLog:operationType")
    @Schema(description = "操作类型", format = "system:operationLog:operationType")
    private Integer operationType;

    /** 请求方法（java方法） */
    @Excel(name = "请求方法")
    @Schema(description = "请求方法")
    private String method;

    /** 请求方式：GET/POST */
    @Excel(name = "请求方式")
    @Schema(description = "请求方式")
    private String requestMethod;

    /** 操作人员 */
    @Excel(name = "操作人员")
    @Schema(description = "操作人员")
    private String operUserId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    @Schema(description = "所属部门")
    private String deptId;

    /** 请求地址 */
    @Excel(name = "请求地址")
    @Schema(description = "请求地址")
    private String operUrl;

    /** 请求IP */
    @Excel(name = "请求IP")
    @Schema(description = "请求IP")
    private String operIp;

    /** 操作地点 */
    @Excel(name = "操作地点")
    @Schema(description = "操作地点（暂不展示）")
    private String operLocation;

    /** 请求参数 */
    @Excel(name = "请求参数")
    @Schema(description = "请求参数")
    private String operParam;

    /** 返回参数 */
    @Excel(name = "返回参数")
    @Schema(description = "返回参数")
    private String jsonResult;

    /** 状态 */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    @Schema(description = "状态")
    private Integer status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    @Schema(description = "错误消息")
    private String errorMsg;

    /** 操作时间*/
    @Schema(description = "操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operTime;


    /** 操作人员名称 */
    @Excel(name = "操作人员名称")
    @Schema(description = "操作人员名称")
    @TableField(exist = false)
    private String operUserName;

    /** 所属部门名称 */
    @Excel(name = "所属部门名称")
    @Schema(description = "所属部门名称")
    @TableField(exist = false)
    private String deptName;
}
