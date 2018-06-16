package Projekt1.Logic;

import Projekt1.Logic.Interfaces.ActionResult;

public class TextActionResult implements ActionResult
{
    private boolean status;
    private String message;

    public TextActionResult(boolean status)
    {
        this.status = status;
        this.message = "";
    }

    public TextActionResult(boolean status, String message)
    {
        this(status);
        this.message = message;
    }

    @Override
    public boolean getStatus()
    {
        return this.status;
    }

    @Override
    public String getMessage()
    {
        return this.message;
    }
}
