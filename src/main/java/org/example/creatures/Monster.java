package org.example.creatures;

public class Monster extends Creature {
    public Monster(int attack, int protection, int minDamage, int maxDamage, int health) {
        super(attack, protection, minDamage, maxDamage, health);
    }

    @Override
    public String toString() {
        return "Monster: [health=" + getHealth() + "]";
    }
}
