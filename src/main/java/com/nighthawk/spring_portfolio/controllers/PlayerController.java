package com.nighthawk.spring_portfolio.controllers;

import com.nighthawk.spring_portfolio.mvc.cookies.PlayerEntity;
import com.nighthawk.spring_portfolio.mvc.cookies.PlayerService;
import com.nighthawk.spring_portfolio.mvc.cookies.UpgradeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<PlayerEntity> createPlayer() {
        PlayerEntity newPlayer = playerService.createNewPlayer();
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerEntity> getPlayerById(@PathVariable Long playerId) {
        PlayerEntity player = playerService.getPlayerById(playerId);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{playerId}/upgrade")
    public ResponseEntity<PlayerEntity> unlockUpgrade(@PathVariable Long playerId, @RequestBody UpgradeEntity upgrade) {
        PlayerEntity updatedPlayer = playerService.unlockUpgrade(playerId, upgrade);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{playerId}/click")
    public ResponseEntity<PlayerEntity> click(@PathVariable Long playerId) {
        PlayerEntity updatedPlayer = playerService.click(playerId);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerEntity>> getAllPlayers() {
        List<PlayerEntity> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}
