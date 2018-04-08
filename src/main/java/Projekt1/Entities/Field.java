package Projekt1.Entities;

import lombok.Getter;

public enum Field
{
    Water(' '),
    Land('O');

    @Getter
    private char symbol;

    Field(char symbol)
    {
        this.symbol = symbol;
    }
}
