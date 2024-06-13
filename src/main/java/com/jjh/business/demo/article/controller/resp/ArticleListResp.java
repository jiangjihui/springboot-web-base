package com.jjh.business.demo.article.controller.resp;

import com.jjh.framework.aspect.sensitive.DataMasking;
import com.jjh.framework.aspect.sensitive.DataMaskingFunc;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * ArticleListResp
 *
 * @author jiangjihui
 * @date 2022/07/07
 **/
@Data
@Builder
public class ArticleListResp {

    private String id;

    @Schema(description = "名称")
    private String name;

    @DataMasking(maskFunc = DataMaskingFunc.ALL_MARK)
    @Schema(description = "内容")
    private String content;
}
