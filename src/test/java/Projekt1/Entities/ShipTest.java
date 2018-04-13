package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ShipTest
{
    @Test
    void newShipFacesNorthDirectionByDefault()
    {
        // Arrange
        Ship ship = new Ship();

        // Act

        // Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.North);
    }

    @Test
    void newShipXCoordinateIs0()
    {
        // Arrange
        Ship ship = new Ship();

        // Act & Assert
        assertThat(ship.getCoordinate().X).isEqualTo(0);
    }

    @Test
    void newShipYCoordinateIs0()
    {
        // Arrange
        Ship ship = new Ship();

        // Act & Assert
        assertThat(ship.getCoordinate().Y).isEqualTo(0);
    }

    @Test
    void newShipWithCustomDirectionSouthFacesSouth()
    {
        // Arrange
        Coordinate coordinate = new Coordinate(0, 0);
        Ship ship = new Ship(Direction.South, coordinate);

        // Act & Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.South);
    }

    @Test
    void newShipWithCustomX5XCoordinateIs5()
    {
        // Arrange
        Coordinate coordinate = new Coordinate(5, 0);
        Ship ship = new Ship(Direction.North, coordinate);

        // Act & Assert
        assertThat(ship.getCoordinate().X).isEqualTo(5);
    }

    @Test
    void newShipWithCustomY5YCoordinateIs5()
    {
        // Arrange
        Coordinate coordinate = new Coordinate(0, 5);
        Ship ship = new Ship(Direction.North, coordinate);

        // Act & Assert
        assertThat(ship.getCoordinate().Y).isEqualTo(5);
    }
}
