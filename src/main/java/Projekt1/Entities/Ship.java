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
        this.direction = Direction.North;
        this.x = 0;
        this.y = 0;
    }
}
