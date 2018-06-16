package Projekt1.Logic.Stubs;

import Projekt1.Logic.TextActionResult;
import Projekt1.Logic.Interfaces.ActionResult;
import Projekt1.Logic.Interfaces.MoveProcessor;

public class MoveProcessorStub implements MoveProcessor
{
    @Override
    public ActionResult turnRight()
    {
        return new TextActionResult(true);
    }

    @Override
    public ActionResult turnLeft()
    {
        return new TextActionResult(true);
    }

    @Override
    public ActionResult moveForward()
    {
        return new TextActionResult(true);
    }

    @Override
    public ActionResult moveBack()
    {
        return new TextActionResult(true);
    }

    @Override
    public ActionResult shoot()
    {
        return new TextActionResult(true);
    }
}
