package com.nighthawk.spring_portfolio.mvc.sort;

import java.util.ArrayList;

public class MergeSort extends Sorting {

    public MergeSort(ArrayList<Integer> toSort) {
        super(toSort);
    }

    @Override
    void Sort(ArrayList<Integer> toSort) {
        mergeSort(toSort, 0, toSort.size() - 1);
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
}
