package com.cyf.thread.learn;

/**
 * 扩展java.lang.Thread类
 *
 * @author cyfIverson
 * @description 多线程学习
 * @create 2018-03-25
 */
public class Thread1 extends Thread {

    private String name;
    public Thread1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
