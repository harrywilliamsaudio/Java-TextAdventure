/*
 *
 *  COMP517
 *  Object Oriented Software Development
 *  Assignment 9
 *  Harry Williams - 201374501
 *
 */

public class Item
{
    int size  = 0;
    int value = 0;
    String name = "";

    // Item constructor which takes a string input for its name.
    // It is passed this string when in the Room Scatter function

    Item(String input)
    {
        setSize();
        setValue();
        name = input;
    }

    // Overrides the default toString method to return a representation of each item

    public String toString()
    {
        return name + " (" + size + "kg : " + value + "∆)";
    }

    // Generates a random integer between 5 and 15 to represent the 'Size' parameter

    private void setSize()
    {
       size = 5 + (int)(Math.random() * ((15 - 5) + 1));

    }

    // Generates a random integer between 1 and 20 to represent the 'Value' parameter

    private void setValue()
    {
        value = 1 + (int)(Math.random() * ((20 - 1) + 1));
    }
}



