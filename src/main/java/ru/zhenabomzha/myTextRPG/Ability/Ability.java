package ru.zhenabomzha.myTextRPG.Ability;

public abstract class Ability {

    private final int cooldown;

    public Ability(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }
}
