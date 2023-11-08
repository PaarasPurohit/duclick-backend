package com.nighthawk.spring_portfolio.mvc.planet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;

public class PlanetRepository {

    @GetMapping("/{id}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable String id) {
        String description = PlanetDescriptionStorage.getDescription(id);
        if (description != null) {
            return ResponseEntity.ok(new Planet(id, description)); 
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}