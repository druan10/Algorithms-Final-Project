package com.company;

/**
 * Created by rshnbhatia on 11/29/16.
 */
public class Book implements Comparable<Book>{
    int iD;
    int weight;

    public Book(int iD, int weight){
        this.iD = iD;
        this.weight = weight;

    }

    //returns initial order of book
    public int getID(){
        return this.iD;
    }

    //returns Weight of book
    public int getWeight(){
        return this.weight;
    }

    //compareTo for Book, sorts in reverse order
    @Override
    public int compareTo(Book o) {
        if (this.getWeight() > o.getWeight()){
            return -1;
        }else if (this.getWeight() < o.getWeight()){
            return 1;
        }else{
            return 0;
        }
    }
}
