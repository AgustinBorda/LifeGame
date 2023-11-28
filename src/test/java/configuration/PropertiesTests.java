package configuration;

import board.Board;
import board.FiniteBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.Rule;
import rule.RuleFactory;
import timedelayer.TimeDelayer;
import timedelayer.TimeDelayerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PropertiesTests {
    GameProperties g;
    @BeforeEach
    public void setUp() {
        g = GameProperties.getInstance();
    }

    @Test
    public void getBoardTest() {
        g.setProperty("BOARD_TYPE", "finite");
        g.setProperty("INITIAL_STATE", "    \n AA \n AA \n    ");
        Board b = g.getBoard();
        assertTrue(b instanceof FiniteBoard);
        assertEquals(b, new FiniteBoard("    \n AA \n AA \n    "));
    }

    @Test
    public void getRulesTest() {
        g.setProperty("RULES", "S23/B3");
        List<Rule> rules = g.getRules();
        assertTrue(rules.contains(RuleFactory.createBirthRule(3)));
        assertTrue(rules.contains(RuleFactory.createSurviveRule(3)));
        assertTrue(rules.contains(RuleFactory.createSurviveRule(2)));
        assertEquals(3, rules.size());
    }

    @Test
    public void getMoreRulesTest() {
        g.setProperty("RULES", "S23456/B378");
        List<Rule> rules = g.getRules();
        assertTrue(rules.contains(RuleFactory.createBirthRule(3)));
        assertTrue(rules.contains(RuleFactory.createBirthRule(7)));
        assertTrue(rules.contains(RuleFactory.createBirthRule(8)));
        assertTrue(rules.contains(RuleFactory.createSurviveRule(3)));
        assertTrue(rules.contains(RuleFactory.createSurviveRule(2)));
        assertTrue(rules.contains(RuleFactory.createSurviveRule(4)));
        assertTrue(rules.contains(RuleFactory.createSurviveRule(5)));
        assertTrue(rules.contains(RuleFactory.createSurviveRule(6)));
        assertEquals(8, rules.size());
    }

    @Test
    public void getSecondDelayerTest() {
        g.setProperty("TIME_BETWEEN_TICKS", "2s");
        TimeDelayer delayer = g.getDelayer();
        assertEquals(TimeDelayerFactory.makeTimeDelayer("s", 2), delayer);
    }

    @Test
    public void getMinuteDelayerTest() {
        g.setProperty("TIME_BETWEEN_TICKS", "4m");
        TimeDelayer delayer = g.getDelayer();
        assertEquals(TimeDelayerFactory.makeTimeDelayer("m", 4), delayer);
    }
}
