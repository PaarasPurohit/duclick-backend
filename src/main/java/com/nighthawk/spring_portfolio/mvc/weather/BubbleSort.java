package com.nighthawk.spring_portfolio.mvc.weather;

import java.util.List;

public class BubbleSort extends SortingAlgorithm {

    @Override
    public void sort(List<WeatherData> data) {
        int n = data.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(data.get(j).getCurrent().getTemp_c(), data.get(j + 1).getCurrent().getTemp_c()) > 0) {
                    // swap temp and arr[i]
                    WeatherData temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }

    private int compare(double a, double b) {
        return Double.compare(a, b);
    }
}

