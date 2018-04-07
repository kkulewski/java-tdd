package Projekt1.Entities;

import lombok.Getter;

import java.util.Random;

public class Map
{
    private Field[][] fields;

    @Getter
    private int size;

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

    public Field getField(int x, int y)
    {
        return fields[x][y];
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

            if (this.fields[x][y] != Field.Land)
            {
                this.fields[x][y] = Field.Land;
                islandsAdded++;
            }
        }
    }
}
