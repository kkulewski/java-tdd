package Projekt1;

import Projekt1.Entities.*;
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

    public Coordinate getShipCoordinate()
    {
        return this.getShip().getCoordinate();
    }

    public void turnRight()
    {
        Direction newDirection = Direction.right(ship.getDirection());
        this.ship.setDirection(newDirection);
    }

    public void turnLeft()
    {
        Direction newDirection = Direction.left(ship.getDirection());
        this.ship.setDirection(newDirection);
    }

    public boolean moveForward()
    {
        return moveToCoordinate(getCoordinateAhead());
    }

    public boolean moveBack()
    {
        return moveToCoordinate(getCoordinateBehind());
    }

    public boolean shoot()
    {
        Coordinate targetCoordinate = getCoordinateAhead();
        Field targetField = this.getMap().getField(targetCoordinate);

        if (targetField == Field.Water)
        {
            return false;
        }

        return true;
    }

    private boolean moveToCoordinate(Coordinate coordinate)
    {
        if (canMoveToCoordinate(coordinate))
        {
            this.getShip().setCoordinate(coordinate);
            return true;
        }

        return false;
    }

    private boolean canMoveToCoordinate(Coordinate coordinate)
    {
        return this.getMap().getField(coordinate) == Field.Water;
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

        if (this.getShipDirection() == Direction.North)
        {
            targetY = (this.getShipCoordinate().Y + mapSize - direction) % mapSize;
        }

        if (this.getShipDirection() == Direction.South)
        {
            targetY = (this.getShipCoordinate().Y + mapSize + direction) % mapSize;
        }

        if (this.getShipDirection() == Direction.East)
        {
            targetX = (this.getShipCoordinate().X + mapSize + direction) % mapSize;
        }

        if (this.getShipDirection() == Direction.West)
        {
            targetX = (this.getShipCoordinate().X + mapSize - direction) % mapSize;
        }

        return new Coordinate(targetX, targetY);
    }
}
