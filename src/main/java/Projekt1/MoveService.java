package Projekt1;

import Projekt1.Entities.Direction;
import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;
import lombok.Getter;

public class MoveService
{
    @Getter
    private Map map;

    @Getter
    private Ship ship;

    public MoveService(Map map, Ship ship)
    {
        this.map = map;
        this.ship = ship;
    }

    public Direction getShipDirection()
    {
        return this.getShip().getDirection();
    }

    public int getShipX()
    {
        return this.getShip().getX();
    }
}
