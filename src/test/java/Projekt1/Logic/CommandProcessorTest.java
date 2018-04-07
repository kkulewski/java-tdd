package Projekt1.Logic;

import static org.hamcrest.Matchers.*;

import Projekt1.Logic.Stubs.MoveServiceStub;
import Projekt1.Logic.Interfaces.IActionResult;
import Projekt1.Logic.Interfaces.ICommandProcessor;
import Projekt1.Logic.Interfaces.IMoveService;
import org.hamcrest.core.Every;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessorTest
{
    @Test
    public void execute_WithValidCommands_ReturnsTrueResult()
    {
        // Arrange
        IMoveService ms = new MoveServiceStub();
        ICommandProcessor cp = new CommandProcessor(ms);
        List<IActionResult> results = new ArrayList<>();
        Character[] validCommands = { 'l', 'r', 'n', 'w', 's' };

        // Act
        for (Character c : validCommands)
        {
            IActionResult result = cp.execute(c);
            results.add(result);
        }

        // Assert
        Assert.assertThat(results, Every.everyItem(hasProperty("status", equalTo(true))));
    }
}
