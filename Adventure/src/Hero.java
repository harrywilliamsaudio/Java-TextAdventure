/*
 *
 *  COMP517
 *  Object Oriented Software Development
 *  Assignment 9
 *  Harry Williams - 201374501
 *
 */


import java.util.LinkedList;

public class Hero
{

    // Variables for the Hero to use.

    Room currentRoom;
    int currentRow;
    int currentColumn;
    int inventoryCapacity = 0;
    int inventoryValue = 0;

    LinkedList<Item>  inventory;

    // The hero constructor takes in the temple.
    // It randomly assigns a value for the X & Y coordinate respectively, then gets the room for that grid reference.

    Hero(TempleOfWishes temple)
    {
        currentRow = (int)(Math.random() * ((7) + 1));
        currentColumn = (int)(Math.random() * ((7) + 1));
        currentRoom = temple.getRoom(currentRow, currentColumn);
        inventory = new LinkedList<>();
    }

    //

    public void printInventory()
    {

        // Checks that the inventory is not empty.
        // If not, it iterates through the LinkedList and prints them out.

        if (!inventory.isEmpty())
        {
            System.out.println("Your backpack contains:\n");

            int index = 1;

            for (Item i : inventory)
            {
                System.out.println(index + " " + Game.ANSI_YELLOW + i + Game.ANSI_RESET);
                index++;
            }

            System.out.println("\nCapacity: " + inventoryCapacity + "/50kg");
            System.out.println("Total Value: " + inventoryValue + "\n");
        }

        // A default message if the bag is empty

        else
        {
            System.out.println("Your backpack is empty.");
            System.out.println("Capacity: " + inventoryCapacity + "/50kg\n");
        }
    }
}
