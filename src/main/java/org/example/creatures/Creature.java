package org.example.creatures;


import org.example.Dice;
import org.example.Randomizer;

public abstract class Creature {
    private static final int SUCCESS_HIT_THRESHOLD = 5;
    private static final int ATTACK_MODIFIER_BONUS = 1;

    private final int attack, protection, minDamage, maxDamage, maxHealth;
    private int health;
    private final String name;
    private boolean isAlive = true;

    public Creature(String name, int attack, int protection, int minDamage, int maxDamage, int maxHealth) {
        this.name = name;
        this.attack = attack;
        this.protection = protection;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;

        this.health = maxHealth;
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, maxHealth);

        if (this.health <= 0) {
            setAlive(false);
            System.out.println("[" + getName() + " is died]");
        }
    }

    public void dealDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    private int calcAttackModifier(int targetProtection) {
        int attackModifier = this.getAttack() - targetProtection + ATTACK_MODIFIER_BONUS;
        return attackModifier > 0? attackModifier : 1; //must be greater than 1 to try luck at least once
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

            System.out.println(
                    String.format("[%s dealt %d damage to %s]",
                            this.getName(),
                            damage,
                            target.getName()
                    )
            );

            target.dealDamage(damage);
        }
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
