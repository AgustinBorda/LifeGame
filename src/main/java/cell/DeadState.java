package cell;

public class DeadState implements CellState {
    @Override
    public boolean alive() {
        return false;
    }


    @Override
    public String toString() {
        return "D";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DeadState;
    }
}
