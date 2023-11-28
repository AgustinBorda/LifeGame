package cell;

public class DeadState implements CellState {

    private static DeadState instance = new DeadState();

    public static DeadState getInstance() {
        return instance;
    }

    private DeadState() {}
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
