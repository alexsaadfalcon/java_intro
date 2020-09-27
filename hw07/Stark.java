import java.util.Random;
import java.awt.Rectangle;

/**
 * The Stark House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public class Stark extends NorthHouse {

    /**
    * Instantiates a Stark with proper values, words, and image filename
    * @param xPos The initial x Position
    * @param yPos The initial y Position
    * @param bounds The confining bounds of the map
    */
    public Stark(int xPos, int yPos, Rectangle bounds) {
        super("direwolf.png", xPos, yPos, bounds,
            10, 70, 80);
        words = "Winter is Coming.";
    }

    /**
    * If a Stark can reproduce with another House
    * @param otherHouse The house to compare to
    * @return If this house can reproduce with the other house
    */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Tully)
            || (otherHouse instanceof Falcon);
    }

    /**
    * Reproduces with another House
    * @param otherHouse The house to reproduce with
    * @return The child house
    */
    public House reproduceWithHouse(House otherHouse) {
        Random gen = new Random();
        if (gen.nextDouble() < .01) { //1% reproduction chance
            return new Stark(xPos, yPos, bounds);
        } else {
            return null;
        }
    }

    /**
    * If a Stark can harm another House
    * @param otherHouse The house to compare to
    * @return If this house can harm the other house
    */
    public boolean canHarmHouse(House otherHouse) {
        Random gen = new Random();
        if (otherHouse instanceof Lannister) {
            return gen.nextDouble() < .4; //40% chance to harm
        } else {
            return false; //0% chance if not Lannister
        }
    }
}