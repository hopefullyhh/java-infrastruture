package threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadFactoryDelegate implements ThreadFactory {
    private AtomicInteger seqNum = new AtomicInteger(1);

    private ThreadFactory threadFactory;
    private String prefix;

    public CustomThreadFactoryDelegate(ThreadFactory threadFactory, String prefix) {
        this.threadFactory = threadFactory;
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = threadFactory.newThread(r);
        thread.setName(prefix + "[" + seqNum.getAndAdd(1) + "]");
        return thread;
    }
}
