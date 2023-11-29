package main;

import board.Board;
import board.BoardFactory;
import configuration.GameProperties;
import configuration.Parser;
import game.Game;
import rule.Rule;
import rule.RuleFactory;
import timedelayer.TimeDelayer;
import timedelayer.TimeDelayerFactory;
import view.ConsoleView;
import view.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        GameProperties g = GameProperties.getInstance();
        Parser p = Parser.getInstance();
        p.parseParams(args);
        p.parseParams(args);
        g.loadParams();
        Board b = BoardFactory.makeBoard(g.getBoardType(), g.getInitialState(), getRules());
        Game game = new Game(b, getDelayer());
        Observer view = new ConsoleView(game);
        game.simulate(g.getSteps());
    }


    public static List<Rule> getRules() {
        GameProperties g = GameProperties.getInstance();
        List<Rule> result = new ArrayList<>();
        boolean birth;
        String[] rules = g.getRules().split("/");
        Pattern pattern = Pattern.compile("[1-9]");
        for (String rule : rules) {
            Matcher matcher = pattern.matcher(rule);
            birth = rule.charAt(0) == 'B';
            while (matcher.find()) {
                if (birth)
                    result.add(RuleFactory.createBirthRule(Integer.parseInt(matcher.group())));
                else
                    result.add(RuleFactory.createSurviveRule(Integer.parseInt(matcher.group())));
            }
        }
        result.add(RuleFactory.createDeathRule());
        return result;
    }

    public static TimeDelayer getDelayer() {
        GameProperties g = GameProperties.getInstance();
        String coolDown = g.getTimeBetweenTicks();
        int i = coolDown.length();
        do
            i--;
        while(!Character.isDigit(coolDown.charAt(i)));
        i++;
        i = coolDown.length() - i;
        int number = Integer.parseInt(coolDown.substring(0,coolDown.length()-i));
        String mode = coolDown.substring(coolDown.length()-i);
        return TimeDelayerFactory.makeTimeDelayer(mode, number);
    }

}
