package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    /**
     * 测试1：线程1持有锁不释放，线程二不会打印
     * 测试2：正常情况下，线程1永远比线程二先打印
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "获得了锁");
            } finally {
                lock.unlock();
            }
        }, "线程1").start();

        new Thread(() -> {
            try {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "获得了锁");
            } finally {
                lock.unlock();
            }
        }, "线程2").start();
    }
}
