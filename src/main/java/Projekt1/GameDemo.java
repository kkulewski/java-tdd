package Projekt1;

import Projekt1.Entities.Direction;
import Projekt1.Entities.Map;
import Projekt1.Entities.Ship;
import Projekt1.Logic.CommandProcessor;
import Projekt1.Logic.FilePersistenceService;
import Projekt1.Logic.Interfaces.*;
import Projekt1.Logic.MoveProcessor;
import Projekt1.Logic.StateFormatter;

public class GameDemo
{
    private Map map;
    private Ship ship;

    private ICommandProcessor commandProcessor;
    private IMoveProcessor moveProcessor;
    private IPersistenceService persistenceService;
    private IStateFormatter stateFormatter;

    public GameDemo()
    {
        this.persistenceService = new FilePersistenceService();
    }

    public void run()
    {
        processModeLoop();
        processCommandLoop();
    }

    private void processModeLoop()
    {
        boolean selected = selectMode();
        while (!selected)
        {
            selected = selectMode();
        }
    }

    private void processCommandLoop()
    {
        while (true)
        {
            System.out.println(this.stateFormatter.getCurrentState());
            System.out.println("Input commands to be executed.");
            System.out.println("n:forward | w:back | l:left | r:right | s:shoot | q:save+exit | e:exit");
            String input = System.console().readLine().toLowerCase();

            if (input.startsWith("e"))
            {
                System.exit(0);
            }

            if (input.startsWith("q"))
            {
                saveGame();
                System.exit(0);
            }

            processCommands(input.toCharArray());
        }
    }

    private boolean selectMode()
    {
        this.gameInitializationPrompt();
        int mode = processGameInitializationOption();

        switch(mode)
        {
            case 1:
                createNewGamePrompt();
                int gameSize = processGameSizeOption();
                createNewGame(gameSize);
                return true;

            case 2:
                loadGame();
                return true;

            default:
                invalidOptionPrompt();
                break;
        }

        return false;
    }

    private void gameInitializationPrompt()
    {
        System.out.println("Select mode:");
        System.out.println("[1] Create new game");
        System.out.println("[2] Load previously saved game");
    }

    private int processGameInitializationOption()
    {
        return Integer.parseInt(System.console().readLine());
    }

    private void createNewGamePrompt()
    {
        System.out.println("Enter map size:");
    }

    private int processGameSizeOption()
    {
        int input = 0;
        try
        {
            input = Integer.parseInt(System.console().readLine());
        }
        catch(Exception e)
        {
            invalidOptionPrompt();
            System.exit(0);
        }

        return input;
    }

    private void invalidOptionPrompt()
    {
        System.out.println("Invalid option!");
    }

    private void createNewGame(int mapSize)
    {
        this.map = new Map(mapSize, true);
        this.ship = new Ship(Direction.East);

        this.moveProcessor = new MoveProcessor(this.map, this.ship);
        this.stateFormatter = new StateFormatter(this.map, this.ship);
        this.commandProcessor = new CommandProcessor(this.moveProcessor);
    }

    private void loadGame()
    {
        this.map = this.persistenceService.loadMap();
        this.ship = this.persistenceService.loadShip();

        this.moveProcessor = new MoveProcessor(this.map, this.ship);
        this.stateFormatter = new StateFormatter(this.map, this.ship);
        this.commandProcessor = new CommandProcessor(this.moveProcessor);
    }

    private void saveGame()
    {
        this.persistenceService.saveMap(this.map);
        this.persistenceService.saveShip(this.ship);
        System.out.println("Game saved successfully.");
    }

    public void processCommands(char[] commands)
    {
        for (char c : commands)
        {
            IActionResult result = this.commandProcessor.execute(c);
            System.out.println(this.stateFormatter.getCurrentState());
            System.out.println("> " + result.getMessage());
            System.out.println();
            System.out.println();
            System.console().readLine();
        }
    }
}