package game;

import board.BoardFactory;
import board.FiniteBoard;
import board.Board;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import rule.Rule;
import rule.RuleFactory;
import ruleapplicator.RuleApplicator;
import timedelayer.TimeDelayerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class GameTests {
    List<Rule> rules = new ArrayList<>();
    @BeforeEach
    public void setUp() {
        rules = new ArrayList<>();
        rules.add(RuleFactory.createSurviveRule(2));
        rules.add(RuleFactory.createSurviveRule(3));
        rules.add(RuleFactory.createBirthRule(3));
    }

    public static Stream<Arguments> stillLifesProvider() {
        return Stream.of(
                Arguments.of("    \n" +
                        " AA \n" +
                        " AA \n" +
                        "    "),
                Arguments.of( "      \n" +
                        "  AA  \n" +
                        " A  A \n" +
                        "  AA  \n" +
                        "      "),
                Arguments.of("      \n" +
                        "  AA  \n" +
                        " A  A \n" +
                        "  A A \n" +
                        "   A  \n" +
                        "      "),
                Arguments.of("      \n" +
                        " AA   \n" +
                        " A A  \n" +
                        "  A   \n" +
                        "      "),
                Arguments.of("     \n" +
                        "  A  \n" +
                        " A A \n" +
                        "  A  \n" +
                        "     ")
        );
    }
    @ParameterizedTest
    @MethodSource("stillLifesProvider")
    public void stillLifesTest(String initialState) {
        Board b = new FiniteBoard(initialState);
        Board clone = new FiniteBoard(initialState);
        RuleApplicator applicator = new RuleApplicator(b, rules);
        Game g = new Game(b, applicator, TimeDelayerFactory.makeNullTimeDelayer());
        assertEquals(clone, b);
        g.tick();
        assertEquals(clone, b);
        g.tick();
        assertEquals(clone, b);
    }

    public static Stream<Arguments> oscillatorProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        "     \n" +
                        "  A  \n" +
                        "  A  \n" +
                        "  A  \n" +
                        "     ",

                        "     \n" +
                        "     \n" +
                        " AAA \n" +
                        "     \n" +
                        "     ")),
                Arguments.of(Arrays.asList(
                        "      \n" +
                        "      \n" +
                        "  AAA \n" +
                        " AAA  \n" +
                        "      \n" +
                        "      \n",

                            "      \n" +
                                "   A  \n" +
                                " A  A \n" +
                                " A  A \n" +
                                "  A   \n" +
                                "      "
                )),
                Arguments.of(Arrays.asList(
                                "      \n" +
                                " AA   \n" +
                                " AA   \n" +
                                "   AA \n" +
                                "   AA \n" +
                                "      \n",

                                "      \n" +
                                " AA   \n" +
                                " A    \n" +
                                "    A \n" +
                                "   AA \n" +
                                "      "
                )),
                Arguments.of(Arrays.asList("               \n" +
                        "   AAA   AAA   \n" +
                        "               \n" +
                        " A    A A    A \n" +
                        " A    A A    A \n" +
                        " A    A A    A \n" +
                        "   AAA   AAA   \n" +
                        "               \n" +
                        "   AAA   AAA   \n" +
                        " A    A A    A \n" +
                        " A    A A    A \n" +
                        " A    A A    A \n" +
                        "               \n" +
                        "   AAA   AAA   \n" +
                        "               ",

                        "    A     A    \n" +
                                "    A     A    \n" +
                                "    AA   AA    \n" +
                                "               \n" +
                                "AAA  AA AA  AAA\n" +
                                "  A A A A A A  \n" +
                                "    AA   AA    \n" +
                                "               \n" +
                                "    AA   AA    \n" +
                                "  A A A A A A  \n" +
                                "AAA  AA AA  AAA\n" +
                                "               \n" +
                                "    AA   AA    \n" +
                                "    A     A    \n" +
                                "    A     A    ",

                        "               \n" +
                                "   AA     AA   \n" +
                                "    AA   AA    \n" +
                                " A  A A A A  A \n" +
                                " AAA AA AA AAA \n" +
                                "  A A A A A A  \n" +
                                "   AAA   AAA   \n" +
                                "               \n" +
                                "   AAA   AAA   \n" +
                                "  A A A A A A  \n" +
                                " AAA AA AA AAA \n" +
                                " A  A A A A  A \n" +
                                "    AA   AA    \n" +
                                "   AA     AA   \n" +
                                "               "))
        );
    }

    @ParameterizedTest
    @MethodSource("oscillatorProvider")
    public void oscillatorTest(List<String> states) {
        Board b = new FiniteBoard(states.get(0));
        RuleApplicator applicator = new RuleApplicator(b, rules);
        Game g = new Game(b, applicator,TimeDelayerFactory.makeNullTimeDelayer());
        for(int i = 1; i< states.size(); i++) {
           g.tick();
           assertEquals(b, new FiniteBoard(states.get(i)));
        }
        g.tick();
        assertEquals(b, new FiniteBoard(states.get(0)));
    }

    @Test
    public void simulateCanResetPeriod() {

        String initialState ="               \n" +
                "   AAA   AAA   \n" +
                "               \n" +
                " A    A A    A \n" +
                " A    A A    A \n" +
                " A    A A    A \n" +
                "   AAA   AAA   \n" +
                "               \n" +
                "   AAA   AAA   \n" +
                " A    A A    A \n" +
                " A    A A    A \n" +
                " A    A A    A \n" +
                "               \n" +
                "   AAA   AAA   \n" +
                "               ";
        Board b = BoardFactory.makeBoard("finite", initialState);
        RuleApplicator applicator = new RuleApplicator(b, rules);
        Game g = new Game(b, applicator,TimeDelayerFactory.makeNullTimeDelayer());
        g.simulate(3);
        assertEquals(BoardFactory.makeBoard("finite", initialState), b);

    }

}
