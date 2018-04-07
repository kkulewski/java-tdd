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
    private int x;

    @Getter
    @Setter
    private int y;

    public Ship()
    {
        this.setDirection(Direction.North);
        this.setX(0);
        this.setY(0);
    }

    public Ship(Direction direction, int x, int y)
    {
        this.setDirection(direction);
        this.setY(y);
        this.setX(x);
    }
}
