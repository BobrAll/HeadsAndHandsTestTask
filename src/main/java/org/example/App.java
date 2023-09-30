package org.example;

import org.example.creatures.Monster;
import org.example.creatures.Player;

public class App {
    public static void main( String[] args ) {
        Player player = new Player(7,3,1, 6, 10);
        Monster monster = new Monster(10,2,1, 6, 10);

        Tournament.duel(player, monster);

        Tournament.deathmatch(
                new Player(7, 2, 5, 10, 10),
                new Monster(9, 3, 4, 7, 8),
                new Player(8, 2, 5, 7, 9),
                new Monster(8, 1, 3, 5, 7)
        );
    }
}
