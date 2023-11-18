package com.nighthawk.spring_portfolio.mvc.cookies;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ClickerEntity> unlockedClickers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UpgradeEntity> unlockedUpgrades;

    @ManyToOne(cascade = CascadeType.ALL)
    private ClickerEntity currentClicker;

    private int score;

    public PlayerEntity() {
        this.unlockedClickers = new ArrayList<>();
        this.unlockedUpgrades = new ArrayList<>();
        this.currentClicker = null;
        this.score = 0;

        // Initialize player with some upgrades and clickers
        initPlayer();
    }

    private void initPlayer() {
        // Example upgrades
        UpgradeEntity upgrade1 = new UpgradeEntity();
        upgrade1.setName("Upgrade 1");
        upgrade1.setDescription("Increase click power");
        upgrade1.setClick_per(2);
        upgrade1.setAngel_tokens(1.0f);

        UpgradeEntity upgrade2 = new UpgradeEntity();
        upgrade2.setName("Upgrade 2");
        upgrade2.setDescription("Double click power");
        upgrade2.setClick_per(4);
        upgrade2.setAngel_tokens(2.0f);

        // Example clickers
        ClickerEntity clicker1 = new ClickerEntity();
        clicker1.setName("Clicker 1");
        clicker1.setDescription("Common clicker");
        clicker1.setRarity("Common");
        clicker1.setCp(1);
        clicker1.setCost(10);

        ClickerEntity clicker2 = new ClickerEntity();
        clicker2.setName("Clicker 2");
        clicker2.setDescription("Rare clicker");
        clicker2.setRarity("Rare");
        clicker2.setCp(3);
        clicker2.setCost(25);

        // Unlock upgrades and clickers
        unlockUpgrade(upgrade1);
        unlockUpgrade(upgrade2);

        unlockClicker(clicker1);
        unlockClicker(clicker2);
    }

    public void unlockClicker(ClickerEntity clicker) {
        this.unlockedClickers.add(clicker);

        if (this.currentClicker == null) {
            this.currentClicker = clicker;
        }
    }

    public void unlockUpgrade(UpgradeEntity upgrade) {
        this.unlockedUpgrades.add(upgrade);
    }

    public void upgradeUpgrades() {
        for (UpgradeEntity upgrade : unlockedUpgrades) {
            upgrade.incLevel();
        }
    }

    public void click() {
        int clickValue = (currentClicker != null) ? currentClicker.getCp() : 1;
        score += clickValue;
    }

    public List<ClickerEntity> getUnlockedClickers() {
        return unlockedClickers;
    }

    public List<UpgradeEntity> getUnlockedUpgrades() {
        return unlockedUpgrades;
    }

    public int getScore() {
        return score;
    }

    public ClickerEntity getCurrentClicker() {
        return currentClicker;
    }

    public void setCurrentClicker(ClickerEntity currentClicker) {
        this.currentClicker = currentClicker;
    }

    public void addUpgrade(UpgradeEntity upgrade) {
        this.unlockedUpgrades.add(upgrade);
    }
}
