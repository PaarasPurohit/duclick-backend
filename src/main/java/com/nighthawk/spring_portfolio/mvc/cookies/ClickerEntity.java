package com.nighthawk.spring_portfolio.mvc.cookies;

import jakarta.persistence.Entity;

@Entity
public class ClickerEntity extends ItemEntity {
    private String rarity;
    private int cp;
    private int cost;

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
