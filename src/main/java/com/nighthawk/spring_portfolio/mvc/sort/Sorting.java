package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public abstract class Sorting {

    private ArrayList<Integer> toSort;

    public Sorting(ArrayList<Integer> toSort){
        this.toSort = toSort; // Initializes sorting algorithm
    }

    abstract void Sort(ArrayList<Integer> toSort); 

    public long doSort(){ 
        long start = System.nanoTime();
        Sort(getToSort());
        long end = System.nanoTime();
        return (end - start)/1000000;
    }

    public ArrayList<Integer> getToSort() {
        return toSort;
    }

    public void setToSort(ArrayList<Integer> toSort) {
        this.toSort = toSort;
    }

    // main method for testing
    public static void main(String[] args) {
        // Test for functionality
    }
}