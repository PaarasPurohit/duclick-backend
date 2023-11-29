package com.nighthawk.spring_portfolio.mvc.sortingmethods;

import java.util.ArrayList;

public abstract class Sorting {

    private ArrayList<Integer> toSort;

    public Sorting(ArrayList<Integer> toSort){
        this.toSort = toSort; // Initializes sorting algorithm
    }

    abstract void Sort(ArrayList<Integer> toSort); 
    /*
     * Implement the sorting method in each child class
     */

    public long doSort(){ // Returns time taken
        
        long start = System.nanoTime();
        Sort(this.toSort);
        long end = System.nanoTime();

        
        return (end - start)/1000000;
    }
}
