package concurrent;

/**
 * 破坏死锁：破坏请求与保持条件，破坏不可剥夺条件，破坏循环等待条件
 * 该例子是破坏循环等待条件
 */
public class BreakDeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task, "线程1");
        thread1.start();
        Thread thread2 = new Thread(task, "线程2");
        thread2.start();
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
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
        }
    }
}
