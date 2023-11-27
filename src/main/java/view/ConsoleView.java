package view;

import board.Board;
import board.BoardIterator;
import board.Observable;
import cell.Cell;

public class ConsoleView implements Observer {
    Board b;

    public ConsoleView(Board board) {
        b = board;
        b.addObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    @Override
    public void display() {
        BoardIterator iterator = b.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            Cell c = iterator.next();
            printCell(c);
            i++;
            if(i >= b.getColumns()) {
                System.out.println();
                i = 0;
            }
        }
    }

    private void printCell(Cell c) {
        if(c.isAlive())
            System.out.print(" ■ ");
        else
            System.out.print("   ");
    }
}
