package game;

import view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public abstract void notifyObservers();
}
