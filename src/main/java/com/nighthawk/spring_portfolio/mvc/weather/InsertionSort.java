package com.nighthawk.spring_portfolio.mvc.weather;

import java.util.List;

public class InsertionSort extends SortingAlgorithm {

    @Override
    public void sort(List<WeatherData> data) {
        int n = data.size();

        for (int i = 1; i < n; ++i) {
            WeatherData key = data.get(i);
            int j = i - 1;

            while (j >= 0 && compare(data.get(j).getCurrent().getTemp_c(), key.getCurrent().getTemp_c()) > 0) {
                data.set(j + 1, data.get(j));
                j = j - 1;
            }
            data.set(j + 1, key);
        }
    }

    private int compare(double a, double b) {
        return Double.compare(a, b);
    }
}

