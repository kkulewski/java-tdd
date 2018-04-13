package Projekt1.Logic;

import static org.assertj.core.api.Assertions.*;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.IStateFormatter;
import org.junit.jupiter.api.Test;

class StateFormatterTest
{
    @Test
    void getCurrentStateReturnsExpectedString()
    {
        // Arrange
        Field[] row1 = { Field.Water, Field.Water, Field.Water };
        Field[] row2 = { Field.Water, Field.Land, Field.Land };
        Field[] row3 = { Field.Water, Field.Water, Field.Land };
        Field[][] fields = { row1, row2, row3 };
        Map map = new Map(fields);
        Ship ship = new Ship(Direction.North, new Coordinate(0, 0));
        IStateFormatter sf = new StateFormatter(map, ship);

        // Act
        String result = sf.getCurrentState();

        // Assert
        StringBuilder sb = new StringBuilder();
        sb.append("#####"); sb.append(System.lineSeparator());
        sb.append("#^  #"); sb.append(System.lineSeparator());
        sb.append("# OO#"); sb.append(System.lineSeparator());
        sb.append("#  O#"); sb.append(System.lineSeparator());
        sb.append("#####"); sb.append(System.lineSeparator());
        String expected = sb.toString();

        assertThat(result).contains(expected);
    }
}
