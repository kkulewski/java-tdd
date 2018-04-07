package Projekt1.Entities;

public class Map
{
    private Field[][] fields;
    private int size;

    public Map(int size)
    {
        this.size = size;
        createEmptyMap();
    }

    public Field getField(int row, int column)
    {
        return fields[row][column];
    }

    private void createEmptyMap()
    {
        this.fields = new Field[this.size][this.size];
        for (int i = 0; i < this.size; i++)
        {
            for (int j = 0; j < this.size; j++)
            {
                this.fields[i][j] = Field.Water;
            }
        }
    }
}
