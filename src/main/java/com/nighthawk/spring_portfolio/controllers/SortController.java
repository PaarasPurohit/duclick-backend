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

    @GetMapping("/merge") // Merge sort get (need to check if arraylist allowed)
    // @RequestParam handles variables binding to frontend, defaults, etc
    public long mergeSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        MergeSort mergeSort = new MergeSort(toSort);    
        long executionTime = mergeSort.doSort(); 
        return executionTime;

    }
    @GetMapping("/insertion") // Insertion Sort @getmapping method
    public long insertionSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        InsertionSort insertionSort = new InsertionSort(toSort);    
        long executionTime = insertionSort.doSort();       
        return executionTime;
    }

    @GetMapping("/bogo") // BogoSort @getmapping method
    public long bogoSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        BogoSort bogoSort = new BogoSort(toSort);    
        long executionTime = bogoSort.doSort();       
        return executionTime;
    }

    @GetMapping("/bubble") // Bubblesort Get mapping method
    public long bubbleSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        BubbleSort bubbleSort = new BubbleSort(toSort);    
        long executionTime = bubbleSort.doSort();       
        return executionTime;
    }

    // TODO: Test Methods

}
