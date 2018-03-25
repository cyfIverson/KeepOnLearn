package com.cyf.thread.join;

/**
 * @author cyfIverson
 * @description 创建线程类
 * @create 2018-03-25-22:56
 */

public class Thread1 extends Thread {
    private String name;

    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "线程开始！");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + name + "运行" + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "线程结束！  ");
    }
}
