package com.jjh.business.system.notice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jjh.common.model.AuditBaseEntity;
import com.jjh.framework.plugin.excel.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

import static com.jjh.business.system.notice.model.SysNotice.TABLE_NAME;

/**
 * 通知
 *
 * @author jjh
 * @date 2020/05/07
 */
@Data
@TableName(TABLE_NAME)
public class SysNotice extends AuditBaseEntity {

    public static final String TABLE_NAME = TABLE_PREFIX+"sys_notice";

    /** 标题 */
    @Excel(name = "标题")
    @Size(min = 0, max = 50, message = "公告标题不能超过50个字符")
    @NotBlank(message = "标题不能为空")
    @Schema(description = "标题", required = true)
    private String title;

    /** 公告类型（1通知 2公告）  */
    @Excel(name = "公告类型", readConverterExp = "1=通知,2=公告")
    @Schema(description = "公告类型 ", format = "1=通知,2=公告")
    private String noticeType;

    /** 内容 */
    @Excel(name = "内容")
    @Schema(description = "内容")
    private String content;

    /** 阅读状态 */
    @Excel(name = "阅读状态", readConverterExp = "false=未读,true=已读")
    @Schema(description = "阅读状态", format = "false=未读,true=已读")
    private Boolean readFlag;

    /** 状态 */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    @Schema(description = "状态", format = "0=正常,1=停用", required = true)
    private Integer status;

    /** 来源类型 */
    @Excel(name = "来源类型", readConverterExp = "flow=流程,update=数据变更,expire=到期")
    @Schema(description = "来源类型", format = "flow=流程,update=数据变更,expire=到期")
    private String sourceType;

    /** 发布时间*/
    @Excel(name = "发布时间")
    @Schema(description = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendTime;

    /** 关联业务ID */
    @Schema(description = "关联业务ID")
    private String relativeId;

    /** 发布人 */
    @Excel(name = "发布人")
    @Schema(description = "发布人")
    private String sender;

    /** 收件人 */
    @Excel(name = "收件人")
    @Schema(description = "收件人")
    private String receiver;

    /** 所属部门ID */
    @Schema(description = "所属部门ID")
    private String deptId;

}
