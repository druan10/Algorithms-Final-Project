package com.company;

/**
 * Created by Roshan, Pim, and David on 11/29/16.
 */
public class Book implements Comparable<Book>{
    int iD;
    int weight;

    public Book(int iD, int weight){
        this.iD = iD;
        this.weight = weight;s

    }

    //returns initial order of book
    public int getID(){
        return this.iD;
    }

    //returns Weight of book
    public int getWeight(){
        return this.weight;
    }

    //compareTo for Book
    @Override
    public int compareTo(Book o) {
        if (this.getWeight() > o.getWeight()){
            return 1;
        }else if (this.getWeight() < o.getWeight()){
            return -1;
        }else{
            return 0;
        }
    }
}
