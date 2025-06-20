package concurrent;

/**
 * 死锁产生的四个必要条件：资源互斥，请求与保持，不可剥夺，循环等待
 */
public class DeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread() + "获取lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "等待lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread() + "获取lock2");
                }
            }
        });
        thread1.setName("线程1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread() + "获取lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "等待lock1");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread() + "获取lock1");
                }
            }
        });
        thread2.setName("线程2");
        thread2.start();
    }
}
