package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class BogoSort extends Sorting{

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

    private double factorial(int n){
        double tot = 1;
        for(int i = 1; i < n; i++){
            tot*=i;
        }
        return tot;
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
    @Override
    double worstCaseTime(){
        return factorial(this.getToSort().size());
    }
    public static void main(String[] args){
        System.out.println("~Bogosort: Time Complexity: O(n+1)!~");
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(3);
        i.add(2);
        i.add(5);
        i.add(78);
        i.add(10);

        BogoSort b = new BogoSort(i);

        double a = b.doSort();
        System.out.println(a);
    }


    
}
