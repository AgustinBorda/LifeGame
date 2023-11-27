package rule;

import cell.AliveState;
import cell.Cell;
import cell.DeadState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class RuleTests {
   @Mock
   Cell c;

   @BeforeEach
    public void setUp() {
       MockitoAnnotations.initMocks(this);
   }


   @ParameterizedTest
   @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
   public void alwaysCanApplyDeathRule(int cellNeighbors) {
      Rule death = RuleFactory.createDeathRule();
      when(c.numberOfAliveNeighbors()).thenReturn(cellNeighbors);
      assertTrue(death.canApply(c));
   }

   public static Stream<Arguments> actualAndDesiredNeighborsProvider() {
      List<Arguments> result = new ArrayList<>();
      for (int i = 0; i<9; i++) {
         for (int j = 0; j<9; j++) {
            result.add(Arguments.of(i,j));
         }
      }
      return result.stream();
   }

   @ParameterizedTest
   @MethodSource("actualAndDesiredNeighborsProvider")
   public void birthRuleCanOnlyBeAppliedToTheCorrectNeighbors(int expectedNeighbors, int actualNeighbors) {
      Rule r = RuleFactory.createBirthRule(expectedNeighbors);
      when(c.numberOfAliveNeighbors()).thenReturn(actualNeighbors);
      when(c.isAlive()).thenReturn(false);
      assertEquals(expectedNeighbors == actualNeighbors, r.canApply(c));
   }

   @ParameterizedTest
   @MethodSource("actualAndDesiredNeighborsProvider")
   public void surviveRuleCanOnlyBeAppliedToTheCorrectNeighbors(int expectedNeighbors, int actualNeighbors) {
      Rule r = RuleFactory.createSurviveRule(expectedNeighbors);
      when(c.numberOfAliveNeighbors()).thenReturn(actualNeighbors);
      when(c.isAlive()).thenReturn(true);
      assertEquals(expectedNeighbors == actualNeighbors, r.canApply(c));
   }

   @Test
   public void surviveRuleCanOnlyBeAppliedToAliveCells() {
      Rule r = RuleFactory.createSurviveRule(0);
      when(c.numberOfAliveNeighbors()).thenReturn(0);
      when(c.isAlive()).thenReturn(true);
      assertTrue(r.canApply(c));
      when(c.numberOfAliveNeighbors()).thenReturn(0);
      when(c.isAlive()).thenReturn(false);
      assertFalse(r.canApply(c));
   }

   @Test
   public void birthRuleCanOnlyBeAppliedToDeadCells() {
      Rule r = RuleFactory.createBirthRule(0);
      when(c.numberOfAliveNeighbors()).thenReturn(0);
      when(c.isAlive()).thenReturn(false);
      assertTrue(r.canApply(c));
      when(c.numberOfAliveNeighbors()).thenReturn(0);
      when(c.isAlive()).thenReturn(true);
      assertFalse(r.canApply(c));
   }

   @Test
   public void deathRuleSetsTheNextCellStateInDead() {
      Rule r = RuleFactory.createDeathRule();
      r.apply(c);
      verify(c).setNextState(new DeadState());
   }

   @Test
   public void surviveRuleSetsTheNextCellStateInAlive() {
      Rule r = RuleFactory.createSurviveRule(0);
      r.apply(c);
      verify(c).setNextState(new AliveState());
   }

   @Test
   public void birthRuleSetsTheNextCellStateInAlive() {
      Rule r = RuleFactory.createBirthRule(0);
      r.apply(c);
      verify(c).setNextState(new AliveState());
   }


}
