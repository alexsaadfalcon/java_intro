import java.util.Random;
import java.awt.Rectangle;

/**
 * The custom Falcon House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public class Falcon extends NorthHouse {

    /**
    * Instantiates a Falcon with proper values, words, and image filename
    * @param xPos The initial x Position
    * @param yPos The initial y Position
    * @param bounds The confining bounds of the map
    */
    public Falcon(int xPos, int yPos, Rectangle bounds) {
        super("falcon.png", xPos, yPos, bounds,
            25, 140, 75); //mid-range max age
        this.speed = 100; //Falcons can fly, so they're faster
        words = "FALCON PUNCH";
    }

    /**
    * If a Falcon can reproduce with another House
    * @param otherHouse The house to compare to
    * @return If this house can reproduce with the other house
    */
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse instanceof Stark)
            || (otherHouse instanceof Tully);
    }

    /**
    * Reproduces with another House
    * @param otherHouse The house to reproduce with
    * @return The child house
    */
    public House reproduceWithHouse(House otherHouse) {
        Random gen = new Random();
        if (gen.nextDouble() < .02) { //2% reproduction chance
            return new Falcon(xPos, yPos, bounds);
        } else {
            return null;
        }
    }

    /**
    * If a Falcon can harm another House
    * @param otherHouse The house to compare to
    * @return If this house can harm the other house
    */
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Lannister)
            || (otherHouse instanceof Baratheon)
            || (otherHouse instanceof Targaryan); //Falcon punches never miss
    }
}