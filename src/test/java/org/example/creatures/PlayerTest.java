package org.example.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlayerTest {
    @Test
    public void healingTest() {
        Player player = new Player(1, 1, 1, 1, 10);
        assertEquals(Player.MAX_HEAL_ATTEMPTS, 4);

        player.setHealth(1);
        for (int i = 0; i <= Player.MAX_HEAL_ATTEMPTS; i++) {
            player.heal();
            assertTrue(player.getHealth() <= player.getMaxHealth());
        }
    }
}