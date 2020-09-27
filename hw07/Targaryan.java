import java.util.Random;
import java.awt.Rectangle;

/**
 * The Targaryan House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public class Targaryan extends House {

    /**
    * Instantiates a Targaryan with proper values, words, and image filename
    * @param xPos The initial x Position
    * @param yPos The initial y Position
    * @param bounds The confining bounds of the map
    */
    public Targaryan(int xPos, int yPos, Rectangle bounds) {
        super("dragon.png", xPos, yPos, bounds,
            15, 85, Integer.MAX_VALUE);
        //max age is basically unlimited
        words = "Fire and blood";
    }

    /**
    * If a Targaryan can reproduce with another House
    * @param otherHouse The house to compare to
    * @return If this house can reproduce with the other house
    */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Targaryan);
    }

    /**
    * Reproduces with another House
    * @param otherHouse The house to reproduce with
    * @return The child house
    */
    public House reproduceWithHouse(House otherHouse) {
        Random gen = new Random();
        if (gen.nextDouble() < .01) { //1% reproduction chance
            return new Targaryan(xPos, yPos, bounds);
        } else {
            return null;
        }
    }

    /**
    * If a Targaryan can harm another House
    * @param otherHouse The house to compare to
    * @return If this house can harm the other house
    */
    public boolean canHarmHouse(House otherHouse) {
        return !(otherHouse instanceof Baratheon
            || otherHouse instanceof Targaryan);
    }
}