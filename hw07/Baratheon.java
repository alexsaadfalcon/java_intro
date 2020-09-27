import java.util.Random;
import java.awt.Rectangle;

/**
 * The Baratheon House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public class Baratheon extends SouthHouse {

    /**
    * Instantiates a Baratheon with proper values, words, and image filename
    * @param xPos The initial x Position
    * @param yPos The initial y Position
    * @param bounds The confining bounds of the map
    */
    public Baratheon(int xPos, int yPos, Rectangle bounds) {
        super("stag.png", xPos, yPos, bounds,
            10, 80, 60);
        words = "Ours is the fury";
    }

    /**
    * If a Baratheon can reproduce with another House
    * @param otherHouse The house to compare to
    * @return If this house can reproduce with the other house
    */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Lannister);
    }

    /**
    * Reproduces with another House
    * @param otherHouse The house to reproduce with
    * @return The child house
    */
    public House reproduceWithHouse(House otherHouse) {
        Random gen = new Random();
        if (gen.nextDouble() < .01) { //1% reproduction chance
            return new Baratheon(xPos, yPos, bounds);
        } else {
            return null;
        }
    }

    /**
    * If a Baratheon can harm another House
    * @param otherHouse The house to compare to
    * @return If this house can harm the other house
    */
    public boolean canHarmHouse(House otherHouse) {
        return otherHouse instanceof Targaryan;
    }
}