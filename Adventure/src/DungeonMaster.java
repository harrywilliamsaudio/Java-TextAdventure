/*
 *
 *  COMP517
 *  Object Oriented Software Development
 *  Assignment 9
 *  Harry Williams - 201374501
 *
 */

// The main class which calls the various methods stored within TempleOfWishes

import java.io.IOException;
import java.util.Scanner;

public class DungeonMaster
{
    public static void main(String[] args) throws IOException
    {
        // Instantiates the objects and variables required for the game.

        boolean isPlaying = true;
        TempleOfWishes temple = new TempleOfWishes(8);
        List lists = new List();
        Hero hero = new Hero(temple);
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        // Scatters the items through the temple.
        // It generates 2 random integers between 0 and 7
        // The last item from the artefact list is then transfered to the chosen room's Contents list.

        for (int index = 0; index < 50; index++)
        {
            int i = (int) (Math.random() * ((7) + 1));
            int j = (int) (Math.random() * ((7) + 1));
            temple.room[i][j].contents.add(lists.artefacts.remove());
        }

        System.out.println("Press any key to begin: ");
        sc.next();

        // The game is set up in this loop.

        game.gameLoop(hero, temple, isPlaying);
    }
}