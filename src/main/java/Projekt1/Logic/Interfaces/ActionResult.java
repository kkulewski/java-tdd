package Projekt1.Logic.Interfaces;

public interface ActionResult
{
    boolean getStatus();
    String getMessage();

    static ActionResult getErrorResult()
    {
        return new ActionResult()
        {
            @Override
            public boolean getStatus()
            {
                return false;
            }

            @Override
            public String getMessage()
            {
                return "Error!";
            }
        };
    }
}
