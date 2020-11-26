package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void BishopBlackWayTrue() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell[] expectedWay = figure.way(Cell.G5);
        Cell[] trueWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expectedWay, is(trueWay));
    }

    @Test(expected = IllegalStateException.class)
    public void BishopBlackWayFalse() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell[] expectedWay = figure.way(Cell.C2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void FigureNotFound()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.C2);
    }

    @Test(expected = OccupiedCellException.class)
    public void WhenAFigureStandsInTheWay()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack figure1 = new BishopBlack(Cell.A1);
        logic.add(figure1);
        BishopBlack figure2 = new BishopBlack(Cell.B2);
        logic.add(figure2);
        logic.move(Cell.A1, Cell.C3);
    }
}