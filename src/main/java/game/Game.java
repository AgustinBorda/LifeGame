package game;

import board.Board;
import ruleapplicator.RuleApplicator;

public class Game {
    Board b;

    RuleApplicator applicator;

    public void tick() {
        applicator.applyRules();
    }

    public void simulate(int steps) {
        for(int i = 0; i < steps; i++)
            tick();
    }
}
