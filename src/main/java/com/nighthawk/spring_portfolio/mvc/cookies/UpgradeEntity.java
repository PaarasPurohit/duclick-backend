package com.nighthawk.spring_portfolio.mvc.cookies;

import jakarta.persistence.Entity;

@Entity
public class UpgradeEntity extends ItemEntity {
    private int click_per;
    private int level;
    private float angel_tokens;

    public int getClick_per() {
        return click_per;
    }

    public void setClick_per(int click_per) {
        this.click_per = click_per;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getAngel_tokens() {
        return angel_tokens;
    }

    public void setAngel_tokens(float angel_tokens) {
        this.angel_tokens = angel_tokens;
    }

    public void incLevel() {
        this.level++;
    }
}
