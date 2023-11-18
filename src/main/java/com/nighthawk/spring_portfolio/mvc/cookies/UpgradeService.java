package com.nighthawk.spring_portfolio.mvc.cookies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpgradeService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerEntity saveUpgrade(UpgradeEntity upgrade, Long playerId) {
        return playerRepository.updatePlayerUpgrades(playerId, upgrade);
    }

    public List<UpgradeEntity> getAllUpgrades(Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId).orElse(null);
        return (player != null) ? player.getUnlockedUpgrades() : null;
    }
}