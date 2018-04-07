package Projekt1.Logic.Interfaces;

import Projekt1.Logic.Messages.IActionResult;

public interface ICommandProcessor
{
    public IActionResult Execute(char commandSymbol);
}
