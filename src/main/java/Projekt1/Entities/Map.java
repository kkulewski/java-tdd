package Projekt1.Entities;

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
}
