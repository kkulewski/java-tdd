package Projekt1.Logic;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Projekt1.Logic.Stubs.MoveProcessorStub;
import Projekt1.Logic.Interfaces.ActionResult;
import Projekt1.Logic.Interfaces.CommandProcessor;
import Projekt1.Logic.Interfaces.MoveProcessor;
import org.hamcrest.core.Every;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class TextCommandProcessorTest
{
    private CommandProcessor cp;

    @BeforeEach
    void setup()
    {
        MoveProcessor mp = new MoveProcessorStub();
        cp = new TextCommandProcessor(mp);
    }

    @Test
    void executeWithValidCommandsReturnsTrueResult()
    {
        // Arrange
        List<ActionResult> results = new ArrayList<>();
        Character[] commands = { 'l', 'r', 'n', 'w', 's' };

        // Act
        for (Character c : commands)
        {
            ActionResult result = cp.execute(c);
            results.add(result);
        }

        // Assert
        Assert.assertThat(results, Every.everyItem(hasProperty("status", equalTo(true))));
    }

    @Test
    void executeWithInvalidCommandsReturnsFalseResult()
    {
        // Arrange
        List<ActionResult> results = new ArrayList<>();
        Character[] commands = { 'p', '@', 'x', 'q', '7' };

        // Act
        for (Character c : commands)
        {
            ActionResult result = cp.execute(c);
            results.add(result);
        }

        // Assert
        Assert.assertThat(results, Every.everyItem(hasProperty("status", equalTo(false))));
    }

    @ParameterizedTest(name = "{index} => command={0}")
    @ValueSource(chars = {'r', 'l', 's', 'n', 'w'})
    void executeWithValidCommandFromParamsReturnsTrueResult(char command)
    {
        // Act
        ActionResult result = cp.execute(command);

        // Assert
        Assert.assertTrue(result.getStatus());
    }

    @ParameterizedTest(name = "{index} => command={0}, result={1}")
    @CsvFileSource(resources = "/commands.csv")
    void executeWithCommandsFromCsvReturnsExpectedResults(char command, boolean result)
    {
        // Act
        ActionResult actionResult = cp.execute(command);

        // Assert
        assertEquals(actionResult.getStatus(), result);
    }
}
