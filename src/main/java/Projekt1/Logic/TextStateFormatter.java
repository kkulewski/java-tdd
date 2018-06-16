package Projekt1.Logic;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.StateFormatter;

public class TextStateFormatter implements StateFormatter
{
    private Map map;
    private Ship ship;

    public TextStateFormatter(Map map, Ship ship)
    {
        this.map = map;
        this.ship = ship;
    }

    @Override
    public String getCurrentState()
    {
        Coordinate shipCoordinate = ship.getCoordinate();
        char shipArrow = getShipDirectionArrow();

        int mapSize = map.getSize();
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < mapSize + 2; x++)
        {
            sb.append("#");
        }

        sb.append(System.lineSeparator());

        for (int x = 0; x < mapSize; x++)
        {
            sb.append("#");
            for (int y = 0; y < mapSize; y++)
            {
                Coordinate c = new Coordinate(x, y);
                if (c.X == shipCoordinate.X && c.Y == shipCoordinate.Y)
                {
                    sb.append(shipArrow);
                }
                else
                {
                    Field f = map.getField(c);
                    sb.append(f.getSymbol());
                }
            }

            sb.append("#");
            sb.append(System.lineSeparator());
        }

        for (int x = 0; x < mapSize + 2; x++)
        {
            sb.append("#");
        }

        sb.append(System.lineSeparator());
        return sb.toString();
    }

    private char getShipDirectionArrow()
    {
        Direction shipDirection = ship.getDirection();
        char arrow = ' ';

        if (shipDirection == Direction.North)
            arrow = '^';

        if (shipDirection == Direction.East)
            arrow = '>';

        if (shipDirection == Direction.South)
            arrow = 'V';

        if (shipDirection == Direction.West)
            arrow = '<';

        return arrow;
    }
}
