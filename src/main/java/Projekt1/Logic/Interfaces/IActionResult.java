package Projekt1.Logic.Interfaces;

public interface IActionResult
{
    boolean getStatus();
    String getMessage();

    static IActionResult getErrorResult()
    {
        return new IActionResult()
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
