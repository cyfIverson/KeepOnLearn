package com.cyf.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * blockingQueue生产者类
 *
 * @author cyfIverson
 * @create 2018-04-07
 */

public class BlockingQueueProducer implements Runnable {
    BlockingQueue<String> queue;
    Random random = new Random();

    public BlockingQueueProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(random.nextInt(10));
                String task = " a producer 生产线程： " + Thread.currentThread().getName();
                System.out.println(task);
                queue.put(task); //put方法,如果队列没有空间的话,会阻塞当前线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
