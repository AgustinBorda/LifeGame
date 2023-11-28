package board;

public class BoardFactory {
    public static Board makeBoard(String type, String initialState) {
        if(type.equals("finite"))
            return new FiniteBoard(initialState);
        if(type.equals("toroidal"))
            return new ToroidalBoard(initialState);
        throw new IllegalArgumentException("No such board type");
    }
}
