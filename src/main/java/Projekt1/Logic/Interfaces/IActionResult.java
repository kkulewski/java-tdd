package Projekt1.Logic.Interfaces;

public interface IActionResult
{
    public boolean getStatus();
    public String getMessage();

    public static IActionResult getErrorResult()
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
