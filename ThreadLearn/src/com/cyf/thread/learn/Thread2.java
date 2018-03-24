package com.cyf.thread.learn;

/**
 * 实现java.lang.Runnable接口
 *
 * @author cyfIveson
 * @description 多线程学习
 * @create 2018-03-25
 */

public class Thread2 implements Runnable {

    private String name;
    public Thread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}