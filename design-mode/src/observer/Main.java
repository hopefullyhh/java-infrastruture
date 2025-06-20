package observer;

/**
 * spring事件监听机制-观察者模式
 */
public class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Observer liSi = new LiSi();
        publisher.addObserver(liSi);
        Observer zhangSan = new ZhangSan();
        publisher.addObserver(zhangSan);
        Subject subject = new Subject();
        subject.setContent("hello");
        publisher.publish(subject);
    }
}
