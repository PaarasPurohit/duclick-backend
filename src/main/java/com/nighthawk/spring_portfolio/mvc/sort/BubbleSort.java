package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public abstract class BubbleSort extends Sorting {

    public BubbleSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    @Override
    void Sort(ArrayList<Integer> toSort) {
        bubbleSort(toSort, 0, toSort.size() - 1);
    }

    public void bubbleSort(ArrayList<Integer> toSort, int start, int end) {
        int n = end - start + 1;
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
}
