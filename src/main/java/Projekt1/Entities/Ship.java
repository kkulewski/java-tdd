package Projekt1.Entities;

import lombok.Getter;
import lombok.Setter;

public class Ship
{
    @Getter
    @Setter
    private Direction direction;

    @Getter
    @Setter
    private Coordinate coordinate;

    public Ship()
    {
        this.setDirection(Direction.North);
        this.setCoordinate(new Coordinate(0, 0));
    }

    public Ship(Direction direction)
    {
        this();
        this.setDirection(direction);
    }

    public Ship(Direction direction, Coordinate coordinate)
    {
        this();
        this.setDirection(direction);
        this.setCoordinate(coordinate);
    }
}
