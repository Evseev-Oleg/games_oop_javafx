package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenMoveTestThenTrue() throws FigureNotFoundException, OccupiedCellException,
            ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        logic.add(new KingBlack(Cell.D3));
        logic.add(new KingBlack(Cell.E4));
        boolean test = logic.move(Cell.C1, Cell.G5);
        assertThat(test, is(true));

    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveTestThenOccupiedCellException() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new KingBlack(Cell.D2));
        logic.add(new KingBlack(Cell.E4));
        boolean test = logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveTestThenFigureNotFoundException() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C2));
        logic.add(new KingBlack(Cell.D2));
        logic.add(new KingBlack(Cell.E4));
        boolean test = logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveTestThenImpossibleMoveException() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new KingBlack(Cell.D2));
        logic.add(new KingBlack(Cell.E4));
        boolean test = logic.move(Cell.C1, Cell.C2);
    }
}