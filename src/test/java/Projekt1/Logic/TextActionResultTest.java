package Projekt1.Logic;

import static org.assertj.core.api.Assertions.*;

import Projekt1.Logic.Interfaces.ActionResult;
import org.junit.jupiter.api.Test;

class TextActionResultTest
{
    @Test
    void newActionResultWithMessageHasCorrectMessage()
    {
        // Arrange
        String message = "Example message";

        // Act
        ActionResult result = new TextActionResult(true, message);

        // Assert
        assertThat(result.getMessage()).contains(message);
    }

    @Test
    void defaultErrorActionResultContainsErrorMessage()
    {
        // Act
        ActionResult result = ActionResult.getErrorResult();

        // Assert
        assertThat(result.getMessage()).contains("Error");
    }
}
