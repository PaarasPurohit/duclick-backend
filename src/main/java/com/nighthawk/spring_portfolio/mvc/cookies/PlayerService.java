package com.nighthawk.spring_portfolio.mvc.cookies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerEntity createNewPlayer() {
        PlayerEntity newPlayer = new PlayerEntity();
        // You can set initial properties for the new player if needed
        return playerRepository.save(newPlayer);
    }

    public PlayerEntity savePlayer(PlayerEntity player) {
        // Implement any additional business logic if needed
        return playerRepository.save(player);
    }

    public PlayerEntity unlockUpgrade(Long playerId, UpgradeEntity upgrade) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(playerId);

        if (optionalPlayer.isPresent()) {
            PlayerEntity player = optionalPlayer.get();
            player.unlockUpgrade(upgrade);
            return playerRepository.save(player);
        }

        return null;
    }

    public PlayerEntity updatePlayerUpgrades(Long playerId, UpgradeEntity upgrade) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(playerId);

        if (optionalPlayer.isPresent()) {
            PlayerEntity player = optionalPlayer.get();
            player.unlockUpgrade(upgrade);
            return playerRepository.save(player);
        }

        return null;
    }

    public PlayerEntity click(Long playerId) {
        PlayerEntity player = getPlayerById(playerId);
        if (player != null) {
            player.click();
            return playerRepository.save(player);
        }
        return null;
    }

    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    public PlayerEntity getPlayerById(Long playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }

    public void upgradeUpgradesForPlayer(Long playerId) {
        PlayerEntity player = getPlayerById(playerId);

        if (player != null) {
            List<UpgradeEntity> upgrades = player.getUnlockedUpgrades();

            for (UpgradeEntity upgrade : upgrades) {
                upgrade.incLevel();
            }

            playerRepository.save(player);
        }
    }

    public int getPlayerScore(Long playerId) {
        PlayerEntity player = getPlayerById(playerId);
        return (player != null) ? player.getScore() : 0;
    }
}
