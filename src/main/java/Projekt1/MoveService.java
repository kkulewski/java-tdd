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
        return this.move(1);
    }

    public boolean moveBack()
    {
        return this.move(-1);
    }

    private boolean move(int moveDirection)
    {
        int targetX = 0;
        int targetY = 0;
        int mapSize = this.map.getSize();

        if (this.getShipDirection() == Direction.North)
        {
            targetY = (this.getShipCoordinate().Y + mapSize - moveDirection) % mapSize;
        }

        if (this.getShipDirection() == Direction.South)
        {
            targetY = (this.getShipCoordinate().Y + mapSize + moveDirection) % mapSize;
        }

        if (this.getShipDirection() == Direction.East)
        {
            targetX = (this.getShipCoordinate().X + mapSize + moveDirection) % mapSize;
        }

        if (this.getShipDirection() == Direction.West)
        {
            targetX = (this.getShipCoordinate().X + mapSize - moveDirection) % mapSize;
        }

        Coordinate targetCoordinate = new Coordinate(targetX, targetY);
        if (this.getMap().getField(targetCoordinate) == Field.Water)
        {
            this.getShip().setCoordinate(targetCoordinate);
            return true;
        }

        return false;
    }
}
