package game;

import board.Board;
import ruleapplicator.RuleApplicator;
import timedelayer.TimeDelayer;

public class Game {
    private Board b;

    private RuleApplicator applicator;
    private TimeDelayer delayer;

    public Game(Board b, RuleApplicator a, TimeDelayer d) {
        this.b = b;
        applicator = a;
        delayer = d;
    }

    public Board getBoard() {
        return b;
    }

    public void tick() {
        applicator.applyRules();
    }

    public void simulate(int steps) {
        for(int i = 0; i < steps; i++) {
            tick();
            delayer.delay();
        }
    }
}
