package com.company.spring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: 小于
 * @DATE: [2019/12/24  20:52]
 * @DESC: 1. 练习 提供增加元素和获取元素数量的方法
 * 2. 启动两个线程 线程1向容器中增加10个元素  线程二监听元素数量 当元素的数量为5时,线程2输出信息并终止
 */
public class Test_1 {

    private static final Object LOCK = new Object();
    private static List<Integer> countList = new ArrayList<>(10);


    private static class ThreadNum1 extends Thread {
        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = 0; i < 10; i++) {

                    System.out.println(this.getName() + "*****" + countList.size());
                    countList.add(i);
                    if (countList.size() == 5) {
                        LOCK.notifyAll();
                        try {
                            LOCK.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("----------------------------------");
        }
    }


    private static class ThreadNum2 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (countList.size() != 5) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(this.getName() + "&&&&&&" + countList.size());
                        LOCK.notifyAll();
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        ThreadNum1 t1 = new ThreadNum1();
        ThreadNum2 t2 = new ThreadNum2();
        t2.start();
        t1.start();
    }
}
