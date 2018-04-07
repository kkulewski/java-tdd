package Projekt1.Entities;

import java.util.Random;

public class Map
{
    private Field[][] fields;
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

    public Field getField(int row, int column)
    {
        return fields[row][column];
    }

    private void fillWithWater()
    {
        for (int i = 0; i < this.size; i++)
        {
            for (int j = 0; j < this.size; j++)
            {
                this.fields[i][j] = Field.Water;
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
            int row = random.nextInt(this.size);
            int col = random.nextInt(this.size);

            if (this.fields[row][col] != Field.Land)
            {
                this.fields[row][col] = Field.Land;
                islandsAdded++;
            }
        }
    }
}
