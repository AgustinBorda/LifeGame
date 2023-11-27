package cell;

public class AliveState implements CellState {
    @Override
    public boolean alive() {
        return true;
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AliveState;
    }
}
