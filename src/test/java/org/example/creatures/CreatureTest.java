package org.example.creatures;

import org.example.exceptions.CreatureDiedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreatureTest {

    @Test
    public void deathTest() {
        Creature monster = new Monster(1, 1, 1, 1, 10);

        Throwable thrown = assertThrows(CreatureDiedException.class, () -> monster.setHealth(0));
        assertNotNull(thrown.getMessage());

        thrown = assertThrows(CreatureDiedException.class, () -> monster.setHealth(-1));
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void dealDamageTest() {
        Creature monster = new Monster(1, 1, 1, 1, 10);
        Throwable thrown = assertThrows(CreatureDiedException.class, () -> monster.dealDamage(monster.getMaxHealth()));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void setProtectionTest() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> new Monster(1, 100, 1, 1, 1));
        assertNotNull(thrown.getMessage());

        Creature monster = new Monster(1, 1, 1, 1, 1);

        thrown = assertThrows(IllegalArgumentException.class,  () -> monster.setProtection(31));
        assertNotNull(thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class,  () -> monster.setProtection(0));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void setAttackTest() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> new Monster(100, 1, 1, 1, 1));
        assertNotNull(thrown.getMessage());

        Creature monster = new Monster(1, 1, 1, 1, 1);

        thrown = assertThrows(IllegalArgumentException.class,  () -> monster.setAttack(31));
        assertNotNull(thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class,  () -> monster.setAttack(0));
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void healthTest() {
        Creature player = new Player(1, 1, 1, 1, 10);

        player.setHealth(player.getMaxHealth() * 2);
        assertEquals(player.getHealth(), player.getMaxHealth());
    }

    @Test
    void calcAttackModifierTest() {
        Creature player = new Player(1, 1, 1, 1, 1);
        assertEquals(player.calcAttackModifier(Integer.MAX_VALUE), 1);
    }
}