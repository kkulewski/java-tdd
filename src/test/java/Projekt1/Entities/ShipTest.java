package Projekt1.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ShipTest
{
    @Test
    public void newShip_FacesNorthDirection_ByDefault()
    {
        Ship ship = new Ship();
        assertEquals(Direction.North, ship.direction);
    }
}
