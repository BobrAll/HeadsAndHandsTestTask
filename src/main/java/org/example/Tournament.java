package org.example;

import org.example.creatures.Creature;
import org.example.creatures.Monster;
import org.example.creatures.Player;
import org.example.random.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    public static void deathmatch(Creature... creatures) {
        List<Integer> blackList = new ArrayList<>(creatures.length - 1);
        int winnerId = 0;

        System.out.println("Deathmatch begins!");

        while (blackList.size() != creatures.length - 1) {
            int attackCreatureId, attackedCreatureId;

            attackCreatureId = Randomizer.randomPositiveFromInterval(0, creatures.length, blackList);
            blackList.add(0, attackCreatureId);
            attackedCreatureId = Randomizer.randomPositiveFromInterval(0, creatures.length, blackList);

            System.out.println("\nCreature #" + attackCreatureId + " hits Creature #" + attackedCreatureId);

            Creature attackCreature = creatures[attackCreatureId];
            Creature attackedCreature = creatures[attackedCreatureId];

            try {
                attackCreature.hit(attackedCreature);
            } catch (IllegalStateException e) {
                blackList.add(attackedCreatureId);
                System.out.println("[Creature #" + attackedCreatureId + " died]");
            } finally {
                winnerId = attackCreatureId;
                blackList.remove(0);
            }
        }

        System.out.println("\nDeathmatch finished, winner is Creature #" + winnerId);
    }

    public static void duel(Player player, Monster monster) {
        System.out.println("Duel begins!");

        int round = 1;
        try {
            while (player.isAlive() && monster.isAlive()) {
                System.out.println("\nRound #" + round + "\n" + monster + "\n" + player);

                System.out.println("Monster hits player.");
                monster.hit(player);

                System.out.println("Player hits monster.");
                player.hit(monster);

                System.out.println("Player tries to heal.");
                player.heal();

                round++;
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nDuel finished, winner is " + (player.isAlive()? player : monster));
    }
}
