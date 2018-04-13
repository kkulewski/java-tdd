package Projekt1.Entities;

public class Ship
{
    private Direction direction;

    public Direction getDirection()
    {
        return this.direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }
    private Coordinate coordinate;

    public Coordinate getCoordinate()
    {
        return this.coordinate;
    }

    public void setCoordinate(Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }

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
