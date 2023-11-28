package main;

import board.Board;
import configuration.GameProperties;
import game.Game;
import ruleapplicator.RuleApplicator;
import view.ConsoleView;
import view.Observer;

public class Main {

    public static void main(String[] args) {
        GameProperties g = GameProperties.getInstance();
        g.parseParams(args);
        g.loadParams();
        Board b = g.getBoard();
        RuleApplicator applicator = new RuleApplicator(b, g.getRules());
        Game game = new Game(b, applicator, g.getDelayer());
        Observer view = new ConsoleView(game);
        game.simulate(g.getSteps());
    }
}
