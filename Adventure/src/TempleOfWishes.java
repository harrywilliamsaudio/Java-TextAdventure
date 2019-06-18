/*
 *
 *  COMP517
 *  Object Oriented Software Development
 *  Assignment 9
 *  Harry Williams - 201374501
 *
 */


// A class that represents the entire 'Temple' object.

public class TempleOfWishes
{
    Room room[][];
    int templeSize;

    // The temple

    TempleOfWishes(int tSize)
    {
        printIntro();

        templeSize = tSize;

        // Declare room object array

        room = new Room[templeSize][templeSize];

        // Instantiate Room object array
        // Nested loop - I row, J is column

        for (int i = 0; i < templeSize; ++i) {
            for (int j = 0; j < templeSize; ++j) {
                room[i][j] = new Room();
                room[i][j].displayRoom();
            }
        }

        for (int i = 0; i < templeSize; ++i) {
            for (int j = 0; j < templeSize; ++j) {
                while (room[i][j].noDoors < 2) {
                    room[i][j].setDoor('N');
                    room[i][j].setDoor('E');
                    room[i][j].setDoor('S');
                    room[i][j].setDoor('W');
                    room[i][j].displayRoom();
                }
            }
        }

        // Checks for a North facing door in the top row
        // If one is present, the relevant row is overwritten to remove it.

        for (int i = 0; i < templeSize; i++) {
            if (room[0][i].northDoor) {
                room[0][i].row[0] = room[0][0].top + room[0][0].top + room[0][0].top + room[0][0].top + room[0][0].top;
                room[0][i].northDoor = false;
                room[0][i].displayRoom();
            }
        }

        // Checks for a South facing door in the bottom row
        // If one is present, the relevant row is overwritten to remove it.

        for (int i = 0; i < templeSize; i++) {
            if (room[templeSize - 1][i].southDoor) {
                room[templeSize - 1][i].row[4] = room[0][0].top + room[0][0].top + room[0][0].top + room[0][0].top + room[0][0].top;
                room[templeSize - 1][i].southDoor = false;
                room[templeSize - 1][i].displayRoom();
            }
        }

        // Checks for a West facing door in the outermost column.
        // If one is present, the relevant row is overwritten to remove it.

        for (int i = 0; i < templeSize; i++) {
            if (room[i][0].westDoor) {
                room[i][0].row[2] = room[0][0].side + "   " + room[0][0].side;
                room[i][0].westDoor = false;
                room[i][0].displayRoom();
            } else if (room[i][0].westDoor && room[i][0].eastDoor) {
                room[i][0].row[2] = room[0][0].side + "   " + room[0][0].door;
                room[i][0].westDoor = false;
                room[i][0].displayRoom();
            }
        }

        // Checks for an East facing door in the outermost column.
        // If one is present, the relevant row is overwritten to remove it.

        for (int i = 0; i < templeSize; i++) {
            if (room[i][templeSize - 1].eastDoor) {
                room[i][templeSize - 1].row[2] = room[0][0].side + "   " + room[0][0].side;
                room[i][templeSize - 1].eastDoor = false;
                room[i][templeSize - 1].displayRoom();
            }
        }

        // Checks the previous column for an east door, and inserts a west door

        for (int i = 0; i < templeSize; i++) {
            for (int j = 1; j < templeSize; j++) {
                if (room[i][j - 1].eastDoor) {
                    room[i][j].westDoor = true;
                    room[i][j].displayRoom();
                }
            }
        }

        // Checks the next column for an west door, and inserts an east door

        for (int i = 0; i < templeSize; i++) {
            for (int j = 0; j < templeSize - 1; j++) {
                if (room[i][j + 1].westDoor) {
                    room[i][j].eastDoor = true;
                    room[i][j].displayRoom();
                }
            }
        }

        // Checks the previous row for a south door, and inserts a north door

        for (int i = 1; i < templeSize; i++) {
            for (int j = 0; j < templeSize; j++) {
                if (room[i - 1][j].southDoor) {
                    room[i][j].northDoor = true;
                    room[i][j].displayRoom();
                }
            }
        }

        // Checks the next row for a north door, and inserts a south door

        for (int i = 0; i < templeSize - 1; i++)
        {
            for (int j = 0; j < templeSize; j++)
            {
                if (room[i + 1][j].northDoor)
                {
                    room[i][j].southDoor = true;
                    room[i][j].displayRoom();
                }
            }
        }
    }

        // A method to print an ASCII logo at the beginning of the program.

        public void printIntro ()
        {
            System.out.println(Game.ANSI_PURPLE + "  _____                                               ");
            System.out.println(" |  __ \\                                             ");
            System.out.println(" | |  | | _   _  _ __    __ _   ___   ___   _ __      ");
            System.out.println(" | |  | || | | || '_ \\  / _` | / _ \\ / _ \\ | '_ \\ ");
            System.out.println(" | |__| || |_| || | | || (_| ||  __/| (_) || | | |    ");
            System.out.println(" |_____/  \\__,_||_| |_| \\__, | \\___| \\___/ |_| |_|");
            System.out.println("  __  __              _  __/ |                        ");
            System.out.println(" |  \\/  |            | ||___/                        ");
            System.out.println(" | \\  / |  __ _  ___ | |_  ___  _ __                 ");
            System.out.println(" | |\\/| | / _` |/ __|| __|/ _ \\| '__|               ");
            System.out.println(" | |  | || (_| |\\__ \\| |_|  __/| |                  ");
            System.out.println(" |_|  |_| \\__,_||___/ \\__|\\___||_|               \n");
            System.out.println(Game.ANSI_CYAN +"|----------------------Objective------------------------------|");
            System.out.println("|      Traverse the dungeon, collecting treasure as you go.   |");
            System.out.println("|Your backpack can only hold 50kg, so choose your loot wisely.|");
            System.out.println("|----------------------Controls-------------------------------|");
            System.out.println("|                Navigation: N, E, S, W                       |");
            System.out.println("|                  Show Inventory: I                          |");
            System.out.println("|                   Pick up Item: P                           |");
            System.out.println("|                    Drop Item: D                             |");
            System.out.println("|                     END GAME: F                             |");
            System.out.println("|-------------------------------------------------------------|" + Game.ANSI_RESET);
        }

        public Room getRoom(int row, int column)
        {
            return room[column][row];
        }


    }

