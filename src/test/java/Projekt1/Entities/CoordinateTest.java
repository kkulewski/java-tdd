package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CoordinateTest
{
    @Test
    void coordinatesWithSameXAndYAreEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(5, 0);

        // Act & Assert
        assertThat(coordinate1).isEqualTo(coordinate2);
    }

    @Test
    void coordinatesWithDifferentXAreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(3, 0);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }

    @Test
    void coordinatesWithDifferentYAreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(5, 1);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }

    @Test
    void coordinatesWithDifferentXAndYAreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(3, 1);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }
}
