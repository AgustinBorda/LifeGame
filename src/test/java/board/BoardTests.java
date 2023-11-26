package board;

import cell.AliveState;
import cell.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class BoardTests {
    String originalState;
    Board b;
    @BeforeEach
    public void setUp() {
        originalState = "    \n" +
                "  A \n" +
                "A  A\n" +
                "AAAA\n" +
                " A A";
        b = new FiniteBoard(originalState);
    }

    @Test
    public void boardReflectsOriginalState() {
        String expected = "DDDD\n" +
                "DDAD\n" +
                "ADDA\n" +
                "AAAA\n" +
                "DADA\n";
        assertEquals(expected, b.toString());
    }

    @Test
    public void boardHasTheCorrectDimensions() {
        assertEquals(4, b.getColumns());
        assertEquals(5, b.getRows());
    }

    @Test
    public void iteratorIteratesOverAllAndTransitionWorks() {
        originalState = "    \n" +
                "    \n" +
                "    \n";
        b = new FiniteBoard(originalState);
        BoardIterator iterator = b.iterator();
        while(iterator.hasNext()) {
            iterator.next().setNextState(new AliveState());
        }
        b.transition();
        iterator = b.iterator();
        while(iterator.hasNext())
            assertTrue(iterator.next().isAlive());
    }

    @Test
    public void badInitialState() {
        originalState = "  \n" +
                " \n";
        assertThrows(IllegalArgumentException.class, () -> b = new FiniteBoard(originalState),
                "The board must be rectangular");
    }

    public static Stream<Arguments> CellLocationAndNeighborsProvider() {
        return Stream.of(
                Arguments.of(0,0,0),
                Arguments.of(0,1,1),
                Arguments.of(0,2,1),
                Arguments.of(0,3,1),
                Arguments.of(1,0,1),
                Arguments.of(1,1,2),
                Arguments.of(1,2,1),
                Arguments.of(1,3,2),
                Arguments.of(2,0,2),
                Arguments.of(2,1,5),
                Arguments.of(2,2,5),
                Arguments.of(2,3,3),
                Arguments.of(3,0,3),
                Arguments.of(3,1,4),
                Arguments.of(3,2,5),
                Arguments.of(3,3,3),
                Arguments.of(4,0,3),
                Arguments.of(4,1,3),
                Arguments.of(4,2,5),
                Arguments.of(4,3,2)
        );
    }

    @ParameterizedTest
    @MethodSource("CellLocationAndNeighborsProvider")
    public void FiniteBoardNeighborsTest(int row, int column, int neighbors) {
        Cell c = b.getCell(row,column);
        assertEquals(neighbors, c.numberOfAliveNeighbors());
    }
}
