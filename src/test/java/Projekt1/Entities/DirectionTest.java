package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DirectionTest
{
    @Test
    public void Right_GivenNorth_ReturnsEast()
    {
        // Arrange
        Direction start = Direction.North;

        // Act
        Direction result = Direction.Right(start);

        // Assert
        assertThat(result).isEqualTo(Direction.East);
    }

    @Test
    public void Right_GivenWest_ReturnsNorth()
    {
        // Arrange
        Direction start = Direction.West;

        // Act
        Direction result = Direction.Right(start);

        // Assert
        assertThat(result).isEqualTo(Direction.North);
    }

    @Test
    public void Right_GivenEast_CalledTwoTimes_ReturnsWest()
    {
        // Arrange
        Direction start = Direction.East;

        // Act
        Direction result = Direction.Right(Direction.Right(start));

        // Assert
        assertThat(result).isEqualTo(Direction.West);
    }
}
