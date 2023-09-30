package org.example.creatures;

import org.example.random.Dice;
import org.example.random.Randomizer;

public abstract class Creature {
    private static final int SUCCESS_HIT_THRESHOLD = 5;
    private static final int ATTACK_MODIFIER_BONUS = 1;
    private static final int MIN_ATTACK_MODIFIER = 1;

    private int attack;
    private int protection;
    private int minDamage;
    private int maxDamage, maxHealth, health;
    private boolean isAlive = true;

    public Creature(int attack, int protection, int minDamage, int maxDamage, int maxHealth) {
        setAttack(attack);
        setProtection(protection);
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);

        setMaxHealth(maxHealth);
        setHealth(maxHealth);
    }

    public void setHealth(int health) {
        this.health = Math.min(health, maxHealth);

        if (this.health <= 0) {
            setAlive(false);
            throw new IllegalStateException("[Creature is died]");
        }
    }

    public void dealDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    protected int calcAttackModifier(int targetProtection) {
        int attackModifier = this.getAttack() - targetProtection + ATTACK_MODIFIER_BONUS;
        return Math.max(attackModifier, MIN_ATTACK_MODIFIER); //must be greater than 1 to try luck at least once
    }

    public void hit(Creature target) {
        boolean isHitSuccessful = false;

        for (int i = 0; i < calcAttackModifier(target.getProtection()); i++)
            if (Dice.roll() >= SUCCESS_HIT_THRESHOLD) {
                isHitSuccessful = true;
                break;
            }

        if (isHitSuccessful) {
            int damage = Randomizer.randomPositiveFromInterval(this.minDamage, this.maxDamage);

            System.out.println("[Damaged " + damage + "hp]");
            target.dealDamage(damage);
        }
        else
            System.out.println("[Miss]");
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 1 || attack > 30)
            throw new IllegalArgumentException("Attack must be in the range [1, 30]");

        this.attack = attack;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        if (protection < 1 || protection > 30)
            throw new IllegalArgumentException("Protection must be in the range [1, 30]");

        this.protection = protection;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
