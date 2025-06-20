package thread;

public class InteractivePrintOddEven implements Runnable{
    private static int num = 1;

    private int flag;

    public InteractivePrintOddEven(int flag) {
        this.flag = flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            for (; num <= 100;) {
                synchronized (InteractivePrintOddEven.class) {
                    if (flag == 0) {
                        flag = 1;
                        InteractivePrintOddEven.class.wait();
                    }
                    InteractivePrintOddEven.class.notify();
                    System.out.println(Thread.currentThread().getName() + ",i = " + num);
                    num++;
                    if (num <= 100) {
                        InteractivePrintOddEven.class.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
