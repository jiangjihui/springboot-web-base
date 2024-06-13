package com.jjh.business.demo.article.controller.form;

import com.jjh.common.web.query.MatchType;
import com.jjh.common.web.query.QueryCondition;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * ArticleQueryListForm
 *
 * @author jjh
 * @date 2021/03/12
 **/
@Data
public class ArticleQueryListForm {

    @QueryCondition(func = MatchType.like)
    @Schema(description = "名称")
    private String name;

    @QueryCondition
    @Schema(description = "内容")
    private String content;

}
