package com.nighthawk.spring_portfolio.mvc.cookies;

// PlayerRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    Optional<PlayerEntity> findById(long id);

    // Custom method for updating player upgrades
    PlayerEntity save(PlayerEntity playerEntity); // Ensure that the save method is present

    default PlayerEntity updatePlayerUpgrades(Long playerId, UpgradeEntity upgrade) {
        Optional<PlayerEntity> optionalPlayer = findById(playerId);

        if (optionalPlayer.isPresent()) {
            PlayerEntity player = optionalPlayer.get();
            player.unlockUpgrade(upgrade);
            return save(player);
        }

        return null; // Handle appropriately if player is not found
    }
}