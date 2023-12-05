package com.nighthawk.spring_portfolio.mvc.weather;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingService {

    private final SortingAlgorithm bubbleSort;
    private final SortingAlgorithm insertionSort;
    private final SortingAlgorithm mergeSort;

    public SortingService(SortingAlgorithm bubbleSort, SortingAlgorithm insertionSort, SortingAlgorithm mergeSort) {
        this.bubbleSort = bubbleSort;
        this.insertionSort = insertionSort;
        this.mergeSort = mergeSort;
    }

    public void applySortingAlgorithms(List<WeatherData> data) {
        bubbleSort.sort(data);
        insertionSort.sort(data);
        mergeSort.sort(data);
    }
}
