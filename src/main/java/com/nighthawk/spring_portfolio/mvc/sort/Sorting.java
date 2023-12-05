package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public abstract class Sorting {

    private ArrayList<Integer> toSort;

    public Sorting(ArrayList<Integer> toSort){
        this.toSort = toSort; // Initializes sorting algorithm
    }

    abstract void Sort(ArrayList<Integer> toSort);  // Sorting method to be implemented
 
    abstract double worstCaseTime(); // Worst case (not time, but amount of parsings)

    public long doSort(){ 
        long start = System.currentTimeMillis();
        Sort(this.toSort);
        long end = System.currentTimeMillis();
        return (end - start);
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