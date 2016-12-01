package com.company;

import java.util.ArrayList;

/**
 * Created by rshnbhatia on 11/29/16.
 */
public class magicBox {

    public int currentBoxWeight;
    public ArrayList<Book> books = new ArrayList<Book>();
    public int numOfBooks;


    public magicBox(){
    }

    public Book getBook(int index){
        return books.get(index);
    }

    //Sets number of books
    public void setnumOfBooks(){
        numOfBooks = books.size();
    }

    public int getnumOfBooks(){
        return numOfBooks;
    }

    public void updateBoxWeight(int addedWeight){
        currentBoxWeight+=addedWeight;
    }


    //Returns currentBoxWeight
    public int getBoxWeight(){
        return currentBoxWeight;
    }


    public void addBook(Book temp){
        books.add(temp);
        numOfBooks++;
        //Updates currentBoxWeight with new book weight
        updateBoxWeight(temp.getWeight());
    }

    public ArrayList currentBooks(){
        return books;
    }
}
