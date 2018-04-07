package Projekt1.Logic;

import static org.assertj.core.api.Assertions.*;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.IPersistenceService;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        File f = new File(FilePersistenceService.MAP_FILENAME);
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
        File f = new File(FilePersistenceService.SHIP_FILENAME);
        boolean fileExists = f.exists() && !f.isDirectory();
        assertThat(fileExists).isTrue();
    }

    @Test
    public void loadMap_LoadsPreviouslySavedMapFromFile()
    {
        // Arrange
        int size = 8;
        Map map = new Map(size, true);
        IPersistenceService ps = new FilePersistenceService();
        ps.saveMap(map);

        // Act
        Map loadedMap = ps.loadMap();

        // Assert
        List<Field> mapFields = new ArrayList<>();
        List<Field> loadedMapFields = new ArrayList<>();

        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                Coordinate coordinate = new Coordinate(x, y);
                mapFields.add(map.getField(coordinate));
                loadedMapFields.add(loadedMap.getField(coordinate));
            }
        }

        Assert.assertThat(loadedMapFields, IsIterableContainingInOrder.contains(mapFields.toArray()));
    }

    @Test
    public void loadShip_LoadsPreviouslySavedShipFromFile()
    {
        // Arrange
        Ship ship = new Ship(Direction.West, new Coordinate(2, 3));
        IPersistenceService ps = new FilePersistenceService();
        ps.saveShip(ship);

        // Act
        Ship loadedShip = ps.loadShip();

        // Assert
        assertThat(loadedShip.getCoordinate()).isEqualTo(ship.getCoordinate());
    }
}
