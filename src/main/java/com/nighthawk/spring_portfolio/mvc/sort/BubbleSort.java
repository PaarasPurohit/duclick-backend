package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public abstract class BubbleSort extends Sorting {

    public BubbleSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    public void sort() {
        int n = getToSort().size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (getToSort().get(i - 1) > getToSort().get(i)) {
                    int temp = getToSort().get(i - 1);
                    getToSort().set(i - 1, getToSort().get(i));
                    getToSort().set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
