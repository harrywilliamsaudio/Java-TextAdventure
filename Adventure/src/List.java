/*
 *
 *  COMP517
 *  Object Oriented Software Development
 *  Assignment 9
 *  Harry Williams - 201374501
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Collections;

public class List
{

    // The linked list to hold the Strings

    LinkedList<Item> artefacts;

    List() throws IOException
    {
            artefacts = new LinkedList<>();

            File file = new File("/Users/macbook/Documents/Computer_Science/TermI/COMP517/Adventure/src/items.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String lootName;

            // Reads the file line by line, storing the passed to an item, which is added to the list.
            // This repeats until an empty line is encountered

            while ((lootName = br.readLine()) != null)
            {
                artefacts.add(new Item(lootName));
            }

            shuffle();
    }

    // Shuffles the list to attempt to maximise randomness.

    public void shuffle()
    {
        Collections.shuffle(artefacts);
    }

}

