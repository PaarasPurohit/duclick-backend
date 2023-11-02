package com.nighthawk.spring_portfolio.mvc.astronomy;

import java.util.ArrayList;

public class PlanetWeight {

    private final double mercuryGravity = 3.7;
    private final double venusGravity = 8.87;
    private final double earthGravity = 9.81;
    private final double marsGravity = 3.721;
    private final double jupiterGravity = 24.79;
    private final double saturnGravity = 10.44;
    private final double uranusGravity = 8.69;
    private final double neptuneGravity = 11.15;
    private final double moonGravity = 1.625;
    private final double plutoGravity = 0.62;

    public ArrayList<Double> calculatePlanetWeights(double mass) {
        if (mass <= 0) {
            throw new IllegalArgumentException("Mass must be positive.");
        }

        ArrayList<Double> weights = new ArrayList<Double>();

        weights.add(mass * mercuryGravity);
        weights.add(mass * venusGravity);
        weights.add(mass * earthGravity);
        weights.add(mass * marsGravity);
        weights.add(mass * jupiterGravity);
        weights.add(mass * saturnGravity);
        weights.add(mass * uranusGravity);
        weights.add(mass * neptuneGravity);
        weights.add(mass * moonGravity);
        weights.add(mass * plutoGravity);

        return weights;
    }

    public ArrayList<String> representWeights(ArrayList<Double> weights) {
        ArrayList<String> comparisons = new ArrayList<String>();
    
        for (double i : weights) {
            if (i >= 0 && i <= 50) {
                comparisons.add("A bag of dog food");
            } else if (i > 50 && i <= 100) {
                comparisons.add("A standard adult bicycle");
            } else if (i > 100 && i <= 150) {
                comparisons.add("A large microwave oven");
            } else if (i > 150 && i <= 200) {
                comparisons.add("A typical adult male");
            } else if (i > 200 && i <= 250) {
                comparisons.add("A full-sized refrigerator");
            } else if (i > 250 && i <= 300) {
                comparisons.add("A grand piano");
            } else if (i > 300 && i <= 350) {
                comparisons.add("A vending machine");
            } else if (i > 350 && i <= 400) {
                comparisons.add("A small motorcycle");
            } else if (i > 400 && i <= 450) {
                comparisons.add("A black bear (average weight)");
            } else if (i > 450 && i <= 500) {
                comparisons.add("A full-grown male lion (average weight)");
            } else if (i > 500 && i <= 550) {
                comparisons.add("A large motorcycle");
            } else if (i > 550 && i <= 600) {
                comparisons.add("A grand piano + a large microwave oven");
            } else if (i > 600 && i <= 650) {
                comparisons.add("A vending machine + a small motorcycle");
            } else if (i > 650 && i <= 700) {
                comparisons.add("A black bear (average weight) + a bag of dog food");
            } else if (i > 700 && i <= 750) {
                comparisons.add("A full-grown male lion (average weight) + a standard adult bicycle");
            } else if (i > 750 && i <= 800) {
                comparisons.add("Two bags of dog food");
            } else if (i > 800 && i <= 850) {
                comparisons.add("A grand piano + a large microwave oven + a bag of dog food");
            } else if (i > 850 && i <= 900) {
                comparisons.add("A typical adult male + a full-sized refrigerator");
            } else if (i > 900 && i <= 950) {
                comparisons.add("Three bags of dog food");
            } else if (i > 950 && i <= 1000) {
                comparisons.add("Two full-grown male lions (average weight)");
            } else {
                comparisons.add("Wow, just... wow.");
            }
        }
        return comparisons;
    }       
}
