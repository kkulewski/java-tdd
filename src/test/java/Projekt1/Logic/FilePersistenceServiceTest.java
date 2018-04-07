package Projekt1.Logic;

import static org.assertj.core.api.Assertions.*;

import Projekt1.Entities.Coordinate;
import Projekt1.Entities.Direction;
import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;
import Projekt1.Logic.Interfaces.IPersistenceService;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FilePersistenceServiceTest
{
    @Test
    public void saveMap_SavesMapToFile()
    {
        // Arrange
        Map map = new Map(8, true);
        IPersistenceService ps = new FilePersistenceService();

        // Act
        ps.saveMap(map);

        // Assert
        File f = new File("map.txt");
        boolean fileExists = f.exists() && !f.isDirectory();
        assertThat(fileExists).isTrue();
    }

    @Test
    public void saveShip_SavesShipToFile()
    {
        // Arrange
        Ship ship = new Ship(Direction.West, new Coordinate(2, 3));
        IPersistenceService ps = new FilePersistenceService();

        // Act
        ps.saveShip(ship);

        // Assert
        File f = new File("ship.txt");
        boolean fileExists = f.exists() && !f.isDirectory();
        assertThat(fileExists).isTrue();

    }
}
