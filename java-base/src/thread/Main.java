package thread;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new InteractivePrintOddEven(0));
        thread.setName("Thread-1");
        thread.start();

        Thread thread1 = new Thread(new InteractivePrintOddEven(1));
        thread1.setName("Thread-2");
        thread1.start();
    }
}
