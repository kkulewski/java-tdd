package Projekt1.Logic;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.MoveProcessor;
import Projekt1.Logic.Interfaces.ActionResult;

public class TextMoveProcessor implements MoveProcessor
{
    private Map map;

    public Map getMap()
    {
        return map;
    }

    private Ship ship;

    public Ship getShip()
    {
        return ship;
    }

    public TextMoveProcessor(Map map, Ship ship)
    {
        this.map = map;
        this.ship = ship;
    }

    @Override
    public ActionResult turnRight()
    {
        Direction newDirection = Direction.right(ship.getDirection());
        this.ship.setDirection(newDirection);
        return new TextActionResult(true, "Turned right.");
    }

    @Override
    public ActionResult turnLeft()
    {
        Direction newDirection = Direction.left(ship.getDirection());
        this.ship.setDirection(newDirection);
        return new TextActionResult(true, "Turned left.");
    }

    @Override
    public ActionResult moveForward()
    {
        return moveToCoordinate(getCoordinateAhead());
    }

    @Override
    public ActionResult moveBack()
    {
        return moveToCoordinate(getCoordinateBehind());
    }

    @Override
    public ActionResult shoot()
    {
        Coordinate targetCoordinate = getCoordinateAhead();
        Field targetField = this.map.getField(targetCoordinate);

        if (targetField == Field.Land)
        {
            this.map.setField(targetCoordinate, Field.Water);
            return new TextActionResult(true, "Land destroyed.");
        }

        if (targetField == Field.Water)
        {
            return new TextActionResult(true, "Shot into the water.");
        }

        return new TextActionResult(false, "Cannot shoot there.");
    }

    private ActionResult moveToCoordinate(Coordinate coordinate)
    {
        Field targetField = this.map.getField(coordinate);

        if (targetField == Field.Water)
        {
            this.ship.setCoordinate(coordinate);
            return new TextActionResult(true, "Moved.");
        }

        return new TextActionResult(false, "Cannot move there.");
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
        int targetX = this.ship.getCoordinate().X;
        int targetY = this.ship.getCoordinate().Y;
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
