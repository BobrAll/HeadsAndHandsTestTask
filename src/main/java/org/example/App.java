package org.example;

import org.example.creatures.Player;

public class App {
    public static void main( String[] args ) {
        Player p1 = new Player(0,5,1, 6, 10);
        Player p2 = new Player(1,5,1, 6, 10);

        while (p1.isAlive() && p2.isAlive()) {
            p1.hit(p2);
            p2.hit(p1);
            p1.heal();
            p2.heal();
        }
    }
}
