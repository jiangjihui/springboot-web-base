package com.jjh.business.demo.article.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.jjh.business.demo.article.controller.form.ArticleQueryListForm;
import com.jjh.business.demo.article.manager.ArticleManager;
import com.jjh.business.demo.article.mapper.ArticleMapper;
import com.jjh.business.demo.article.model.Article;
import com.jjh.business.demo.article.service.ArticleService;
import com.jjh.common.exception.BusinessException;
import com.jjh.common.util.IdGenerateHelper;
import com.jjh.common.util.PojoUtils;
import com.jjh.common.web.form.PageRequestForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 文章 服务层实现
 *
 * @author jjh
 * @date 2020/02/16
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleManager articleManager;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    private SqlSession sqlSession;


    /**
     * 查询文章列表
     *
     * @param form 查询条件
     * @return 文章集合
     */
    @Override
    public List<Article> list(PageRequestForm<ArticleQueryListForm> form) {
        log.info("traceId链路测试");
        return articleMapper.selectList(form.pageWrapperQuerySupport());
    }

    /**
     * 新增文章对象
     *
     * @param entity 待新增对象
     * @return 文章对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Article add(Article entity) {
        entity.setId(IdGenerateHelper.nextId());
        articleMapper.insert(entity);
        return entity;
    }

    /**
     * 更新文章对象
     *
     * @param entity 待更新对象
     * @return 文章对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Article update(Article entity) {
        Article oldEntity = articleMapper.selectById(entity.getId());
        if (oldEntity == null) {
            throw new BusinessException("对象不存在，请检查");
        }
        //对象属性复制
        PojoUtils.copyPropertiesIgnoreNull(entity, oldEntity);
        articleMapper.updateById(oldEntity);
        return oldEntity;
    }

    /**
     * 删除文章对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean del(String ids) {
        articleMapper.deleteBatchIds(CollectionUtil.toList(ids.split(",")));
        return true;
    }

    @Override
    public void asyncLog() {
        log.info("asyncLog start.");

        ArticleService selfProxy = SpringUtil.getBean(ArticleService.class);
        selfProxy.doAsync();

        log.info("asyncLog end.");
    }

    @Override
    public void doAsync() {
        log.info("doAsync start.");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("doAsync end.");
    }

    @Override
    public List<Object> dynamicSqlQuery(String methodName) {
        String mapperClassStr = "com.jjh.business.demo.article.mapper.ArticleMapper";
        String statement = StringUtils.join(mapperClassStr, ".", methodName);
        // return sqlSession.selectList(statement);
        return sqlSessionTemplate.selectList(statement);
    }

    /**
     * 多线程并行
     */
    @Override
    public void multThread() {
        int threadSize = 5;
        ThreadPoolExecutor executor = ThreadUtil.newExecutor(threadSize, threadSize);
        CountDownLatch latch = new CountDownLatch(threadSize);

        try {
            for (int i = 0; i < threadSize; i++) {
                int finalI = i;
                executor.submit(new RunTask(latch, () -> {
                    doWrite(finalI);
                }));
            }
            latch.await();
        } catch (Exception e) {
            executor.shutdown();
        }

        log.info("multThread end.");

    }
    static class RunTask implements Runnable{

        private final Runnable task;
        private final CountDownLatch latch;

        public RunTask(CountDownLatch latch, Runnable task) {
            this.task = task;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                task.run();
            }
            finally {
                latch.countDown();
            }
        }
    }

    public void doRead(int currentNo, int subNo)  {
        log.info("doRead start. currentNo: {} subNo: {}", currentNo, subNo);
        try {
            int i = RandomUtil.randomInt(100);
            Thread.sleep(1000 + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("doRead end. currentNo: {} subNo: {}", currentNo, subNo);
    }

    public void doWrite(int currentNo) {
        log.info("doWrite start. currentNo: {}", currentNo);
        int subSize = 3;
        ThreadPoolExecutor executor = ThreadUtil.newExecutor(subSize, subSize);
        CountDownLatch latch = new CountDownLatch(subSize);

        try {
            for (int i = 0; i < subSize; i++) {
                int subNo = i;
                executor.submit(new RunTask(latch, () -> {
                    doRead(currentNo, subNo);
                }));
            }
            latch.await();
        } catch (Exception e) {
            executor.shutdown();
        }

        log.info("doWrite end. currentNo: {}", currentNo);
    }

    /**
     * 游标处理数据
     */
    @Override
    public int cursorDeal(int batchSize) {
        Article article = new Article();
        article.setStatus(1);
        return articleManager.cursorList(batchSize, article, list -> {
            log.info("batch get list, size: {}", list.size());
        });
    }

}
