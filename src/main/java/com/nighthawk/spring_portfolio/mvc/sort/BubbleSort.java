package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public abstract class BubbleSort extends Sorting {

    public BubbleSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    public void sort() {
        int n = toSort.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (toSort.get(i - 1) > toSort.get(i)) {
                    // Swap elements if they are in the wrong order
                    int temp = toSort.get(i - 1);
                    toSort.set(i - 1, toSort.get(i));
                    toSort.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
