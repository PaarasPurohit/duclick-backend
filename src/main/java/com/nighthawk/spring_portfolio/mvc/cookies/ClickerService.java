package com.nighthawk.spring_portfolio.mvc.cookies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClickerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void saveClicker(ClickerEntity clicker, Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId).orElse(null);

        if (player != null) {
            player.unlockClicker(clicker);
            playerRepository.save(player);
        }
    }

    public List<ClickerEntity> getAllClickers(Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId).orElse(null);
        return (player != null) ? player.getUnlockedClickers() : null;
    }
}