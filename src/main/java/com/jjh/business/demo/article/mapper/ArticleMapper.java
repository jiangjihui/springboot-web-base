package com.jjh.business.demo.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjh.business.demo.article.model.Article;
import com.jjh.common.mapper.CursorMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文章 数据层
 *
 * @author jjh
 * @date 2020/02/16
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article>, CursorMapper<Article> {

    Article selectOneObject();

    List<Article> selectAllList();

}
