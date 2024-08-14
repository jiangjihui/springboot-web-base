package com.jjh.common.wrapper;

import com.jjh.common.mapper.CursorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * MyBatisWrapper
 *
 * @author jiangjihui
 * @date 2023/03/15
 **/
@Slf4j
@RequiredArgsConstructor
@Component
public class MyBatisWrapper {

    private final SqlSessionFactory sqlSessionFactory;

    /**
     * 游标方式查询数据
     * @param batchSize 批次大小
     * @param clazz 查询数据的mapper类，需要继承CursorMapper接口，并实现cursorList方法
     * @param param 查询参数
     * @param consumer 处理数据的方法
     * @return 游标查询到的总数据量
     */
    public <T extends CursorMapper> int cursorList(int batchSize, Class<T> clazz, Object param, Consumer<List> consumer) {
        AtomicInteger totalSize = new AtomicInteger();
        List tempList = new ArrayList<>(batchSize);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.REUSE)) {
            CursorMapper mapper = sqlSession.getMapper(clazz);
            Cursor cursor = mapper.cursorList(param);
            // Cursor cursor = sqlSession.selectCursor(statement, param);
            Iterator iterator = cursor.iterator();
            while (iterator.hasNext()) {
                totalSize.addAndGet(1);
                tempList.add(iterator.next());
                if (tempList.size() >= batchSize) {
                    consumer.accept(tempList);
                    tempList.clear();
                }
            }
            if (CollectionUtils.isNotEmpty(tempList)) {
                consumer.accept(tempList);
                tempList.clear();
            }
        }
        return totalSize.get();
    }

    /**
     * 游标方式查询数据
     */
    public <M, T> int cursorList(int batchSize, Class<M> clazz,  Function<M, Cursor<T>> callMethod, Consumer<List<T>> consumer) {
        AtomicInteger totalSize = new AtomicInteger();
        List<T> tempList = new ArrayList<>(batchSize);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.REUSE)) {
            M mapper = sqlSession.getMapper(clazz);
            Cursor<T> cursor = callMethod.apply(mapper);
            Iterator<T> iterator = cursor.iterator();
            while (iterator.hasNext()) {
                totalSize.addAndGet(1);
                tempList.add(iterator.next());
                if (tempList.size() >= batchSize) {
                    consumer.accept(tempList);
                    tempList.clear();
                }
            }
            if (CollectionUtils.isNotEmpty(tempList)) {
                consumer.accept(tempList);
                tempList.clear();
            }
        }
        return totalSize.get();
    }

}
