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


    //Sets currentBoxWeight to total weight of Books in list books
    public void setBoxWeight(){
        int total = 0;
        Book currentBook;

        for (int i = 0; i < books.size(); i++ ){
            currentBook = books.get(i);
            total += currentBook.getWeight();
        }
        currentBoxWeight = total;
    }

    //Returns currentBoxWeight
    public int getBoxWeight(){
        return currentBoxWeight;
    }


    public void addBook(Book temp){
        books.add(temp);
        //Updates currentBoxWeight with new book weight
        setBoxWeight();
        setnumOfBooks();
    }

    //Removes last Books object in books
    public void removeLastBook(){
        books.remove(books.size()-1);
        //Updates currentBoxWeight without removed element
        setBoxWeight();
        setnumOfBooks();
    }

    public ArrayList currentBooks(){
        return books;
    }
}
