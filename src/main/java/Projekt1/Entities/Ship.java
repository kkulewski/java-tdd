package Projekt1.Entities;

import lombok.Getter;
import lombok.Setter;

public class Ship
{
    @Getter
    @Setter
    private Direction direction;

    public Ship()
    {
        direction = Direction.North;
    }
}
