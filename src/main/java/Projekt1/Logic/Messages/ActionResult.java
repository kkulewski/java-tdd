package Projekt1.Logic.Messages;

public class ActionResult implements IActionResult
{
    private boolean status;
    private String message;

    public ActionResult(boolean status)
    {
        this.status = status;
        this.message = "";
    }

    public ActionResult(boolean status, String message)
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
