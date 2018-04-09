package com.cyf.thread.forvolatile;

/**
 * 实例说明：volatile修饰变量时 是非线程安全   这里主要跟++操作有关系，++操作分4个步骤
 * @author cyfIverson
 * @create 2018-04-09
 */
public class TestVolatile {

    public static volatile int numb = 0;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        numb++;
                    }
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(numb);
    }
}
