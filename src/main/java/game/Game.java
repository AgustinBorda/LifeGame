package game;

import board.Board;
import timedelayer.TimeDelayer;
import view.Observer;

public class Game extends Observable {
    private Board b;

    private TimeDelayer delayer;

    public Game(Board b, TimeDelayer d) {
        this.b = b;
        delayer = d;
    }

    public Board getBoard() {
        return b;
    }

    public void tick() {
        b.nextState();
    }

    public void simulate(int steps) {
        notifyObservers();
        for(int i = 0; i < steps; i++) {
            tick();
            delayer.delay();
            notifyObservers();
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers)
            o.update(b.toString());
    }
}
