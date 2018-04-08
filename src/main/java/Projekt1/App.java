package Projekt1;

public class App 
{
    public static void main(String[] args)
    {
        Game game = new Game(12);
        while (true)
        {
            System.out.println("Enter command chain:");
            String input = System.console().readLine();
            game.processCommandChain(input);
        }
    }
}
