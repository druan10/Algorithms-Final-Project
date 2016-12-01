package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Main{

    public static void main(String[] args) {

        int numOfBooks = 0;
        int maxWeight = 0;
        int [] bookWeights = {1};
        File input = new File(args[0]);
        File output = new File(args[1]);


        try {
            Scanner scan = new Scanner(new File(args[0]));

            numOfBooks = scan.nextInt();
            maxWeight = scan.nextInt();


            bookWeights = new int [numOfBooks];

            //Populates bookWeights with wieghts of books
            for (int i = 0; i < numOfBooks; i++){
                bookWeights[i] = scan.nextInt();;
            }

            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ArrayList<Book> totalbooks = new ArrayList<Book>();

        for (int i = 0; i < numOfBooks; i++){
            totalbooks.add(new Book(i, bookWeights[i]));
        }



        //Sort totalbooks by Weights
        Collections.sort(totalbooks);

/*        //Prints books in order from greatest to smallest weight
        for (int i = 0; i < numOfBooks; i++){
            System.out.println(totalbooks.get(i).getWeight());
        }*/

        //Arraylist of Boxes
        ArrayList<magicBox> Boxes = new ArrayList<magicBox>();
        magicBox currentBox = new magicBox();

        //List of Books to be removed
        ArrayList<Book> bookstobeRemoved = new ArrayList<Book>();

        //Sorts books into boxes
        while(!(totalbooks.isEmpty())){
            //Adds new box to List of Boxes if current box is too full to deal with any books left without boxes
            magicBox newbox = new magicBox();
            Boxes.add(newbox);
            currentBox = Boxes.get(Boxes.size() - 1);

            //Iterates through totalbooks and adds the book with the greatest weight to the current box the box can accomodate
            for (int i = 0; i < totalbooks.size(); i++){
                if((currentBox.getBoxWeight() + totalbooks.get(i).getWeight()) <= maxWeight){
                        currentBox.addBook(totalbooks.get(i));
                        bookstobeRemoved.add(totalbooks.get(i));
                }
            }

            //Iterates through both Lists and if a list in totalbooks appears in bookstobeRemoved, removes the element in totalbooks
            for (int i = 0; i < totalbooks.size(); i++){
                for (int j = 0; j < bookstobeRemoved.size(); j++){
                    if (totalbooks.get(i).getID() == bookstobeRemoved.get(j).getID()){
                        totalbooks.remove(i);
                    }
                }
            }

            //Clears list of books to be removed
            bookstobeRemoved.clear();
        }


        //Prints magic boxes to output file
        try {
            PrintWriter writer = new PrintWriter(args[1], "UTF-8");
            writer.println(Boxes.size());
            for (int i = 0; i < Boxes.size(); i++){
                writer.println(Boxes.get(i).getnumOfBooks());
                for (int j = 0; j < Boxes.get(i).getnumOfBooks(); j++){
                    writer.println (Boxes.get(i).getBook(j).getID());
                    //System.out.println (Boxes.get(i).getBook(j).getWeight());
                }
            }
            writer.close();
        }
        catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
        }

    }
}
