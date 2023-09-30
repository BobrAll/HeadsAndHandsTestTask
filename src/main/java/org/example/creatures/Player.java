package org.example.creatures;

public class Player extends Creature {
    public final static int MAX_HEAL_ATTEMPTS = 4;
    private int healCounter = 0;

    public Player(int attack, int protection, int minDamage, int maxDamage, int maxHealth) {
        super(attack, protection, minDamage, maxDamage, maxHealth);
    }

    public void heal() {
        if (healCounter < MAX_HEAL_ATTEMPTS) {
            if (getHealth() == getMaxHealth()) {
                System.out.println("[Already have max health]");
                return;
            }

            int healValue = getMaxHealth() * 30 / 100; //30% of the maximum
            setHealth(getHealth() + healValue);

            System.out.println("[Healed to " + getHealth() + " hp]");
            healCounter++;
        } else {
            System.out.println("[Haven't heal attempts]");
        }
    }

    @Override
    public String toString() {
        return "Player:  [" +
                "health=" + getHealth() +
                ", heal attempts=" + (MAX_HEAL_ATTEMPTS - healCounter) + "/" + MAX_HEAL_ATTEMPTS +
                ']';
    }
}
