package Projekt1.Entities;

import lombok.Getter;

public enum Field
{
    Water(' '),
    Land('#');

    @Getter
    private char symbol;

    Field(char symbol)
    {
        this.symbol = symbol;
    }
}
