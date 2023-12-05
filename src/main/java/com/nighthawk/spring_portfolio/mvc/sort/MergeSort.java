package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public class MergeSort extends Sorting {

    public MergeSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    @Override
    void Sort(ArrayList<Integer> toSort) {
        mergeSort(getToSort(), 0, toSort.size() - 1);
    }

    @Override
    double worstCaseTime(){
        return Math.log(8)/Math.log(2);
    }

    private void mergeSort(ArrayList<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private void merge(ArrayList<Integer> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        ArrayList<Integer> leftArray = new ArrayList<>(arr.subList(left, left + n1));
        ArrayList<Integer> rightArray = new ArrayList<>(arr.subList(mid + 1, mid + 1 + n2));

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                arr.set(k, leftArray.get(i));
                i++;
            } else {
                arr.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr.set(k, leftArray.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        System.out.println("~Merge-sort: Time Complexity: O(n*log(n))~");
        ArrayList<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(3);
        i.add(2);
        i.add(5);
        i.add(78);
        i.add(10);

        MergeSort b = new MergeSort(i);

        long a = b.doSort();
        System.out.println(a);

        System.out.println(b.worstCaseTime());
    }
}
