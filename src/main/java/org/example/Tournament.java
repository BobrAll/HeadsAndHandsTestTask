package org.example;

import org.example.creatures.Monster;
import org.example.creatures.Player;

public class Tournament {
    Player player;
    Monster monster;

    public Tournament(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void start() {
        System.out.println("Tournament begins!");

        int round = 1;
        while (player.isAlive() && monster.isAlive()) {
            System.out.println(
                    "\nRound #" + round +
                    "\n" + monster +
                    "\n" + player);

            System.out.println("Monster hits player.");
            monster.hit(player);

            System.out.println("Player hits monster.");
            player.hit(monster);

            System.out.println("Player tries to heal.");
            player.heal();

            round++;
        }

        System.out.println("\nTournament is finished!");
        System.out.println("Winner is " + (player.isAlive()? player : monster));
    }
}
