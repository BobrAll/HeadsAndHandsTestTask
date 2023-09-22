package org.example;

import org.example.creatures.Monster;
import org.example.creatures.Player;

public class App {
    public static void main( String[] args ) {
        Player player = new Player(7,5,1, 6, 10);
        Monster monster = new Monster(10,5,1, 6, 10);

        Tournament tournament = new Tournament(player, monster);
        tournament.start();
    }
}
