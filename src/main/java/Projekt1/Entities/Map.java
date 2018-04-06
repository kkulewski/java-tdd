package Projekt1.Entities;

public class Map
{
    private Field[][] fields;

    public Map(int size)
    {
        this.fields = createEmptyMap(size);
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
