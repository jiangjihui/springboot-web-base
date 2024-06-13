package com.jjh.business.system.support.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统字典查询表单
 *
 * @author jjh
 * @date 2020/4/8
 **/
@Data
public class SysDictTypeQueryForm {

    @Schema(description = "字典分类名称")
    private String name_WithLikeAll;

    @Schema(description = "字典分类编号")
    private String code;

}
