package Projekt1.Logic;

import Projekt1.Entities.Coordinate;
import Projekt1.Entities.Field;
import Projekt1.Entities.Map;
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
}
