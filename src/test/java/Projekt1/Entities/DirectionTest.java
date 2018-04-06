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
}
