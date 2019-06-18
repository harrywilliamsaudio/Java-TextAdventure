/*
 *
 *  COMP517
 *  Object Oriented Software Development
 *  Assignment 9
 *  Harry Williams - 201374501
 *
 */

// A class to represent the room object

import java.util.LinkedList;

public class Room
{
    // Variables to be used in Room Creation

    String  door   = "D";
    String  top    = "=";
    String  side   = "|";
    boolean northDoor, eastDoor, southDoor, westDoor = false;
    public String[]row;
    public int noDoors = 0;





    public LinkedList<Item> contents;

    // A constructor method to set the Room characters and instantiate the LinkedList

    Room()
    {
        row = new String[5];
        contents = new LinkedList<>();
    }

    // A helper function for the constructor that sets door locations

    public void setDoor(char direction)
    {
        // Randomly generates a 1 or 2
        // If the random number is 1, a room is given a door

        int yesNo = (Math.random() <= 0.5) ? 1 : 2;

        if (direction == 'N' && yesNo == 1)
        {
            northDoor = true;
            noDoors++;
        }

        if (direction == 'E' && yesNo == 1)
        {
            eastDoor = true;
            noDoors++;
        }

        if (direction == 'S' && yesNo == 1)
        {
            southDoor = true;
            noDoors++;
        }

        if (direction == 'W' && yesNo == 1)
        {
            westDoor = true;
            noDoors++;
        }
    }

    // A method that concatenates the rows to create a String representation of the room

    public void displayRoom()
    {
        // Initalises the default case for each row of the room

        row[0] = top + top + top + top + top;
        row[1] = side   + "   "      + side;
        row[2] = side   + "   "      + side;
        row[3] = side   + "   "      + side;
        row[4] = top + top + top + top + top;

        // Alters the relevant rows based on whether or not there is a door at each direction

        if (northDoor)
        {
            row[0]   = top + top + door + top + top;
        }

        if (eastDoor)
        {
            row[2] = side + "   " + door;
        }

        if (southDoor)
        {
            row[4]  = top + top + door + top + top;
        }

        if (westDoor)
        {
            row[2] = door + "   " + side;
        }

        if (eastDoor && westDoor)
        {
            row[2] = door + "   " + door;
        }
    }

    // Prints the current room location and the doors it has available

    public void printRoomInfo (int row, int column)
    {
        row += 1;
        column += 1;

        System.out.println("You are in Room " + Game.ANSI_PURPLE + "(" + column + "-" + row + ")" + Game.ANSI_RESET);

        if (northDoor) {
            System.out.println("There is a North door");
        }

        if (eastDoor) {
            System.out.println("There is an East door");
        }

        if (southDoor)
        {
            System.out.println("There is a South door");
        }

        if (westDoor) {
            System.out.println("There is a West door");
        }

        if (!northDoor && !eastDoor && !southDoor && !westDoor)
        {
            System.out.println("There are no doors. You are imprisoned");
        }
    }

    // Prints out the Room's LinkedList

    public void printRoomContents()
    {
        int index = 1;

        if (!contents.isEmpty())
        {
            System.out.println("\nThis room contains: \n");
            for (Item i : contents)
            {
                System.out.println(index + Game.ANSI_YELLOW + " " + i.toString() + Game.ANSI_RESET);
                index++;
            }
        }

        else
        {
            System.out.println("The room is empty. ");
        }

    }
}
