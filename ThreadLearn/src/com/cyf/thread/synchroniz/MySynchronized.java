package com.cyf.thread.synchroniz;

/**
 * 关于synchronized关键字的使用
 *
 * @author cyfIverson
 * @create 2018-03-26-22:25
 */

public class MySynchronized {

    public static void main(String[] args) {
        //两把锁
        MySynchronized mySynchronized1 = new MySynchronized();
        MySynchronized mySynchronized2 = new MySynchronized();


        new Thread("thread1") {
            @Override
            public void run() {
                synchronized (mySynchronized1) {
                    try {
                        System.out.println(this.getName() + "start");
                        Thread.sleep(5000);
                        // int i = 1/0;     //如果发生异常 jvm会释放锁
                        System.out.println(this.getName() + "醒了");
                        System.out.println(this.getName() + "end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();

        new Thread("thread2") {
            @Override
            public void run() {
                //synchronized (mySynchronized1){          //争抢同一把锁时，线程1没释放之前，线程2只能等待
                synchronized (mySynchronized2) {    //如果不是一把锁，可以看到两句话同时打印

                    System.out.println(this.getName() + "start");
                    System.out.println(this.getName() + "end");
                }
            }
        }.start();
    }
}

/**
 * 关于synchronized关键字的使用： synchronized关键字可以修饰代码块，方法
 * 一个代码块被synchronized修饰了，当一个线程获取了对应的锁，并执行该代码块时，其他线程便只能一直等待，
 * 等待获取锁的线程释放锁，一个代码块被synchronized修饰了，当一个线程获取了对应的锁，并执行该代码块时，
 * 其他线程便只能一直等待，等待获取锁的线程释放锁
 * <p>
 * 获取锁的线程其释放锁的两种情况：
 * (1)获取锁的线程执行完了该代码块，然后线程释放对锁的占有
 * (2)线程执行发生异常，此时JVM会让线程自动释放锁
 *
 * 缺点：
 * (1)等待的线程必须等获取到锁的线程释放锁之后才可以使用,就会出现效率很低的情况(死锁、睡眠等)
 * (2)
 */

