package Projekt1.Logic;

import static org.assertj.core.api.Assertions.*;

import Projekt1.Logic.Interfaces.IActionResult;
import org.junit.jupiter.api.Test;

public class ActionResultTest
{
    @Test
    public void newActionResult_WithMessage_HasCorrectMessage()
    {
        // Arrange
        String message = "Example message";

        // Act
        IActionResult result = new ActionResult(true, message);

        // Assert
        assertThat(result.getMessage()).contains(message);
    }
}
