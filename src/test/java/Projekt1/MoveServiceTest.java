package Projekt1;

import static org.assertj.core.api.Assertions.*;

import Projekt1.Entities.*;
import org.junit.jupiter.api.Test;

public class MoveServiceTest
{
    @Test
    public void turnRight_WithShipFacingNorth_MakesItFaceEast()
    {
        // Arrange
        Map map = new Map(0);
        Ship ship = new Ship(Direction.North);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.turnRight();

        // Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.East);
    }

    @Test
    public void turnLeft_WithShipFacingNorth_MakesItFaceWest()
    {
        // Arrange
        Map map = new Map(0);
        Ship ship = new Ship(Direction.North);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.turnLeft();

        // Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.West);
    }

    @Test
    public void moveForward_WithoutMapBoundCrossing_And_WithWaterInTargetField_ReturnsTrue()
    {
        // Arrange
        Map map = new Map(2);
        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        boolean result = ms.moveForward();

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    public void moveForward_WhenFacingEast_CorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(2);
        Coordinate initial = new Coordinate(0, 0);
        Ship ship = new Ship(Direction.East, initial);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.moveForward();

        // Assert
        Coordinate expected = new Coordinate(1, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    public void moveForward_WithHorizontalMapBoundCross_CorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate initial = new Coordinate(0, 0);
        Ship ship = new Ship(Direction.West, initial);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.moveForward();

        // Assert
        Coordinate expected = new Coordinate(2, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    public void moveForward_WithVerticalMapBoundCross_CorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate initial = new Coordinate(0, 2);
        Ship ship = new Ship(Direction.South, initial);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.moveForward();

        // Assert
        Coordinate expected = new Coordinate(0, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    public void moveForward_WithLandInTargetField_ReturnsFalse()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(1, 0);
        map.setField(landCoordinate, Field.Land);
        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        boolean result = ms.moveForward();

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    public void moveForward_WithLandInTargetField_DoesNotMoveShip()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(1, 0);
        map.setField(landCoordinate, Field.Land);
        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.moveForward();

        // Assert
        Coordinate expected = new Coordinate(0, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    public void moveForward_SucceedsUntilTargetFieldIsLand()
    {
        // Arrange
        Map map = new Map(4);
        Coordinate landCoordinate = new Coordinate(3, 0);
        map.setField(landCoordinate, Field.Land);
        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.moveForward(); // 0 -> 1
        ms.moveForward(); // 1 -> 2
        ms.moveForward(); // stop - land
        ms.moveForward(); // stop - land

        // Assert
        Coordinate expected = new Coordinate(2, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    public void moveBack_WithHorizontalMapBoundCross_CorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(5);
        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.moveBack();

        // Assert
        Coordinate expected = new Coordinate(4, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    public void shoot_WithWaterAhead_ReturnsFalse()
    {
        // Arrange
        Map map = new Map(3);
        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        boolean result = ms.shoot();

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    public void shoot_WithWaterAhead_DoesNotChangeFieldType()
    {
        // Arrange
        Map map = new Map(3);
        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.shoot();

        // Assert
        Field fieldAhead = map.getField(new Coordinate(1, 0));
        assertThat(fieldAhead).isEqualTo(Field.Water);
    }

    @Test
    public void shoot_WithLandAhead_ReturnsTrue()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(1, 0);
        map.setField(landCoordinate, Field.Land);

        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        boolean result = ms.shoot();

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    public void shoot_WithLandAhead_ChangesLandIntoWater()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(1, 0);
        map.setField(landCoordinate, Field.Land);

        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.shoot();

        // Assert
        Field fieldAfterShoot = map.getField(landCoordinate);
        assertThat(fieldAfterShoot).isEqualTo(Field.Water);
    }

    @Test
    public void moveForward_WithLandAhead_AfterShoot_CanBeContinued()
    {
        // Arrange
        Map map = new Map(4);
        Coordinate landCoordinate = new Coordinate(2, 0);
        map.setField(landCoordinate, Field.Land);

        Ship ship = new Ship(Direction.East);
        MoveService ms = new MoveService(map, ship);

        // Act
        ms.moveForward(); // 0 -> 1
        ms.shoot(); // shoot land at 2
        ms.moveForward(); // 1 -> 2
        ms.moveForward(); // 2 -> 3

        // Assert
        Coordinate expected = new Coordinate(3, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }
}
