package com.cyf.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * blockingQueue的消费者类
 *
 * @author cyfIverson
 * @create 2018-04-07
 */
public class BlockingQueueConsumer implements Runnable {
    BlockingQueue<String> queue;
    Random random = new Random();

    public BlockingQueueConsumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(10));
            System.out.println(Thread.currentThread().getName() + " trying----");
            String temp = queue.take(); //take()方法，如果queue是空的话，会阻塞当前线程进行等待
            System.out.println(Thread.currentThread().getName() + " get a job " + temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
