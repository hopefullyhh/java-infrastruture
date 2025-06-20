package observer;

public class LiSi implements Observer {
    @Override
    public void observe(Subject subject) {
        System.out.println(subject.getContent());
    }
}
