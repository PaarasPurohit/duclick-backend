package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public class BubbleSort extends Sorting {

    public BubbleSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    @Override
    void Sort(ArrayList<Integer> toSort) {
        if (toSort == null || toSort.size() <= 1) {
            // No need to sort an empty list or a list with only one element
            return;
        }

        bubbleSort(toSort, 0, toSort.size() - 1);
    }

    public void bubbleSort(ArrayList<Integer> toSort, int start, int end) {
        if (toSort == null || start < 0 || end >= toSort.size() || start >= end) {
            // Invalid input, cannot perform sorting
            return;
        }

        boolean swapped;

        do {
            swapped = false;
            for (int i = start + 1; i <= end; i++) {
                if (toSort.get(i - 1) > toSort.get(i)) {
                    int temp = toSort.get(i - 1);
                    toSort.set(i - 1, toSort.get(i));
                    toSort.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    @Override
<<<<<<< HEAD
    double worstCaseTime() {
        // No specific worst-case time for BubbleSort
        return 0.0;
=======
    double worstCaseTime(){
        return (this.getToSort().size())^2;
>>>>>>> 7325add7b88213f7546aac8d630576ab9ec7c64c
    }

    public static void main(String[] args) {
        System.out.println("~Bubble-sort: Time Complexity: O(n^2)~");
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(3);
        i.add(2);
        i.add(5);
        i.add(78);
        i.add(10);

        BubbleSort b = new BubbleSort(i);

        double a = b.doSort();
        System.out.println(a);
    }
}
