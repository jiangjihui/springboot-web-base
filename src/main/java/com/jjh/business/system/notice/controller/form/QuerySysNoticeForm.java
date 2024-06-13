package com.jjh.business.system.notice.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 查询通知表单
 *
 * @author jjh
 * @date 2020/05/11
 **/
@Data
public class QuerySysNoticeForm {

    @Schema(description = "标题")
    private String title_WithLike;

    @Schema(description = "阅读状态", format = "false=未读,true=已读")
    private Boolean readFlag;

    @Schema(description = "发布时间（起始）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendTime_WithGreatEqual;

    @Schema(description = "发布时间（结束）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendTime_WithLessEqual;

}
