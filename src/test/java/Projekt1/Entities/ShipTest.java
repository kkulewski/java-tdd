package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ShipTest
{
    @Test
    public void newShip_FacesNorthDirection_ByDefault()
    {
        // Arrange
        Ship ship = new Ship();

        // Act

        // Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.North);
    }

    @Test
    public void newShip_XCoordinate_Is0()
    {
        // Arrange
        Ship ship = new Ship();

        // Act & Assert
        assertThat(ship.getX()).isEqualTo(0);
    }

    @Test
    public void newShip_YCoordinate_Is0()
    {
        // Arrange
        Ship ship = new Ship();

        // Act & Assert
        assertThat(ship.getY()).isEqualTo(0);
    }

    @Test
    public void newShip_WithCustomDirectionSouth_FacesSouth()
    {
        // Arrange
        Ship ship = new Ship(Direction.South, 0, 0);

        // Act & Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.South);
    }

    @Test
    public void newShip_WithCustomX5_XCoordinate_Is5()
    {
        // Arrange
        Ship ship = new Ship(Direction.North, 5, 0);

        // Act & Assert
        assertThat(ship.getX()).isEqualTo(5);
    }

    @Test
    public void newShip_WithCustomY5_YCoordinate_Is5()
    {
        // Arrange
        Ship ship = new Ship(Direction.North, 0, 5);

        // Act & Assert
        assertThat(ship.getY()).isEqualTo(5);
    }
}
