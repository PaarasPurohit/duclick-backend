package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public class InsertionSort extends Sorting{

    public InsertionSort(ArrayList<Integer> toSort) {
        super(toSort);
    }
    
    @Override
    void Sort(ArrayList<Integer> toSort) {
        int n = toSort.size();
        for (int i = 1; i < n; ++i) {
            int key = toSort.get(i);
            int j = i - 1;

            while (j >= 0 && toSort.get(j) > key) {
                toSort.set(j + 1, toSort.get(j));
                j = j - 1;
            }
            toSort.set(j + 1, key);
        }
    }

    @Override
    double worstCaseTime(){
        return 0.0;
    }
    public static void main(String[] args){
        System.out.println("~Insertion-sort: Time Complexity: O(n^2)~");
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(3);
        i.add(2);
        i.add(5);
        i.add(78);
        i.add(10);

        InsertionSort b = new InsertionSort(i);

        long a = b.doSort();
        System.out.println(a);
    }
}
