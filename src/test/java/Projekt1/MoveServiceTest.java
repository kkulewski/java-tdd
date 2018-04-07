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
}
