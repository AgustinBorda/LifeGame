package board;

import rule.Rule;

import java.util.List;

public class BoardFactory {
    public static Board makeBoard(BoardType type, String initialState, List<Rule> rules) {
        if(type == BoardType.FINITE)
            return new FiniteBoard(initialState, rules);
        if(type == BoardType.TOROIDAL)
            return new ToroidalBoard(initialState, rules);
        throw new IllegalArgumentException("No such board type");
    }
}
