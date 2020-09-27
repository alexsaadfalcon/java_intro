import java.util.Random;
import java.awt.Rectangle;

/**
 * The Lannister House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public class Lannister extends SouthHouse {

    /**
    * Instantiates a Lannister with proper values, words, and image filename
    * @param xPos The initial x Position
    * @param yPos The initial y Position
    * @param bounds The confining bounds of the map
    */
    public Lannister(int xPos, int yPos, Rectangle bounds) {
        super("lion.png", xPos, yPos, bounds,
            10, 70, 50);
        words = "Hear me roar!";
    }

    /**
    * If a Lannister can reproduce with another House
    * @param otherHouse The house to compare to
    * @return If this house can reproduce with the other house
    */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Baratheon)
            || (otherHouse instanceof Lannister); //gross
    }

    /**
    * Reproduces with another House
    * @param otherHouse The house to reproduce with
    * @return The child house
    */
    public House reproduceWithHouse(House otherHouse) {
        Random gen = new Random();
        if (gen.nextDouble() < .01) { //1% reproduction chance
            return new Lannister(xPos, yPos, bounds);
        } else {
            return null;
        }
    }

    /**
    * If a Lannister can harm another House
    * @param otherHouse The house to compare to
    * @return If this house can harm the other house
    */
    public boolean canHarmHouse(House otherHouse) {
        Random gen = new Random();
        if (otherHouse instanceof Stark) {
            return gen.nextDouble() < .6; //60% chance to harm
        } else if (otherHouse instanceof Tully) {
            return gen.nextDouble() < .8; //80% chance
        } else {
            return false; //0% chance if not Stark or Tully
        }
    }
}