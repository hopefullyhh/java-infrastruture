package observer;

public class ZhangSan implements Observer {
    @Override
    public void observe(Subject subject) {
        System.out.println(subject.getContent());
    }
}
