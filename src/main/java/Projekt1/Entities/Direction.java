package Projekt1.Entities;

import lombok.Getter;

public enum Direction
{
    North(0),
    East(1),
    South(2),
    West(3);

    @Getter
    private int index;

    Direction(int index)
    {
        this.index = index;
    }

    private static Direction[] directions = Direction.values();

    public static Direction right(Direction direction)
    {
        int index = (direction.index + 1) % directions.length;
        return directions[index];
    }

    public static Direction left(Direction direction)
    {
        int index = (direction.index - 1 + directions.length) % directions.length;
        return directions[index];
    }
}
