package com.cyf.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 观察的现象：一个线程获取到锁，另一个线程不会一直等待下去
 * @author cyfIverson
 * @description tryLock()的使用  tryLock(7000,TimeUnit.MILLISECONDS) 和tryLock()类似; [获取不到锁，就等7秒，如果7秒后还是获取不到就返回false]
 * @create 2018-04-01-13:42
 */
public class MyTryLock{
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    static Lock lock = new ReentrantLock();     //Lock是接口

    public static void main(String[] args){
        new Thread(){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                Boolean tryLock = lock.tryLock();
                System.out.println(thread.getName()+" "+tryLock);
                if (tryLock){
                    try {
                        System.out.println(thread.getName()+"得到锁");
                        for (int i=0;i<5;i++){
                            arrayList.add(i);

                            sleep(1000); //如果不加一个睡眠时间可能会看不到效果，因为线程执行的过程太快，tread-1也能获取到锁
                        }
                    }catch (Exception e){
                        // to handler exception
                    }finally {
                        System.out.println(thread.getName()+"释放锁");
                        lock.unlock();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                Boolean tryLock = lock.tryLock();
                System.out.println(thread.getName()+" "+tryLock);
                if (tryLock){
                    try {
                        System.out.println(thread.getName()+"得到锁");
                        for (int i=0;i<5;i++){
                            arrayList.add(i);
                        }
                    }catch (Exception e){
                        // to handler exception
                    }finally {
                        System.out.println(thread.getName()+"释放锁");
                        lock.unlock();
                    }
                }
            }
        }.start();
    }
}
