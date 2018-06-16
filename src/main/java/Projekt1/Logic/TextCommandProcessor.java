package Projekt1.Logic;

import Projekt1.Logic.Interfaces.CommandProcessor;
import Projekt1.Logic.Interfaces.IMoveProcessor;
import Projekt1.Logic.Interfaces.IActionResult;

public class TextCommandProcessor implements CommandProcessor
{
    private IMoveProcessor moveProcessor;

    public TextCommandProcessor(IMoveProcessor moveProcessor)
    {
        this.moveProcessor = moveProcessor;
    }

    @Override
    public IActionResult execute(char symbol)
    {
        IActionResult result;

        char command = Character.toLowerCase(symbol);
        switch (command)
        {
            case 'l':
                result = moveProcessor.turnLeft();
                break;

            case 'r':
                result = moveProcessor.turnRight();
                break;

            case 'n':
                result = moveProcessor.moveForward();
                break;

            case 'w':
                result = moveProcessor.moveBack();
                break;

            case 's':
                result = moveProcessor.shoot();
                break;

            default:
                result = IActionResult.getErrorResult();
                break;
        }

        return result;
    }
}
