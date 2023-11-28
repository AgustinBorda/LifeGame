package ruleapplicator;

import board.Board;
import board.BoardIterator;
import board.FiniteBoard;
import cell.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rule.Rule;
import rule.RuleFactory;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
public class RuleApplicatorTests {

    RuleApplicator applicator;
    Board b;
    @BeforeEach
    public void setUp() {
        b = new FiniteBoard(" A \nA  ");
        applicator = new RuleApplicator(b, Collections.singletonList(RuleFactory.createBirthRule(2)));
    }

    @Test
    public void applicatorAppliesRules() {
        applicator.applyRules();
        assertEquals("ADD\nDAD\n", b.toString());
    }

    @Test
    public void noRulesKillAllCells() {
        applicator = new RuleApplicator(b, Collections.emptyList());
        applicator.applyRules();
        assertEquals("DDD\nDDD\n", b.toString());
    }



}
