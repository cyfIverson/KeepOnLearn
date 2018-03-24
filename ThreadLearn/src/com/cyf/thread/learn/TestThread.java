package com.cyf.thread.learn;

/**
 * @author cyfIverson
 * @description 多线程线程
 * @create 2018-03-25-0:02
 * <p>
 * 总结：
 * <p>
 * 实现Runnable接口比继承Thread类所具有的优势：
 * A.适合多个相同的程序代码的线程去处理同一个资源
 * B.可以避免java中的单继承的限制
 * C.增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 * D.线程池只能放入实现Runnable或callable类线程，不能直接放入继承Thread的类
 */

public class TestThread {

    public static void main(String[] args) {
        /*Thread1 t1 = new Thread1("A");
        Thread1 t2 = new Thread1("B");
        t1.start();
        t2.start();*/

        new Thread(new Thread2("C")).start();
        new Thread(new Thread2("D")).start();
    }
}
