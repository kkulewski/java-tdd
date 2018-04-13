package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DirectionTest
{
    @Test
    void rightGivenNorthReturnsEast()
    {
        // Arrange
        Direction start = Direction.North;

        // Act
        Direction result = Direction.right(start);

        // Assert
        assertThat(result).isEqualTo(Direction.East);
    }

    @Test
    void rightGivenWestReturnsNorth()
    {
        // Arrange
        Direction start = Direction.West;

        // Act
        Direction result = Direction.right(start);

        // Assert
        assertThat(result).isEqualTo(Direction.North);
    }

    @Test
    void rightGivenEastCalledTwoTimesReturnsWest()
    {
        // Arrange
        Direction start = Direction.East;

        // Act
        Direction result = Direction.right(Direction.right(start));

        // Assert
        assertThat(result).isEqualTo(Direction.West);
    }

    @Test
    void leftGivenNorthReturnsWest()
    {
        // Arrange
        Direction start = Direction.North;

        // Act
        Direction result = Direction.left(start);

        // Assert
        assertThat(result).isEqualTo(Direction.West);
    }

    @Test
    void leftGivenWestReturnsSouth()
    {
        // Arrange
        Direction start = Direction.West;

        // Act
        Direction result = Direction.left(start);

        // Assert
        assertThat(result).isEqualTo(Direction.South);
    }

    @Test
    void leftGivenNorthAfterFullCycleReturnsNorth()
    {
        // Arrange
        Direction result = Direction.North;

        // Act
        for (int i = 0; i < Direction.values().length; i++)
        {
            result = Direction.left(result);
        }

        // Assert
        assertThat(result).isEqualTo(Direction.North);
    }
}
