package threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(
                7,
                14,
                30,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new CustomThreadFactoryDelegate(Executors.defaultThreadFactory(), "测试线程池"),
                new ThreadPoolExecutor.AbortPolicy());
        AtomicInteger count = new AtomicInteger(1);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "->" + count.getAndAdd(1));
            });
        }
        threadPoolExecutor.shutdown();
        boolean shutdown = threadPoolExecutor.isShutdown();
        System.out.println("shutdown = " + shutdown);
        boolean terminating = threadPoolExecutor.isTerminating();
        System.out.println("terminating = " + terminating);
        boolean terminated = threadPoolExecutor.isTerminated();
        System.out.println("terminated = " + terminated);
        int i = 0;
        while (!terminated) {
            if (i < 10) {
                System.out.println("线程池中的任务还未执行完毕!!!");
                i++;
            }
            terminated = threadPoolExecutor.isTerminated();
        }
        System.out.println("线程池中的任务都执行完毕了...");
    }
}
