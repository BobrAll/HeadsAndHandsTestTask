package org.example.creatures;

public class Player extends Creature {
    private final int MAX_HEAL_ATTEMPTS = 4;
    private int healCounter = 0;

    public Player(String name, int attack, int protection, int minDamage, int maxDamage, int maxHealth) {
        super(name, attack, protection, minDamage, maxDamage, maxHealth);
    }

    public void heal() {
        if (healCounter < MAX_HEAL_ATTEMPTS) {
            if (getHealth() == getMaxHealth()) {
                System.out.println("[" + getName() + " already have max health]");
                return;
            }

            int healValue = getMaxHealth() * 30 / 100; //30% of the maximum

            System.out.print("+[" + getName() + " healed from " + getHealth());
            setHealth(getHealth() + healValue);
            System.out.println(" to " + getHealth() + "]");

            healCounter++;
        } else {
            System.out.println("-[" + getName() + " haven't heal attempts]");
        }
    }
}
