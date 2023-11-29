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
        notifyObservers();
    }

    public void simulate(int steps) {
        for(int i = 0; i < steps; i++) {
            tick();
            delayer.delay();
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers)
            o.update(b.toString());
    }
}
