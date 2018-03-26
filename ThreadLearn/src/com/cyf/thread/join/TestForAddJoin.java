package com.cyf.thread.join;

/**
 * join()方法的使用
 * @author cyfIverson
 * @create 2018-03-25-23:08
 */

public class TestForAddJoin {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+"主线程开始运行");
        Thread1 th1 = new Thread1("A");
        Thread1 th2 = new Thread1("B");
        th1.start();
        th2.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"主线程运行结束");
    }
}

/**
 * 为什么使用join()
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
 * 但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，
 * 这个时候就要用到join()方法了。
 */
