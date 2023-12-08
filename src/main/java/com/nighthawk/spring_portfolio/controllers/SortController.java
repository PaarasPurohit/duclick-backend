package com.nighthawk.spring_portfolio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.sort.BogoSort;
import com.nighthawk.spring_portfolio.mvc.sort.BubbleSort;
import com.nighthawk.spring_portfolio.mvc.sort.InsertionSort;
import com.nighthawk.spring_portfolio.mvc.sort.MergeSort;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/sorting")
public class SortController {

    @GetMapping("/merge")
    public long mergeSort(@RequestParam(name = "list") ArrayList<Integer> toSort) {
        MergeSort mergeSort = new MergeSort(toSort);
        long executionTime = mergeSort.doSort();
        return executionTime;
    }

    @GetMapping("/insertion")
    public long insertionSort(@RequestParam(name = "list") ArrayList<Integer> toSort) {
        InsertionSort insertionSort = new InsertionSort(toSort);
        long executionTime = insertionSort.doSort();
        return executionTime;
    }

    @GetMapping("/bogo")
    public long bogoSort(@RequestParam(name = "list") ArrayList<Integer> toSort) {
        BogoSort bogoSort = new BogoSort(toSort);
        long executionTime = bogoSort.doSort();
        return executionTime;
    }

    @GetMapping("/bubble")
    public long bubbleSort(@RequestParam(name = "list") ArrayList<Integer> toSort) {
        BubbleSort bubbleSort = new BubbleSort(toSort);
        long executionTime = bubbleSort.doSort();
        return executionTime;
    }

    // TODO: Test Methods
}