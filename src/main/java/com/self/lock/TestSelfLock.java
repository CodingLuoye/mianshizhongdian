package com.self.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author YCKJ1409
 * 自写锁测试
 */
public class TestSelfLock {

    public void test(){
        final Lock lock = new SelfLock();
        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        SleepTools.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepTools.second(1);
                    }finally {
                        lock.unlock();
                    }
                    SleepTools.second(2);
                }
            }
        }

        for (int i =0;i<10;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i =0;i<10;i++){
            SleepTools.second(1);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TestSelfLock testSelfLock = new TestSelfLock();
        testSelfLock.test();
    }

}
