package org.example;

import org.example.creatures.Player;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Player p1 = new Player("Alexander", 10,5,1, 6, 10);
        Player p2 = new Player("Georgiy", 10,5,1, 6, 10);

        while (p1.isAlive() && p2.isAlive()) {
            p1.hit(p2);
            p2.hit(p1);
            p1.heal();
            p2.heal();
        }

        System.out.println("Winner is " + (p1.isAlive()? p1.getName() : p2.getName()) + "!");
    }
}
