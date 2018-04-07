package Projekt1;

import Projekt1.Entities.Direction;
import Projekt1.Entities.Field;
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

    public int getShipY()
    {
        return this.getShip().getY();
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

    private boolean move(int moveDirection)
    {
        int targetX = 0;
        int targetY = 0;
        int mapSize = this.map.getSize();

        if (this.getShipDirection() == Direction.North)
        {
            targetY = (this.getShipY() + mapSize - moveDirection) % mapSize;
        }

        if (this.getShipDirection() == Direction.South)
        {
            targetY = (this.getShipY() + mapSize + moveDirection) % mapSize;
        }

        if (this.getShipDirection() == Direction.East)
        {
            targetX = (this.getShipX() + mapSize + moveDirection) % mapSize;
        }

        if (this.getShipDirection() == Direction.West)
        {
            targetX = (this.getShipX() + mapSize - moveDirection) % mapSize;
        }

        if (this.getMap().getField(targetX, targetY) == Field.Water)
        {
            this.getShip().setX(targetX);
            this.getShip().setY(targetY);
            return true;
        }

        return false;
    }
}
