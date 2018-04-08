package Projekt1.Logic;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.IMoveProcessor;
import Projekt1.Logic.Interfaces.IActionResult;
import lombok.Getter;

public class MoveProcessor implements IMoveProcessor
{
    @Getter
    private Map map;

    @Getter
    private Ship ship;

    public MoveProcessor(Map map, Ship ship)
    {
        this.map = map;
        this.ship = ship;
    }

    @Override
    public IActionResult turnRight()
    {
        Direction newDirection = Direction.right(ship.getDirection());
        this.ship.setDirection(newDirection);
        return new ActionResult(true, "Turned right.");
    }

    @Override
    public IActionResult turnLeft()
    {
        Direction newDirection = Direction.left(ship.getDirection());
        this.ship.setDirection(newDirection);
        return new ActionResult(true, "Turned left.");
    }

    @Override
    public IActionResult moveForward()
    {
        return moveToCoordinate(getCoordinateAhead());
    }

    @Override
    public IActionResult moveBack()
    {
        return moveToCoordinate(getCoordinateBehind());
    }

    @Override
    public IActionResult shoot()
    {
        Coordinate targetCoordinate = getCoordinateAhead();
        Field targetField = this.map.getField(targetCoordinate);

        if (targetField == Field.Land)
        {
            this.map.setField(targetCoordinate, Field.Water);
            return new ActionResult(true, "Land destroyed.");
        }

        if (targetField == Field.Water)
        {
            return new ActionResult(true, "Shot into the water.");
        }

        return new ActionResult(false, "Cannot shoot there.");
    }

    private IActionResult moveToCoordinate(Coordinate coordinate)
    {
        Field targetField = this.map.getField(coordinate);

        if (targetField == Field.Water)
        {
            this.ship.setCoordinate(coordinate);
            return new ActionResult(true, "Moved.");
        }

        if (targetField == Field.Water)
        {
            return new ActionResult(true, "Shot into the water.");
        }

        return new ActionResult(false, "Cannot move there.");
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
            targetX = (this.ship.getCoordinate().X + mapSize - direction) % mapSize;
        }

        if (this.ship.getDirection() == Direction.South)
        {
            targetX = (this.ship.getCoordinate().X + mapSize + direction) % mapSize;
        }

        if (this.ship.getDirection() == Direction.East)
        {
            targetY = (this.ship.getCoordinate().Y + mapSize + direction) % mapSize;
        }

        if (this.ship.getDirection() == Direction.West)
        {
            targetY = (this.ship.getCoordinate().Y + mapSize - direction) % mapSize;
        }

        return new Coordinate(targetX, targetY);
    }
}
