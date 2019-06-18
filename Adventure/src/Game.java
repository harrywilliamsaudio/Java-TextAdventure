import java.util.Scanner;

public class Game
{

    // Text colours, just for Fun!

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";



    // A scanner that takes in a single char as a command.

    Scanner input = new Scanner(System.in);

    // This switch statement effectively houses the entire game.
    // Once the Hero, Temple & gameState bool have been initialised, they are passed into the Game loop.

    public void gameLoop(Hero hero, TempleOfWishes temple, boolean gameState)
    {
        while (gameState)
        {

            // Prints out the info of the current room (Grid reference and doors)
            // Takes in the users input as a char.

            hero.currentRoom.printRoomInfo(hero.currentRow, hero.currentColumn);
            System.out.println("Enter command: ");
            char playerInput = input.next().charAt(0);

            switch (playerInput)
            {

                // Navigation Cases

                // Checks that the current room has the requisite Door.
                // If successful it adjusts the coordinate
                // The current room is then 'got' using the updated coordinates

                // North

                case 'n':
                {


                    if (hero.currentRoom.northDoor)
                    {
                        System.out.println("You head north...\n");
                        hero.currentColumn -= 1;
                        hero.currentRoom = temple.getRoom(hero.currentRow, hero.currentColumn);
                        break;
                    }
                    else
                    {
                        System.out.println("\nYou can't go that way.\n");
                        break;
                    }
                }

                // East

                case 'e':
                    {

                        if (hero.currentRoom.eastDoor)
                        {
                            System.out.println("You go through the east door...\n");
                            hero.currentRow += 1;
                            hero.currentRoom = temple.getRoom(hero.currentRow, hero.currentColumn);
                            break;
                        }

                        else
                        {
                            System.out.println("\nYou can't go that way.\n");
                            break;
                        }
                }

                // South

                case 's':
                {
                    if (hero.currentRoom.southDoor)
                    {
                        System.out.println("You go South...\n");
                        hero.currentColumn += 1;
                        hero.currentRoom = temple.getRoom(hero.currentRow, hero.currentColumn);
                        break;
                    }
                    else
                    {
                        System.out.println("\nYou can't go that way.\n");
                        break;
                    }
                }

                // West

                case 'w': {
                    if (hero.currentRoom.westDoor) {
                        System.out.println("Go west...\n");
                        hero.currentRow -= 1;
                        hero.currentRoom = temple.getRoom(hero.currentRow, hero.currentColumn);
                        break;
                    } else {
                        System.out.println("\nYou can't go that way.\n");
                        break;
                    }
                }

                // Item Cases

                case 'i': {
                    hero.printInventory();
                    break;
                }

                // Lists the heroes inventory and transfers the chosen item from the Hero List to the Room Contents.

                case 'd': {

                    hero.printInventory();

                    if(!hero.inventory.isEmpty())
                    {
                        System.out.println("Enter the number of the item you want to drop.");
                        System.out.println("Press 0 to leave things be.\n");
                        int pickup = input.nextInt();

                        if (pickup == 0)
                        {
                            System.out.println("You zip up your bag.\n");
                            break;
                        }

                        hero.inventoryCapacity -= hero.inventory.get(pickup - 1).size;
                        hero.inventoryValue    -= hero.inventory.get(pickup - 1).value;
                        hero.currentRoom.contents.add(hero.inventory.remove(pickup - 1));
                        System.out.println("You remove the " + ANSI_YELLOW + hero.currentRoom.contents.peekLast().name +
                                ANSI_RESET + " from your bag, and drop it on the floor\n");

                    }
                    break;
                }

                // Lists the items in the room and allows the user to select the item they want.
                // The item from that index position is then taken from the Room list and added to the backpack.
                // It also checks that there is enough space in the backpack to include the item.

                case 'p':
                {

                    if (hero.currentRoom.contents.isEmpty())
                    {
                        System.out.println("The room is empty...\n");
                        break;
                    }

                    hero.currentRoom.printRoomContents();
                    System.out.println("Enter the number of the item you want to pick up.");
                    System.out.println("Press 0 to leave things be.\n");
                    int pickup = input.nextInt();

                    if (pickup > hero.currentRoom.contents.size())
                    {
                        System.out.println("There's no item there.");
                    }
                    else if (pickup == 0)
                    {
                        System.out.println("You decide the leave the loot in place, lest you disturb the spirits.\n");
                        break;
                    }

                    if (hero.inventoryCapacity + hero.currentRoom.contents.get(pickup - 1).size <= 50)
                    {
                        hero.inventoryCapacity += hero.currentRoom.contents.get(pickup - 1).size;
                        hero.inventoryValue    += hero.currentRoom.contents.get(pickup - 1).value;
                        hero.inventory.add(hero.currentRoom.contents.remove(pickup - 1));

                        System.out.println("You pick up the " + ANSI_YELLOW + hero.inventory.peekLast().name + ANSI_RESET
                                            + " and put it in your bag.\n");

                        break;
                    }
                    else
                    {
                        System.out.println("That won't fit in your backpack.\n");
                    }
                    break;
                }

                case 'f':
                {
                    System.out.println("\nGoodbye.\n");
                    gameState = false;
                    break;
                }
            }
        }
    }
}
