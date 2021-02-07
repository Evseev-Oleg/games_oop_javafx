package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    public Cell getPosition() {
        return position;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(Cell.findBy(getPosition().getX(), getPosition().getY()),dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(getPosition().getX() - dest.getX());
        Cell[] cells = new Cell[size];
         int distanceByX = dest.getX() - getPosition().getX();
         int distanceByY = dest.getY() - getPosition().getY();
         int deltaX = (distanceByX)/(Math.abs(distanceByX));
         int deltaY = (distanceByY)/(Math.abs(distanceByY));
        for (int i = 1; i <= size; i++) {
            cells[i - 1] = Cell.findBy((getPosition().getX() + i) * deltaX, (getPosition().getY() + i) * deltaY);
        }
        return cells;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
