package Projekt1.Entities;

public enum Direction
{
    North(0, 'N'),
    East(1, 'E'),
    South(2, 'S'),
    West(3, 'W');

    private int index;
    private char symbol;

    public char getSymbol()
    {
        return this.symbol;
    }

    Direction(int index, char symbol)
    {
        this.symbol = symbol;
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
