import java.awt.Rectangle;

/**
 * The abstract South House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public abstract class SouthHouse extends House {

    /**
    * If the House is South on the map
    */
    protected boolean ifSouth;

    /**
    * Instantiates a South House. Passes all parameters to super
    * @param imageFilename The filename of the South House's image
    * @param xPos The x position of the South House
    * @param yPos The y position of the South House
    * @param bounds The bounds on the map a South House is confined to
    * @param damage The damage a South House does in combat
    * @param health The South House's starting health
    * @param maxAge The South House's maximum age
    */
    public SouthHouse(String imageFilename, int xPos, int yPos,
        Rectangle bounds, int damage, int health, int maxAge) {
        super(imageFilename, xPos, yPos, bounds,
            damage, health, maxAge);
        ifSouth = false; //so speed boost will happen if House starts south
    }

    /**
    * Overrides move to give a speed boost in the lower half of the map
    */
    public void move() {
        if (yPos > 300 && !ifSouth) { //if SouthHouse goes south from north
            speed += 25;
            ifSouth = true;
        } else if (yPos <= 300 && ifSouth) { //+y-axis is down, right?
            speed -= 25;
            ifSouth = false;
        }
        super.move();
    }
}