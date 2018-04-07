package Projekt1.Logic;

import Projekt1.Entities.*;
import Projekt1.Logic.Interfaces.IActionResult;
import Projekt1.Logic.Interfaces.IPersistenceService;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilePersistenceService implements IPersistenceService
{
    private final static String MAP_FILENAME = "map.txt";
    private final static String SHIP_FILENAME = "ship.txt";

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

        try (PrintWriter out = new PrintWriter(MAP_FILENAME))
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

        try (PrintWriter out = new PrintWriter(SHIP_FILENAME))
        {
            out.println(sb.toString());
        }
        catch(Exception e)
        {
            return new ActionResult(false,"Error when saving ship to file!");
        }

        return new ActionResult(true, "Ship saved!");
    }

    public Ship loadShip()
    {
        List<String> lines = loadFileLines(SHIP_FILENAME);
        if (lines == null)
        {
            return null;
        }

        Character symbol = Character.toUpperCase(lines.get(0).charAt(0));
        Direction direction = null;

        if (symbol == Direction.North.getSymbol())
            direction = Direction.North;

        if (symbol == Direction.East.getSymbol())
            direction = Direction.East;

        if (symbol == Direction.South.getSymbol())
            direction = Direction.South;

        if (symbol == Direction.West.getSymbol())
            direction = Direction.West;

        int x = Integer.parseInt(lines.get(1));
        int y = Integer.parseInt(lines.get(2));
        return new Ship(direction, new Coordinate(x, y));
    }

    private List<String> loadFileLines(String fileName)
    {
        File file;
        Scanner scanner;
        try
        {
            file = new File(SHIP_FILENAME);
            scanner = new Scanner(file);
        }
        catch (Exception e)
        {
            return null;
        }

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine())
        {
            lines.add(scanner.nextLine());
        }

        return lines;
    }
}
