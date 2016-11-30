package com.company;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main{

    public static void main(String[] args) {

        int numOfBooks;
        int maxWeight;

        numOfBooks = 12;
        maxWeight = 22;

        int [] bookWeights = {3,4,5,6,8,1,2,6,2,11,4,7};
        //Arrays.sort(books);

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

            //Iterates through totalbooks and adds the book with the greatest weight to the current box if it can deal with it
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

        System.out.println(Boxes.size());
        for (int i = 0; i < Boxes.size(); i++){
            System.out.println(Boxes.get(i).getnumOfBooks());
            for (int j = 0; j < Boxes.get(i).getnumOfBooks(); j++){
                System.out.println (Boxes.get(i).getBook(j).getID());
                //System.out.println (Boxes.get(i).getBook(j).getWeight());
            }

        }
    }
}
