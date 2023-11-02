package com.nighthawk.spring_portfolio.mvc.astronomy;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/planet_weights")
@CrossOrigin(origins = "https://paaraspurohit.github.io")
public class PlanetWeightAPIController {

    @GetMapping("/{mass}")
    public PlanetWeightResponse getPlanetWeights(@PathVariable double mass) {
        if (mass <= 0) {
            throw new IllegalArgumentException("Mass must be positive.");
        }

        PlanetWeight planetWeightCalculator = new PlanetWeight();
        ArrayList<Double> weights = planetWeightCalculator.calculatePlanetWeights(mass);
        ArrayList<String> comparisons = planetWeightCalculator.representWeights(weights);

        return new PlanetWeightResponse(weights, comparisons);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return ex.getMessage();
    }

}

class PlanetWeightResponse {
    private List<Double> weights;
    private List<String> comparisons;

    public PlanetWeightResponse(List<Double> weights, List<String> comparisons) {
        this.weights = weights;
        this.comparisons = comparisons;
    }

    public List<Double> getWeights() {
        return weights;
    }

    public List<String> getComparisons() {
        return comparisons;
    }
}
