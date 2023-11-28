package view;

import board.Board;
import board.FiniteBoard;
import game.Game;
import org.junit.jupiter.api.Test;
import rule.Rule;
import rule.RuleFactory;
import ruleapplicator.RuleApplicator;
import timedelayer.TimeDelayerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ConsoleViewTests {
    Board b;

    private String convertToStringToDisplayFormat(String s) {
        return s.replace("D", " ").replace("A","■");
    }

    @Test
    public void displayCapturesTheInitialBoardState() {
        b = new FiniteBoard("    \n AA \n A  ");
        ConsoleView view = new ConsoleView(b);
        String expected = convertToStringToDisplayFormat(b.toString());
        assertEquals(expected, view.display());
    }

    @Test
    public void displayCapturesTheBoardState() {
        b = new FiniteBoard("    \n AA \n A  ");
        List<Rule> rules = new ArrayList<>();
        rules.add(RuleFactory.createBirthRule(3));
        rules.add(RuleFactory.createSurviveRule(3));
        rules.add(RuleFactory.createSurviveRule(2));
        RuleApplicator r = new RuleApplicator(b, rules);
        Game g = new Game(b,r, TimeDelayerFactory.makeNullTimeDelayer());
        ConsoleView view = new ConsoleView(b);
        String expected = convertToStringToDisplayFormat(b.toString());
        assertEquals(expected, view.display());
        g.tick();
        expected = convertToStringToDisplayFormat(b.toString());
        assertEquals(expected, view.display());
        g.tick();
        expected = convertToStringToDisplayFormat(b.toString());
        assertEquals(expected, view.display());
        g.tick();
        expected = convertToStringToDisplayFormat(b.toString());
        assertEquals(expected, view.display());
    }

}
