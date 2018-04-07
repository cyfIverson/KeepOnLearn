package com.cyf.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 测试blockingQueue类
 *
 * @author cyfIverson
 * @create 2018-04-07
 */
public class TestBlockingQueue {

    public static void main(String[] args) {
        //设置queue的大小是2
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(2);
        //不设置默认的大小是Integer.MAX_VALUE
        //BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        //BlockingQueue<String> queue = new ArrayBlockingQueue<String>();

        BlockingQueueProducer producer = new BlockingQueueProducer(queue);
        BlockingQueueConsumer consumer = new BlockingQueueConsumer(queue);

        for (int i = 0; i < 3; i++) {
            new Thread(producer, "producer" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(consumer, "consumer" + i).start();
        }
    }
}
