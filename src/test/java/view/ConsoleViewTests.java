package view;

import board.Board;
import board.FiniteBoard;
import game.Game;
import org.junit.jupiter.api.Test;
import rule.Rule;
import rule.RuleFactory;
import timedelayer.TimeDelayerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ConsoleViewTests {
    Board b;

    private String convertToStringToDisplayFormat(String s) {
        return s.replace("D", " ").replace("A","■");
    }

    @Test
    public void displayCapturesTheInitialBoardState() {
        b = new FiniteBoard("    \n AA \n A  ", Collections.emptyList());
        Game g = new Game(b,TimeDelayerFactory.makeNullTimeDelayer());
        ConsoleView view = new ConsoleView(g);
        String expected = convertToStringToDisplayFormat(b.toString());
        assertEquals(expected, view.display());
    }

    @Test
    public void displayCapturesTheBoardState() {
        List<Rule> rules = new ArrayList<>();
        rules.add(RuleFactory.createBirthRule(3));
        rules.add(RuleFactory.createSurviveRule(3));
        rules.add(RuleFactory.createSurviveRule(2));
        rules.add(RuleFactory.createDeathRule());
        b = new FiniteBoard("    \n AA \n A  ", rules);
        Game g = new Game(b, TimeDelayerFactory.makeNullTimeDelayer());
        ConsoleView view = new ConsoleView(g);
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
