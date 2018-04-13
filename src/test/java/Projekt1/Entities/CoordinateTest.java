package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CoordinateTest
{
    @Test
    void CoordinatesWithSameXAndYAreEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(5, 0);

        // Act & Assert
        assertThat(coordinate1).isEqualTo(coordinate2);
    }

    @Test
    void CoordinatesWithDifferentXAreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(3, 0);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }

    @Test
    void CoordinatesWithDifferentYAreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(5, 1);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }

    @Test
    void CoordinatesWithDifferentXAndYAreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(3, 1);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }
}
