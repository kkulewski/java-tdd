package Projekt1.Entities;

public class Map
{
    private Field[][] fields;

    public Map(int size)
    {
        this.fields = createEmptyMap(size);
    }

    public Field getField(int row, int column)
    {
        return fields[row][column];
    }

    private Field[][] createEmptyMap(int size)
    {
        Field[][] fields = new Field[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                fields[i][j] = Field.Water;
            }
        }

        return fields;
    }
}
