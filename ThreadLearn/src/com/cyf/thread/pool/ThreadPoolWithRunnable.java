package com.cyf.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过线程池执行线程(runnable方式)
 *
 * @author cyfIverson
 */
public class ThreadPoolWithRunnable {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        pool.shutdown();
    }
}
