package Projekt1;

import static org.assertj.core.api.Assertions.*;
import Projekt1.Entities.Direction;
import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;
import org.junit.jupiter.api.Test;

public class MoveServiceTest
{
    @Test
    public void getShipDirection_ReturnsShipDirection()
    {
        // Arrange
        Map map = new Map(0);
        Ship ship = new Ship(Direction.North, 0, 0);
        MoveService ms = new MoveService(map, ship);

        // Assert
        assertThat(ms.getShipDirection()).isEqualTo(Direction.North);
    }

    @Test
    public void getShipX_ReturnsShipX()
    {
        // Arrange
        Map map = new Map(0);
        int shipX = 3;
        Ship ship = new Ship(Direction.North, shipX, 0);
        MoveService ms = new MoveService(map, ship);

        // Assert
        assertThat(ms.getShipX()).isEqualTo(shipX);
    }

    @Test
    public void getShipY_ReturnsShipY()
    {
        // Arrange
        Map map = new Map(0);
        int shipY = 3;
        Ship ship = new Ship(Direction.North, 0, shipY);
        MoveService ms = new MoveService(map, ship);

        // Assert
        assertThat(ms.getShipY()).isEqualTo(shipY);
    }

    @Test
    public void turnRight_WithShipFacingNorth_MakesItFaceEast()
    {
        // Arrange
        Map map = new Map(0);
        Ship ship = new Ship(Direction.North, 0, 0);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.turnRight();

        // Assert
        assertThat(ms.getShipDirection()).isEqualTo(Direction.East);
    }

    @Test
    public void turnLeft_WithShipFacingNorth_MakesItFaceWest()
    {
        // Arrange
        Map map = new Map(0);
        Ship ship = new Ship(Direction.North, 0, 0);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.turnLeft();

        // Assert
        assertThat(ms.getShipDirection()).isEqualTo(Direction.West);
    }
}
