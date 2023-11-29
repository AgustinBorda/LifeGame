package cell;

import board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CellTests {
    @Mock
    Board b;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(b.getColumns()).thenReturn(2);
        when(b.getRows()).thenReturn(2);
    }

    @Test
    public void AliveCellIsAlive() {
        Cell c = CellFactory.makeAliveCell(b, 0 ,0);
        assertTrue(c.isAlive());
    }

    @Test
    public void DeadCellIsNotAlive() {
        Cell c = CellFactory.makeDeadCell(b, 0 ,0);
        assertFalse(c.isAlive());
    }

    @Test
    public void aliveNeighborsTest() {
        Cell c = CellFactory.makeDeadCell(b, 0, 0);
        when(b.numberOfAliveNeighbors(c)).thenReturn(3);
        assertEquals(3, c.numberOfAliveNeighbors());
    }

    @Test
    public void cellIsInGivenPosition() {
        Cell c = CellFactory.makeDeadCell(b, 0, 1);
        assertEquals(0, c.getRow());
        assertEquals(1, c.getColumn());
    }

    @Test
    public void cellsMustBeInsideBoard() {
        assertThrows(IllegalArgumentException.class, () -> CellFactory.makeAliveCell(b,3,1));
    }
}
