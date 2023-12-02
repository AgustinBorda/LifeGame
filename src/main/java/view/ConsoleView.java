package view;

import board.Board;
import board.BoardIterator;
import cell.Cell;
import game.Game;
import game.Observable;

public class ConsoleView implements Observer {

    private String state;

    public ConsoleView(Observable g) {
        g.addObserver(this);
    }

    @Override
    public void update(String state) {
        this.state = state;
        print(display());
    }

    @Override
    public String display() {
        return state.replace("D", " ").replace("A", "■");
    }

    private void print(String content) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(content);
    }

}
