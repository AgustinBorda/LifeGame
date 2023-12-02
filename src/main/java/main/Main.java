package main;

import board.Board;
import board.BoardFactory;
import configuration.GameConfiguration;
import configuration.ArgumentLoader;
import configuration.Parser;
import game.Game;
import rule.RuleFactory;
import timedelayer.TimeDelayer;
import view.ConsoleView;
import view.Observer;

public class Main {

    public static void main(String[] args) {
        ArgumentLoader p = ArgumentLoader.getInstance();
        p.loadArgs(args);
        GameConfiguration configuration = GameConfiguration.getInstance();
        Parser parser = new Parser();
        configuration.loadConfiguratinon();
        Board b = BoardFactory.makeBoard(parser.getBoardType(), parser.getInitialState(), RuleFactory.createRules(parser.getRules()));
        TimeDelayer delayer = new TimeDelayer(parser.getDelayer());
        Game game = new Game(b, delayer);
        Observer view = new ConsoleView(game);
        game.simulate(parser.getSteps());
    }

}
