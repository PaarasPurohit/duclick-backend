package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public abstract class BogoSort extends Sorting{

    public BogoSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    private static boolean isSorted(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static void shuffleSort(ArrayList<Integer> list) {
        Collections.shuffle(list, new Random());
    }

    @Override
    void Sort(ArrayList<Integer> toSort) {
        while(!isSorted(toSort)){
            shuffleSort(toSort);
        }
    }

    



    
}
