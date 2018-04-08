package Projekt1;

import Projekt1.Entities.Direction;
import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;
import Projekt1.Logic.CommandProcessor;
import Projekt1.Logic.FilePersistenceService;
import Projekt1.Logic.Interfaces.*;
import Projekt1.Logic.MoveProcessor;
import Projekt1.Logic.StateFormatter;

public class Game
{
    private Map map;
    private Ship ship;

    private ICommandProcessor commandProcessor;
    private IMoveProcessor moveProcessor;
    private IPersistenceService persistenceService;
    private IStateFormatter stateFormatter;

    public Game(int mapSize)
    {
        this.map = new Map(mapSize, true);
        this.ship = new Ship(Direction.East);

        this.persistenceService = new FilePersistenceService();
        this.moveProcessor = new MoveProcessor(this.map, this.ship);
        this.stateFormatter = new StateFormatter(this.map, this.ship);
        this.commandProcessor = new CommandProcessor(this.moveProcessor);
    }

    public Game()
    {
        this.persistenceService = new FilePersistenceService();
        this.map = this.persistenceService.loadMap();
        this.ship = this.persistenceService.loadShip();

        this.moveProcessor = new MoveProcessor(this.map, this.ship);
        this.stateFormatter = new StateFormatter(this.map, this.ship);
        this.commandProcessor = new CommandProcessor(this.moveProcessor);
    }

    public void processCommandChain(String commandChain)
    {
        char[] commands = commandChain.toCharArray();
        for (char c : commands)
        {
            IActionResult result = this.commandProcessor.execute(c);
            String state = this.stateFormatter.getCurrentState();
            System.out.println(state);
            System.out.println("## " + result.getMessage());
            System.console().readLine();
            this.clearConsole();
        }
    }

    private void clearConsole()
    {
        try
        {
            String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception e)
        {
        }
    }
}
