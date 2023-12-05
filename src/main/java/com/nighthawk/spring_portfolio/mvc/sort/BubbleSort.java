package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public class BubbleSort extends Sorting {

    public BubbleSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    @Override
    void Sort(ArrayList<Integer> toSort) {
        bubbleSort(toSort, 0, toSort.size() - 1);
    }

    public void bubbleSort(ArrayList<Integer> toSort, int start, int end) {
        //int n = end - start + 1;
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
    double worstCaseTime(){
        return 0.0;
    }

    public static void main(String[] args){
        System.out.println("~Bubble-sort: Time Complexity: O(n^2)~");
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(3);
        i.add(2);
        i.add(5);
        i.add(78);
        i.add(10);

        BubbleSort b = new BubbleSort(i);

        long a = b.doSort();
        System.out.println(a);
    }
}
