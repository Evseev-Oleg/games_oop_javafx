package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Figure figure = new BishopBlack(Cell.C8);
        Cell pos = figure.position();
        assertThat(pos, is(Cell.findBy(2, 0)));
    }

    @Test
    public void testWay() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] cells = figure.way(Cell.G5);
        Cell[] expect = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells, is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayException() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] cells = figure.way(Cell.G7);
    }

    @Test
    public void testCopy() {
        Figure figure = new BishopBlack(Cell.B8);
        figure = figure.copy(Cell.A6);
        assertThat(figure.position(), is(Cell.findBy(0, 2)));
    }
}