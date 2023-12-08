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

<<<<<<< HEAD
    @GetMapping("/merge")
    public long mergeSort(@RequestParam(name = "list") ArrayList<Integer> toSort) {
        MergeSort mergeSort = new MergeSort(toSort);
        long executionTime = mergeSort.doSort();
=======
    @GetMapping("/merge") // Merge sort get (need to check if arraylist allowed)
    // @RequestParam handles variables binding to frontend, defaults, etc
    public double mergeSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        MergeSort mergeSort = new MergeSort(toSort);    
        double executionTime = mergeSort.doSort(); 
>>>>>>> 7325add7b88213f7546aac8d630576ab9ec7c64c
        return executionTime;
    }
<<<<<<< HEAD

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
=======
    @GetMapping("/insertion") // Insertion Sort @getmapping method
    public double insertionSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        InsertionSort insertionSort = new InsertionSort(toSort);    
        double executionTime = insertionSort.doSort();       
        return executionTime;
    }

    @GetMapping("/bogo") // BogoSort @getmapping method
    public double bogoSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        BogoSort bogoSort = new BogoSort(toSort);    
        double executionTime = bogoSort.doSort();       
        return executionTime;
    }

    @GetMapping("/bubble") // Bubblesort Get mapping method
    public double bubbleSort(@RequestParam(name="toSort") ArrayList<Integer> toSort) {
        BubbleSort bubbleSort = new BubbleSort(toSort);    
        double executionTime = bubbleSort.doSort();       
>>>>>>> 7325add7b88213f7546aac8d630576ab9ec7c64c
        return executionTime;
    }

    // TODO: Test Methods
}