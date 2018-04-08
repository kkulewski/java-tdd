package Projekt1.Logic.Stubs;

import Projekt1.Logic.ActionResult;
import Projekt1.Logic.Interfaces.IActionResult;
import Projekt1.Logic.Interfaces.IMoveProcessor;

public class MoveProcessorStub implements IMoveProcessor
{
    @Override
    public IActionResult turnRight()
    {
        return new ActionResult(true);
    }

    @Override
    public IActionResult turnLeft()
    {
        return new ActionResult(true);
    }

    @Override
    public IActionResult moveForward()
    {
        return new ActionResult(true);
    }

    @Override
    public IActionResult moveBack()
    {
        return new ActionResult(true);
    }

    @Override
    public IActionResult shoot()
    {
        return new ActionResult(true);
    }
}
