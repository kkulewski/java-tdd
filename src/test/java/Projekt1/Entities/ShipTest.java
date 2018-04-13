package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ShipTest
{
    @Test
    void newShip_FacesNorthDirection_ByDefault()
    {
        // Arrange
        Ship ship = new Ship();

        // Act

        // Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.North);
    }

    @Test
    void newShip_XCoordinate_Is0()
    {
        // Arrange
        Ship ship = new Ship();

        // Act & Assert
        assertThat(ship.getCoordinate().X).isEqualTo(0);
    }

    @Test
    void newShip_YCoordinate_Is0()
    {
        // Arrange
        Ship ship = new Ship();

        // Act & Assert
        assertThat(ship.getCoordinate().Y).isEqualTo(0);
    }

    @Test
    void newShip_WithCustomDirectionSouth_FacesSouth()
    {
        // Arrange
        Coordinate coordinate = new Coordinate(0, 0);
        Ship ship = new Ship(Direction.South, coordinate);

        // Act & Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.South);
    }

    @Test
    void newShip_WithCustomX5_XCoordinate_Is5()
    {
        // Arrange
        Coordinate coordinate = new Coordinate(5, 0);
        Ship ship = new Ship(Direction.North, coordinate);

        // Act & Assert
        assertThat(ship.getCoordinate().X).isEqualTo(5);
    }

    @Test
    void newShip_WithCustomY5_YCoordinate_Is5()
    {
        // Arrange
        Coordinate coordinate = new Coordinate(0, 5);
        Ship ship = new Ship(Direction.North, coordinate);

        // Act & Assert
        assertThat(ship.getCoordinate().Y).isEqualTo(5);
    }
}
