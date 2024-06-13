package com.jjh.business.system.record.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jjh.common.model.AuditBaseEntity;
import com.jjh.framework.plugin.excel.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

import static com.jjh.business.system.record.model.OnlineLog.TABLE_NAME;

/**
 * 在线日志
 *
 * @author jjh
 * @date 2020/05/13
 */
@Data
@TableName(TABLE_NAME)
public class OnlineLog extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"online_log";

    /** token */
    @Excel(name = "token")
    @Schema(description = "token")
    private String token;

    /** 用户ID */
    @Excel(name = "用户ID")
    @Schema(description = "用户ID")
    private String userId;

    /** 登录IP地址 */
    @Excel(name = "登录IP地址")
    @Schema(description = "登录IP地址")
    private String ipAddr;

    /** 浏览器类型 */
    @Excel(name = "浏览器类型")
    @Schema(description = "浏览器类型")
    private String browser;

    /** 操作系统 */
    @Excel(name = "操作系统")
    @Schema(description = "操作系统")
    private String os;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "登录时间")
    @Schema(description = "登录时间")
    private Date loginTime;

    /** 用户名 */
    @Schema(description = "用户名")
    @TableField(exist = false)
    private String sysUserName;

}
