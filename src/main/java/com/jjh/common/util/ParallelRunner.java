package com.jjh.common.util;

import cn.hutool.core.thread.ThreadUtil;
import com.jjh.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * 多线程线程执行
 * @author jiangjihui
 * @date 2025/5/20
 */
@Slf4j
public class ParallelRunner {
    public static Executor executor = ThreadUtil.newExecutor(3);
    private int parallelQty;
    private Semaphore semaphore;
    private AtomicInteger failQty = new AtomicInteger(0);

    public ParallelRunner(int parallelQty) {
        if (parallelQty < 1) {
            throw new BusinessException("parallelQty must be greater than 0");
        }
        this.parallelQty = parallelQty;
        this.semaphore = new Semaphore(parallelQty);
    }

    public void execute(Runnable command) {
        execute(command, null, null);
    }

    public void execute(Runnable command, String runDs) {
        execute(command, null, runDs);
    }

    /**
     * 执行任务
     */
    public void execute(Runnable command, Consumer<Throwable> failProc, String runDs) {
        try {
            semaphore.acquire();
            executor.execute(() -> {
                try {
                    command.run();
                } catch (Throwable e) {
                    log.error("ParallelRunner execute error",e);
                    failQty.incrementAndGet();
                    if (failProc != null) {
                        failProc.accept(e);
                    }
                    throw e;
                } finally {
                    semaphore.release();
                }
            });
        } catch (InterruptedException e) {
            log.error("ParallelRunner execute failed", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    /**
     * 等待所有完成
     * (返回是否全部成功)
     */
    public boolean waitCompleted() {
        try {
            semaphore.acquire(parallelQty);
        } catch (InterruptedException e) {
            log.error("ParallelRunner waitCompleted failed", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return !hasFail();
    }

    public int getFailQty() {
        return failQty.get();
    }

    public boolean hasFail() {
        return getFailQty() > 0;
    }
}
