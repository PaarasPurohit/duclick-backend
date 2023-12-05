package com.nighthawk.spring_portfolio.mvc.weather;

import java.util.List;

public class MergeSort extends SortingAlgorithm {

    @Override
    public void sort(List<WeatherData> data) {
        mergeSort(data, 0, data.size() - 1);
    }

    private void mergeSort(List<WeatherData> data, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(data, l, m);
            mergeSort(data, m + 1, r);
            merge(data, l, m, r);
        }
    }

    private void merge(List<WeatherData> data, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        WeatherData[] L = new WeatherData[n1];
        WeatherData[] R = new WeatherData[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = data.get(l + i);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = data.get(m + 1 + j);
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (compare(L[i].getCurrent().getTemp_c(), R[j].getCurrent().getTemp_c()) <= 0) {
                data.set(k, L[i]);
                i++;
            } else {
                data.set(k, R[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            data.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            data.set(k, R[j]);
            j++;
            k++;
        }
    }

    private int compare(double a, double b) {
        return Double.compare(a, b);
    }
}

