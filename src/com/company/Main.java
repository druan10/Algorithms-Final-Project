package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Roshan, Pim, and David on 11/29/16.
 */

public class Main{
    public static void main(String[] args) {

        //Initializes variables that we scan into
        int maxWeight = 0;
        ArrayList<Book> totalbooks = new ArrayList<>();

        try {
            Scanner scan = new Scanner(new File(args[0]));

            //Skips first line because number of books
            scan.nextInt();
            maxWeight = scan.nextInt();


            //Populates totalbooks with wieghts of books
            int i = 0;
            while(scan.hasNextInt()){
                totalbooks.add(new Book(i ,scan.nextInt()));
                i++;
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Sort totalbooks by Weights
        Collections.sort(totalbooks);

        //Arraylist of Boxes
        ArrayList<magicBox> Boxes = new ArrayList<>();
        int lastboxindex;

        //Sorts books into boxes
        while(!(totalbooks.isEmpty())){
            //Adds new box to List of Boxes if current box is too full to deal with any books left without boxes
            magicBox newbox = new magicBox();
            Boxes.add(newbox);
            lastboxindex = Boxes.size() - 1;


            //Iterates through totalbooks and adds the book with the greatest weight to the current box the box can accomodate
            for (int i = totalbooks.size() - 1; i >= 0 ; i--) {
                if ((Boxes.get(lastboxindex).getBoxWeight() + totalbooks.get(i).getWeight()) <= maxWeight) {
                    Boxes.get(lastboxindex).addBook(totalbooks.get(i));
                    totalbooks.remove(i);
                }
            }

        }


        //Prints magic boxes to output file
        try {
            PrintWriter writer = new PrintWriter(args[1], "UTF-8");
            writer.println(Boxes.size());
            for (magicBox i : Boxes){
                writer.println(i.getnumOfBooks());
                for (int j = 0; j < i.getnumOfBooks(); j++){
                    writer.println (i.getBook(j).getID());
                }
            }
            writer.close();
        }
        catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
        }

    }
}
