package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoordinateTest
{
    @Test
    public void Coordinates_WithSameXAndY_AreEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(5, 0);

        // Act & Assert
        assertThat(coordinate1).isEqualTo(coordinate2);
    }

    @Test
    public void Coordinates_WithDifferentX_AreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(3, 0);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }

    @Test
    public void Coordinates_WithDifferentY_AreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(5, 1);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }

    @Test
    public void Coordinates_WithDifferentXAndY_AreNotEqual()
    {
        // Arrange
        Coordinate coordinate1 = new Coordinate(5, 0);
        Coordinate coordinate2 = new Coordinate(3, 1);

        // Act & Assert
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }
}
