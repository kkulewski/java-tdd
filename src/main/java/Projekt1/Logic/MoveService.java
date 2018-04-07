package Projekt1.Logic;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.IMoveService;
import lombok.Getter;

public class MoveService implements IMoveService
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

    @Override
    public boolean turnRight()
    {
        Direction newDirection = Direction.right(ship.getDirection());
        this.ship.setDirection(newDirection);
        return true;
    }

    @Override
    public boolean turnLeft()
    {
        Direction newDirection = Direction.left(ship.getDirection());
        this.ship.setDirection(newDirection);
        return true;
    }

    @Override
    public boolean moveForward()
    {
        return moveToCoordinate(getCoordinateAhead());
    }

    @Override
    public boolean moveBack()
    {
        return moveToCoordinate(getCoordinateBehind());
    }

    @Override
    public boolean shoot()
    {
        Coordinate targetCoordinate = getCoordinateAhead();
        Field targetField = this.map.getField(targetCoordinate);

        if (targetField == Field.Land)
        {
            this.map.setField(targetCoordinate, Field.Water);
            return true;
        }

        return false;
    }

    private boolean moveToCoordinate(Coordinate coordinate)
    {
        if (canMoveToCoordinate(coordinate))
        {
            this.ship.setCoordinate(coordinate);
            return true;
        }

        return false;
    }

    private boolean canMoveToCoordinate(Coordinate coordinate)
    {
        return this.map.getField(coordinate) == Field.Water;
    }

    private Coordinate getCoordinateAhead()
    {
        return getCoordinate(1);
    }

    private Coordinate getCoordinateBehind()
    {
        return getCoordinate(-1);
    }

    private Coordinate getCoordinate(int direction)
    {
        int targetX = 0;
        int targetY = 0;
        int mapSize = this.map.getSize();

        if (this.ship.getDirection() == Direction.North)
        {
            targetY = (this.ship.getCoordinate().Y + mapSize - direction) % mapSize;
        }

        if (this.ship.getDirection() == Direction.South)
        {
            targetY = (this.ship.getCoordinate().Y + mapSize + direction) % mapSize;
        }

        if (this.ship.getDirection() == Direction.East)
        {
            targetX = (this.ship.getCoordinate().X + mapSize + direction) % mapSize;
        }

        if (this.ship.getDirection() == Direction.West)
        {
            targetX = (this.ship.getCoordinate().X + mapSize - direction) % mapSize;
        }

        return new Coordinate(targetX, targetY);
    }
}
