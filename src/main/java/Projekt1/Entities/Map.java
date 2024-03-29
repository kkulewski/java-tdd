package Projekt1.Entities;

import java.util.Random;

public class Map
{
    private Field[][] fields;
    private int size;

    public int getSize()
    {
        return this.size;
    }

    public Map(int size)
    {
        this.size = size;
        this.fields = new Field[size][size];

        fillWithWater();
    }

    public Map(int size, boolean withLand)
    {
        this(size);
        if (withLand)
        {
            addIslands();
        }
    }

    public Map(Field[][] fields)
    {
        this.size = fields.length;
        this.fields = fields;
    }

    public Field getField(Coordinate coordinate)
    {
        return fields[coordinate.X][coordinate.Y];
    }

    public void setField(Coordinate coordinate, Field value)
    {
        this.fields[coordinate.X][coordinate.Y] = value;
    }

    private void fillWithWater()
    {
        for (int x = 0; x < this.size; x++)
        {
            for (int y = 0; y < this.size; y++)
            {
                this.fields[x][y] = Field.Water;
            }
        }
    }

    private void addIslands()
    {
        Random random = new Random();
        int islandsAdded = 0;
        int islandsToAdd = (this.size * this.size) / 10;

        while (islandsAdded < islandsToAdd)
        {
            int x = random.nextInt(this.size);
            int y = random.nextInt(this.size);

            if (x == 0 && y == 0)
            {
                continue;
            }

            if (this.fields[x][y] != Field.Land)
            {
                this.fields[x][y] = Field.Land;
                islandsAdded++;
            }
        }
    }
}
