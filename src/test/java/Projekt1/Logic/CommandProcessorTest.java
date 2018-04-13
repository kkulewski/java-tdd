package Projekt1.Logic;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Projekt1.Logic.Stubs.MoveProcessorStub;
import Projekt1.Logic.Interfaces.IActionResult;
import Projekt1.Logic.Interfaces.ICommandProcessor;
import Projekt1.Logic.Interfaces.IMoveProcessor;
import org.hamcrest.core.Every;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class CommandProcessorTest
{
    IMoveProcessor mp;
    ICommandProcessor cp;

    @BeforeEach
    void setup()
    {
        mp = new MoveProcessorStub();
        cp = new CommandProcessor(mp);
    }

    @Test
    void execute_WithValidCommands_ReturnsTrueResult()
    {
        // Arrange
        List<IActionResult> results = new ArrayList<>();
        Character[] commands = { 'l', 'r', 'n', 'w', 's' };

        // Act
        for (Character c : commands)
        {
            IActionResult result = cp.execute(c);
            results.add(result);
        }

        // Assert
        Assert.assertThat(results, Every.everyItem(hasProperty("status", equalTo(true))));
    }

    @Test
    void execute_WithInvalidCommands_ReturnsFalseResult()
    {
        // Arrange
        List<IActionResult> results = new ArrayList<>();
        Character[] commands = { 'p', '@', 'x', 'q', '7' };

        // Act
        for (Character c : commands)
        {
            IActionResult result = cp.execute(c);
            results.add(result);
        }

        // Assert
        Assert.assertThat(results, Every.everyItem(hasProperty("status", equalTo(false))));
    }

    @ParameterizedTest(name = "{index} => command={0}")
    @ValueSource(chars = {'r', 'l', 's', 'n', 'w'})
    void execute_WithValidCommandFromParams_ReturnsTrueResult(char command)
    {
        // Act
        IActionResult result = cp.execute(command);

        // Assert
        Assert.assertTrue(result.getStatus());
    }

    @ParameterizedTest(name = "{index} => command={0}, result={1}")
    @CsvFileSource(resources = "/commands.csv")
    void execute_WithCommandsFromCsv_ReturnsExpectedResults(char command, boolean result)
    {
        // Act
        IActionResult actionResult = cp.execute(command);

        // Assert
        assertEquals(actionResult.getStatus(), result);
    }
}
