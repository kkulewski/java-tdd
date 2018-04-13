package Projekt1.Entities;

public enum Field
{
    Water(' '),
    Land('O');

    private char symbol;

    public char getSymbol()
    {
        return this.symbol;
    }

    Field(char symbol)
    {
        this.symbol = symbol;
    }
}
