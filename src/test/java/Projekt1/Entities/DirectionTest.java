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
}
