package Projekt1.Logic;

import Projekt1.Logic.Interfaces.ICommandProcessor;
import Projekt1.Logic.Interfaces.IMoveService;
import Projekt1.Logic.Interfaces.IActionResult;

public class CommandProcessor implements ICommandProcessor
{
    private IMoveService moveService;

    public CommandProcessor(IMoveService moveService)
    {
        this.moveService = moveService;
    }

    @Override
    public IActionResult execute(char symbol)
    {
        IActionResult result;

        char command = Character.toLowerCase(symbol);
        switch (command)
        {
            case 'l':
                result = moveService.turnLeft();
                break;

            case 'r':
                result = moveService.turnRight();
                break;

            case 'n':
                result = moveService.moveForward();
                break;

            case 'w':
                result = moveService.moveBack();
                break;

            case 's':
                result = moveService.shoot();
                break;

            default:
                result = IActionResult.getErrorResult();
                break;
        }

        return result;
    }
}
