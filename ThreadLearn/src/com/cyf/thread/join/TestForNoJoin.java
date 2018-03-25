package com.cyf.thread.join;

/**
 * @author cyfIverson
 * @description 线程不加join()方法的情况
 * @create 2018-03-25-23:03
 */

public class TestForNoJoin {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+"主线程开始运行");
        Thread1 th1 = new Thread1("A");
        Thread1 th2 = new Thread1("B");
        th1.start();
        th2.start();
        System.out.println(Thread.currentThread().getName()+"主线程运行结束");
    }
}
