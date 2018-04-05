package com.cyf.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 观察现象：如果thread-0得到锁，阻塞。。thread-1尝试获取锁，如果拿不到，则可以中断等待
 *
 * @author cyfIverson
 */
public class MyInterruptibly {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        MyInterruptibly myInterruptibly = new MyInterruptibly();
        MyThread thread0 = new MyThread(myInterruptibly);
        MyThread thread1 = new MyThread(myInterruptibly);
        thread0.start();
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();
        System.out.println("----------------");
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();  //注意，如果需要中断等待线程，必须将获取锁房子外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName() + "获取到锁");
            long time = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - time >= Integer.MAX_VALUE) {
                    break;
                    //插入数据
                }
            }

        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.print(thread.getName() + "释放锁");
        }
    }
}

class MyThread extends Thread {
    private MyInterruptibly myInterruptibly = null;

    public MyThread(MyInterruptibly myInterruptibly) {
        this.myInterruptibly = myInterruptibly;
    }

    @Override
    public void run() {
        try {
            myInterruptibly.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断了");
        }

    }
}
