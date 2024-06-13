package com.jjh.business.system.record.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 查询操作日志表单
 *
 * @author jjh
 * @date 2020/05/08
 **/
@Data
public class QueryOperationLogForm {

    @Schema(description = "系统模块")
    private String title_WithLike;

    /** 操作人员 */
    @Schema(description = "操作人员")
    private String operUserId;

    /** 操作类型 */
    @Schema(description = "操作类型", example = "系统字典[system:operationLog:operationType]")
    private Integer operationType;

    /** 状态 */
    @Schema(description = "状态（0=正常,1=异常）")
    private Integer status;

    @Schema(description = "操作日期（起始）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operTime_WithGreatEqual;

    @Schema(description = "操作日期（结束）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operTime_WithLessEqual;

}
