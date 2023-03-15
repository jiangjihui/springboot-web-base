package com.jjh.business.demo.article.manager;

import com.jjh.business.demo.article.mapper.ArticleMapper;
import com.jjh.business.demo.article.model.Article;
import com.jjh.common.wrapper.MyBatisWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

/**
 * ArticleManager
 *
 * @author jiangjihui
 * @date 2023/03/15
 **/
@Slf4j
@RequiredArgsConstructor
@Component
public class ArticleManager {

    private final MyBatisWrapper myBatisWrapper;

    public int cursorList(int batchSize, Article article, Consumer<List> consumer) {
        return myBatisWrapper.cursorList(batchSize, ArticleMapper.class,
                article, consumer);
    }

}
