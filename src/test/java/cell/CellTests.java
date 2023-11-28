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
    static CellFactory factory;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        factory = new CellFactory(b);
        when(b.getColumns()).thenReturn(2);
    }

    @Test
    public void AliveCellIsAlive() {
        Cell c = factory.makeAliveCell();
        assertTrue(c.isAlive());
    }

    @Test
    public void DeadCellIsNotAlive() {
        Cell c = factory.makeDeadCell();
        assertFalse(c.isAlive());
    }

    @Test
    public void cellTransition() {
        Cell c = factory.makeAliveCell();
        assertTrue(c.isAlive());
        c.transition();
        c.setNextState(DeadState.getInstance());
        c.transition();
        assertFalse(c.isAlive());
        c.setNextState(DeadState.getInstance());
        c.transition();
        assertFalse(c.isAlive());
        c.setNextState(AliveState.getInstance());
        c.transition();
        assertTrue(c.isAlive());
    }

    @Test
    public void aliveNeighborsTest() {
        Cell c = factory.makeDeadCell();
        when(b.numberOfAliveNeighbors(c)).thenReturn(3);
        assertEquals(3, c.numberOfAliveNeighbors());
    }

    @Test
    public void cellIsInZeroZero() {
        Cell c = factory.makeAliveCell();
        assertEquals(0, c.getRow());
        assertEquals(0, c.getColumn());
    }

    @Test
    public void cellAreCreatedIndifferentPlaces() {
        Cell c = factory.makeAliveCell();
        assertEquals(0, c.getRow());
        assertEquals(0, c.getColumn());
        c = factory.makeDeadCell();
        assertEquals(0, c.getRow());
        assertEquals(1, c.getColumn());
        c = factory.makeDeadCell();
        assertEquals(1, c.getRow());
        assertEquals(0, c.getColumn());
        c = factory.makeAliveCell();
        assertEquals(1, c.getRow());
        assertEquals(1, c.getColumn());
    }
}
