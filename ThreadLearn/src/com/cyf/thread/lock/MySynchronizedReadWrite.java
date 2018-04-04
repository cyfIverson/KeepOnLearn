package com.cyf.thread.lock;

/**
 * @author cyfIverson
 * @description 一个线程要读要写，用synchronize来实现的话，读写操作都只能锁住后一个线程地执行
 * @create 2018-04-04
 */
public class MySynchronizedReadWrite {

    public static void main(String[] args){
        final MySynchronizedReadWrite test = new MySynchronizedReadWrite();
        //线程一
        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        //线程二
        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public synchronized void get(Thread thread){
        long start = System.currentTimeMillis();
        int i = 0;
        while (System.currentTimeMillis()- start <=1){
            i++;
            if (i%4==0){
                System.out.println(thread.getName()+"正在进行写操作");
            }else {
                System.out.println(thread.getName()+"正在进行读操作");
            }
        }
        System.out.println(thread.getName()+"读写操作完毕");
    }
}
