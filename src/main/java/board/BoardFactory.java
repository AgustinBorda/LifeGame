package board;

import rule.Rule;

import java.util.List;

public class BoardFactory {
    public static Board makeBoard(String type, String initialState, List<Rule> rules) {
        if(type.equals("finite"))
            return new FiniteBoard(initialState, rules);
        if(type.equals("toroidal"))
            return new ToroidalBoard(initialState, rules);
        throw new IllegalArgumentException("No such board type");
    }
}
