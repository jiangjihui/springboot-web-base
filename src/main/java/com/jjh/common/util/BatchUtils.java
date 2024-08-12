package com.jjh.common.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * BatchUtils
 *
 * @author jiangjihui
 * @date 2024/08/12
 **/
public class BatchUtils {

    public static <T> void batch(List<T>list, int batchSize, BatchCallBack<T> callBack) {
        if (list.size() < batchSize) {
            callBack.handle(list);
        }
        else {
            Lists.partition(list, batchSize).forEach(batchList -> callBack.handle(batchList));
        }
    }


    @FunctionalInterface
    public interface BatchCallBack<T> {
        void handle(List<T> list);
    }

}
