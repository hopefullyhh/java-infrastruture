package observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void publish(Subject subject) {
        for (Observer observer : observers) {
            observer.observe(subject);
        }
    }
}
