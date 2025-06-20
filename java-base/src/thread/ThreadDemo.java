package thread;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static void main(String[] args) {
        // 获取当前线程所在组
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("threadGroup = " + threadGroup);

        Thread t1 = new Thread("thread 1") {
            @Override
            public void run() {
                System.out.println("通过匿名内部类创建线程");
                for(;;) {}
            }
        };
        // 标记该线程为守护线程，当只有守护线程时，退出JVM
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("通过Lambda表达式创建线程");
        }, "线程2");
        t2.start();

        Thread t3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕!");
        }, "线程3");
        t3.start();
        try {
            //阻塞当前线程，直到join的线程执行完毕
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t4 = new Thread(() -> {
          throw new RuntimeException("抛出未捕获的异常");
        }, "线程4");
        t4.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(e.getMessage());
        });
        t4.start();

        Thread t5 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            // 获取标识位, true
            System.out.println("thread.isInterrupted() = " + thread.isInterrupted());
            // 获取标识位并改变标识位, true -> false
            System.out.println("Thread.interrupted() = " + Thread.interrupted());
            // 再次获取标识位, false
            System.out.println("thread.isInterrupted() = " + thread.isInterrupted());
        }, "线程5");
        t5.start();
        // 改变中断标识位, false -> true
        t5.interrupt();
    }

    static class Way01ForCreatingThread extends Thread {
        @Override
        public void run() {
            System.out.println("通过继承Thread创建线程");
        }

        public static void main(String[] args) {
            new Way01ForCreatingThread().start();
        }
    }

     static class WayO2ForCreatingThread implements Runnable {
        @Override
        public void run() {
            System.out.println("通过实现Runnable创建");
        }

        public static void main(String[] args) {
            new Thread(new WayO2ForCreatingThread()).start();
        }
    }

    /**
     * 其余的创建方式都基于以上两种方式
     */
}
