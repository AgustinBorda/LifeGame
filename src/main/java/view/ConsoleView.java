package view;

import board.Board;
import board.BoardIterator;
import board.Observable;
import cell.Cell;
import game.Game;

public class ConsoleView implements Observer {
    Board b;

    public ConsoleView(Board board) {
        b = board;
        b.addObserver(this);
        display();
    }

    public ConsoleView(Game g) {
        this(g.getBoard());
    }

    @Override
    public void update() {
        print(display());
    }

    @Override
    public String display() {
        StringBuilder res = new StringBuilder();
        BoardIterator iterator = b.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            Cell c = iterator.next();
            res.append(printCell(c));
            i++;
            if(i >= b.getColumns()) {
                res.append("\n");
                i = 0;
            }
        }
        return res.toString();
    }

    private void print(String content) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(content);
    }

    private String printCell(Cell c) {
        if(c.isAlive())
            return "■";
        else
            return " ";
    }
}
