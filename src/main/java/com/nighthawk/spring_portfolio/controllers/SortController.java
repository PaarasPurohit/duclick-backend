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
@CrossOrigin(origins = "http://127.0.0.1:4000/")
public class SortController {

    @PostMapping("/merge/") // Merge sort get (need to check if arraylist allowed)
    // @RequestParam handles variables binding to frontend, defaults, etc
    public double mergeSort(@RequestBody ArrayList<Integer> toSort) {
        MergeSort mergeSort = new MergeSort(toSort);    
        double executionTime = mergeSort.doSort(); 
        return executionTime;
    }
    @PostMapping("/insertion/") // Insertion Sort @getmapping method
    public double insertionSort(@RequestBody ArrayList<Integer> toSort) {
        InsertionSort insertionSort = new InsertionSort(toSort);    
        double executionTime = insertionSort.doSort();       
        return executionTime;
    }

    @PostMapping("/bogo/") // BogoSort @getmapping method
    public double bogoSort(@RequestBody ArrayList<Integer> toSort) {
        BogoSort bogoSort = new BogoSort(toSort);    
        double executionTime = bogoSort.doSort();       
        return executionTime;
    }

    @PostMapping("/bubble/") // Bubblesort Get mapping method
    public double bubbleSort(@RequestBody ArrayList<Integer> toSort) {
        BubbleSort bubbleSort = new BubbleSort(toSort);    
        double executionTime = bubbleSort.doSort();       
        return executionTime;
    }

}