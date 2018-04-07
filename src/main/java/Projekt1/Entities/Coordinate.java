package Projekt1.Entities;

public class Coordinate
{
    public int X;
    public int Y;

    public Coordinate(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public boolean equals(Object obj)
    {
        Coordinate compareTo = (Coordinate)obj;
        return this.X == compareTo.X && this.Y == compareTo.Y;
    }
}
