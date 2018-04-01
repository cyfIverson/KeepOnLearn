package com.cyf.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock的使用
 *
 * @author cyfIverson
 * @create 2018-03-27-21:01
 */

public class MyLockTest {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    static Lock lock = new ReentrantLock(); //Lock是接口

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();

                lock.lock();
                try {
                    System.out.println(thread.getName() + "获取锁");
                    for (int i = 0; i < 5; i++) {
                        arrayList.add(i);
                    }
                } catch (Exception e) {
                    //to handle exception
                } finally {
                    System.out.println(thread.getName() + "释放锁");
                    lock.unlock();
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();

                lock.lock();
                try {
                    System.out.println(thread.getName() + "获取锁");
                    for (int i = 0; i < 5; i++) {
                        arrayList.add(i);
                    }
                } catch (Exception e) {
                    //to do  handle exception
                } finally {
                    System.out.println(thread.getName() + "释放锁");
                    lock.unlock();
                }
            }
        }.start();

        /**
         * 校验是arrayList的操作是不是同步的
         */
        new Thread() {
            public void run() {
                Thread thread = Thread.currentThread();
                lock.lock();
                try {
                    System.out.println(thread.getName() + "得到了锁");
                    System.out.println(arrayList);
                } catch (Exception e) {
                    // TODO: handle exception
                }finally {
                    System.out.println(thread.getName() + "释放了锁");
                    lock.unlock();
                }
            }
        }.start();
    }
}
