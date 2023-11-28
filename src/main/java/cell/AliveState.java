package cell;

public class AliveState implements CellState {

    private static AliveState instance = new AliveState();

    private AliveState() {}

    public static AliveState getInstance() {
        return instance;
    }
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
