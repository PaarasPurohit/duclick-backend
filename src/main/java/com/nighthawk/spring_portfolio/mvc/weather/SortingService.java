package com.nighthawk.spring_portfolio.mvc.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingService {

    private final List<SortingAlgorithm> sortingAlgorithms;

    @Autowired
    public SortingService(List<SortingAlgorithm> sortingAlgorithms) {
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public void applySortingAlgorithms(List<WeatherData> data) {
        for (SortingAlgorithm algorithm : sortingAlgorithms) {
            List<WeatherData> copyOfData = copyList(data);
            long startTime = System.currentTimeMillis();
            algorithm.sort(copyOfData);
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            System.out.println(algorithm.getClass().getSimpleName() +
                    " - Time taken: " + timeTaken + " milliseconds" +
                    " - Time Complexity: " + getTimeComplexity(algorithm));
        }
    }

    private List<WeatherData> copyList(List<WeatherData> original) {
        return List.copyOf(original);
    }

    private String getTimeComplexity(SortingAlgorithm algorithm) {
        if (algorithm instanceof BubbleSort) {
            return "O(n^2)";
        } else if (algorithm instanceof InsertionSort) {
            return "O(n^2)";
        } else if (algorithm instanceof MergeSort) {
            return "O(n log n)";
        } else {
            return "Unknown";
        }
    }
}
