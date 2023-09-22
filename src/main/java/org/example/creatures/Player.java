package org.example.creatures;

public class Player extends Creature {
    private final int MAX_HEAL_ATTEMPTS = 4;
    private int healCounter = 0;

    public Player(int attack, int protection, int minDamage, int maxDamage, int maxHealth) {
        super(attack, protection, minDamage, maxDamage, maxHealth);
    }

    public void heal() {
        if (healCounter < MAX_HEAL_ATTEMPTS) {
            if (getHealth() == getMaxHealth()) {
                System.out.println("[already have max health]");
                return;
            }

            int healValue = getMaxHealth() * 30 / 100; //30% of the maximum

            setHealth(getHealth() + healValue);

            healCounter++;
        } else {
            System.out.println("[haven't heal attempts]");
        }
    }
}
