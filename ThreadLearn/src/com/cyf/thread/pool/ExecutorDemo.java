package com.cyf.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 列出Java并发包中的所有线程池
 *
 * @author cyfIverson
 * @create 2018-04-06
 */

public class ExecutorDemo {

    public static void main(String[] args) {
        //只有一个线程的线程池
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //拥有固定数线程的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
        //缓存线程(如果线程超过60秒内没执行，那么将被终止并从池中删除)
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //用来调度即将执行的任务的线程池
        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(8);
        //只有一个线程，用来调度任务在指定时间执行
        ScheduledExecutorService newSingleThreadScheduledExecutor=Executors.newSingleThreadScheduledExecutor();
    }
}
