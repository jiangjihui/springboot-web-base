package com.jjh.business.demo.article.controller.resp;

import com.jjh.framework.aspect.sensitive.DataMasking;
import com.jjh.framework.aspect.sensitive.DataMaskingFunc;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "名称")
    private String name;

    @DataMasking(maskFunc = DataMaskingFunc.ALL_MARK)
    @ApiModelProperty(value = "内容")
    private String content;
}
