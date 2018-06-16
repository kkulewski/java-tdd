package Projekt1.Logic;

import Projekt1.Logic.Interfaces.CommandProcessor;
import Projekt1.Logic.Interfaces.MoveProcessor;
import Projekt1.Logic.Interfaces.ActionResult;

public class TextCommandProcessor implements CommandProcessor
{
    private MoveProcessor moveProcessor;

    public TextCommandProcessor(MoveProcessor moveProcessor)
    {
        this.moveProcessor = moveProcessor;
    }

    @Override
    public ActionResult execute(char symbol)
    {
        ActionResult result;

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
                result = ActionResult.getErrorResult();
                break;
        }

        return result;
    }
}
