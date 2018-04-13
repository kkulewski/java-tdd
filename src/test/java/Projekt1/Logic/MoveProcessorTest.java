package Projekt1.Logic;

import static org.assertj.core.api.Assertions.*;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.IMoveProcessor;
import Projekt1.Logic.Interfaces.IActionResult;
import org.junit.jupiter.api.Test;

class MoveProcessorTest
{
    @Test
    void turnRightWithShipFacingNorthMakesItFaceEast()
    {
        // Arrange
        Map map = new Map(0);
        Ship ship = new Ship(Direction.North);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.turnRight();

        // Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.East);
    }

    @Test
    void turnLeftWithShipFacingNorthMakesItFaceWest()
    {
        // Arrange
        Map map = new Map(0);
        Ship ship = new Ship(Direction.North);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.turnLeft();

        // Assert
        assertThat(ship.getDirection()).isEqualTo(Direction.West);
    }

    @Test
    void moveForwardWithoutMapBoundCrossingAndWithWaterInTargetFieldReturnsTrue()
    {
        // Arrange
        Map map = new Map(2);
        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        IActionResult result = mp.moveForward();

        // Assert
        assertThat(result.getStatus()).isTrue();
    }

    @Test
    void moveForwardWhenFacingEastCorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(2);
        Coordinate initial = new Coordinate(0, 0);
        Ship ship = new Ship(Direction.East, initial);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.moveForward();

        // Assert
        Coordinate expected = new Coordinate(0, 1);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    void moveForwardWithHorizontalMapBoundCrossCorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate initial = new Coordinate(0, 0);
        Ship ship = new Ship(Direction.West, initial);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.moveForward();

        // Assert
        Coordinate expected = new Coordinate(0, 2);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    void moveForwardWithVerticalMapBoundCrossCorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate initial = new Coordinate(2, 0);
        Ship ship = new Ship(Direction.South, initial);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.moveForward();

        // Assert
        Coordinate expected = new Coordinate(0, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    void moveForwardWithLandInTargetFieldReturnsFalse()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(0, 1);
        map.setField(landCoordinate, Field.Land);
        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        IActionResult result = mp.moveForward();

        // Assert
        assertThat(result.getStatus()).isFalse();
    }

    @Test
    void moveForwardWithLandInTargetFieldDoesNotMoveShip()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(0, 1);
        map.setField(landCoordinate, Field.Land);
        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.moveForward();

        // Assert
        Coordinate expected = new Coordinate(0, 0);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    void moveForwardSucceedsUntilTargetFieldIsLand()
    {
        // Arrange
        Map map = new Map(4);
        Coordinate landCoordinate = new Coordinate(0, 3);
        map.setField(landCoordinate, Field.Land);
        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.moveForward(); // 0 -> 1
        mp.moveForward(); // 1 -> 2
        mp.moveForward(); // stop - land
        mp.moveForward(); // stop - land

        // Assert
        Coordinate expected = new Coordinate(0, 2);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    void moveBackWithHorizontalMapBoundCrossCorrectlyChangesShipCoordinates()
    {
        // Arrange
        Map map = new Map(5);
        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.moveBack();

        // Assert
        Coordinate expected = new Coordinate(0, 4);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }

    @Test
    void shootWithWaterAheadReturnsTrue()
    {
        // Arrange
        Map map = new Map(3);
        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        IActionResult result = mp.shoot();

        // Assert
        assertThat(result.getStatus()).isTrue();
    }

    @Test
    void shootWithWaterAheadDoesNotChangeFieldType()
    {
        // Arrange
        Map map = new Map(3);
        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.shoot();

        // Assert
        Field fieldAhead = map.getField(new Coordinate(0, 1));
        assertThat(fieldAhead).isEqualTo(Field.Water);
    }

    @Test
    void shootWithLandAheadReturnsTrue()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(1, 0);
        map.setField(landCoordinate, Field.Land);

        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        IActionResult result = mp.shoot();

        // Assert
        assertThat(result.getStatus()).isTrue();
    }

    @Test
    void shootWithLandAheadChangesLandIntoWater()
    {
        // Arrange
        Map map = new Map(3);
        Coordinate landCoordinate = new Coordinate(0, 1);
        map.setField(landCoordinate, Field.Land);

        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.shoot();

        // Assert
        Field fieldAfterShoot = map.getField(landCoordinate);
        assertThat(fieldAfterShoot).isEqualTo(Field.Water);
    }

    @Test
    void moveForwardWithLandAheadAfterShootCanBeContinued()
    {
        // Arrange
        Map map = new Map(4);
        Coordinate landCoordinate = new Coordinate(0, 2);
        map.setField(landCoordinate, Field.Land);

        Ship ship = new Ship(Direction.East);
        IMoveProcessor mp = new MoveProcessor(map, ship);

        // Act
        mp.moveForward(); // 0 -> 1
        mp.shoot(); // shoot land at 2
        mp.moveForward(); // 1 -> 2
        mp.moveForward(); // 2 -> 3

        // Assert
        Coordinate expected = new Coordinate(0, 3);
        assertThat(ship.getCoordinate()).isEqualTo(expected);
    }
}
