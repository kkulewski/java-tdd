package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DirectionTest
{
    @Test
    public void right_GivenNorth_ReturnsEast()
    {
        // Arrange
        Direction start = Direction.North;

        // Act
        Direction result = Direction.right(start);

        // Assert
        assertThat(result).isEqualTo(Direction.East);
    }

    @Test
    public void right_GivenWest_ReturnsNorth()
    {
        // Arrange
        Direction start = Direction.West;

        // Act
        Direction result = Direction.right(start);

        // Assert
        assertThat(result).isEqualTo(Direction.North);
    }

    @Test
    public void right_GivenEast_CalledTwoTimes_ReturnsWest()
    {
        // Arrange
        Direction start = Direction.East;

        // Act
        Direction result = Direction.right(Direction.right(start));

        // Assert
        assertThat(result).isEqualTo(Direction.West);
    }

    @Test
    public void left_GivenNorth_ReturnsWest()
    {
        // Arrange
        Direction start = Direction.North;

        // Act
        Direction result = Direction.left(start);

        // Assert
        assertThat(result).isEqualTo(Direction.West);
    }

    @Test
    public void left_GivenWest_ReturnsSouth()
    {
        // Arrange
        Direction start = Direction.West;

        // Act
        Direction result = Direction.left(start);

        // Assert
        assertThat(result).isEqualTo(Direction.South);
    }

    @Test
    public void left_GivenNorth_AfterFullCycle_ReturnsNorth()
    {
        // Arrange
        Direction start = Direction.North;

        // Act
        Direction result = start;
        for (int i = 0; i < Direction.values().length; i++)
        {
            result = Direction.left(result);
        }

        // Assert
        assertThat(result).isEqualTo(Direction.North);
    }
}
