package com.jjh.business.demo.article.controller;


import cn.hutool.extra.spring.SpringUtil;
import com.jjh.business.demo.article.controller.form.ArticleQueryListForm;
import com.jjh.business.demo.article.controller.resp.ArticleListResp;
import com.jjh.business.demo.article.mapper.ArticleMapper;
import com.jjh.business.demo.article.model.Article;
import com.jjh.business.demo.article.service.ArticleService;
import com.jjh.common.web.controller.BaseController;
import com.jjh.common.web.form.PageRequestForm;
import com.jjh.common.web.form.PageResponseForm;
import com.jjh.common.web.form.SimpleResponseForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
*   文章管理
 *
 * @author jjh
 * @date 2020/02/16
*/
@Tag(name = "文章管理")
@RestController
@RequestMapping("/demo/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Resource
    private ArticleMapper articleMapper;


    /**
     * 文章列表
     */
    @Operation(summary = "文章列表")
    @PostMapping("/list")
    public SimpleResponseForm<PageResponseForm<ArticleListResp>> list(@RequestBody PageRequestForm<ArticleQueryListForm> form) {
        List<Article> list = articleService.list(form);
        ArrayList<ArticleListResp> resp = new ArrayList<>();
        list.stream().forEach(article -> {
            resp.add(
                    ArticleListResp.builder()
                     .id(article.getId())
                    .name(article.getName())
                    .content(article.getContent()).build()
            );
        });
        return page(form, resp);
    }

    /**
     * 新增文章
     */
    @Operation(summary = "新增文章")
    @PostMapping("/add")
    public SimpleResponseForm<Article> add(@Valid @RequestBody Article entity) {
        Article result = articleService.add(entity);
        return success();
    }

    /**
     * 更新文章
     */
    @Operation(summary = "更新文章")
    @PostMapping("/update")
    public SimpleResponseForm<Article> update(@Valid @RequestBody Article entity) {
        Article result = articleService.update(entity);
        return success();
    }

    /**
     * 删除文章
     */
    @Operation(summary = "删除文章")
    @GetMapping("/delete")
    public SimpleResponseForm<String> delete(String ids) {
        articleService.del(ids);
        return success();
    }


    /**
     * msg
     */
    @Operation(summary = "msg")
    @GetMapping("/msg")
    public SimpleResponseForm<String> msg() {
//        LocaleContextHolder.setLocale(Locale.US);
        return success(message("sys.login.accountFreezed"));
    }


    /**
     * 根据消息键和参数 获取消息 委托给Spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public static String message(String code, Object... args){
        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
        try{
            return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
        }catch (Exception e){
            return code;
        }
    }

    /**
     * selectAll
     */
    @Operation(summary = "selectAll")
    @GetMapping("/select_all")
    public SimpleResponseForm<List<Article>> selectAll() {
        return success(articleMapper.selectAllList());
    }

    /**
     * selectAll
     */
    @Operation(summary = "selectOne")
    @GetMapping("/selectOne")
    public SimpleResponseForm<Article> selectOne() {
        return success(articleMapper.selectOneObject());
    }


    @Operation(summary = "异步消息测试")
    @GetMapping("/async_log")
    public SimpleResponseForm<String> asyncLog() {
        articleService.asyncLog();
        return new SimpleResponseForm<>();
    }

    @Operation(summary = "未定义的动态SQL查询")
    @GetMapping("/dynamic_sql_query")
    public SimpleResponseForm<List<Object>> dynamicSqlQuery(String methodName) {
        return new SimpleResponseForm<>(articleService.dynamicSqlQuery(methodName));
    }

    @Operation(summary = "多线程并行")
    @GetMapping("/mult_thread")
    public SimpleResponseForm<String> multThread() {
        articleService.multThread();
        return new SimpleResponseForm<>("OK");
    }

    @Operation(summary = "游标查询数据")
    @GetMapping("/cursor_list")
    public SimpleResponseForm<String> cursorList() {
        int result = articleService.cursorDeal(100);
        return new SimpleResponseForm<>(String.valueOf(result));
    }
}
