package Projekt1.Logic;

import Projekt1.Entities.Coordinate;
import Projekt1.Entities.Field;
import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;
import Projekt1.Logic.Interfaces.IActionResult;
import Projekt1.Logic.Interfaces.IPersistenceService;

import java.io.PrintWriter;

public class FilePersistenceService implements IPersistenceService
{
    @Override
    public IActionResult saveMap(Map map)
    {
        int mapSize = map.getSize();

        StringBuilder sb = new StringBuilder();
        sb.append(mapSize);

        for (int x = 0; x < mapSize; x++)
        {
            sb.append(System.lineSeparator());
            for (int y = 0; y < mapSize; y++)
            {
                Field field = map.getField(new Coordinate(x, y));
                sb.append(field.getSymbol());
            }
        }

        try (PrintWriter out = new PrintWriter("map.txt"))
        {
            out.println(sb.toString());
        }
        catch(Exception e)
        {
            return new ActionResult(false,"Error when saving map to file!");
        }

        return new ActionResult(true, "Map saved!");
    }

    @Override
    public IActionResult saveShip(Ship ship)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(ship.getDirection().getSymbol());
        sb.append(System.lineSeparator());
        sb.append(ship.getCoordinate().X);
        sb.append(System.lineSeparator());
        sb.append(ship.getCoordinate().Y);

        try (PrintWriter out = new PrintWriter("ship.txt"))
        {
            out.println(sb.toString());
        }
        catch(Exception e)
        {
            return new ActionResult(false,"Error when saving ship to file!");
        }

        return new ActionResult(true, "Ship saved!");
    }
}
