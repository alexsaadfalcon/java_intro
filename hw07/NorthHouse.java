import java.awt.Rectangle;

/**
 * The abstract North House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public abstract class NorthHouse extends House {

    /**
    * If the House is North on the map
    */
    protected boolean ifNorth;

    /**
    * Instantiates a North House. Passes all parameters to super
    * @param imageFilename The filename of the North House's image
    * @param xPos The x position of the North House
    * @param yPos The y position of the North House
    * @param bounds The bounds on the map a North House is confined to
    * @param damage The damage a North House does in combat
    * @param health The North House's starting health
    * @param maxAge The North House's maximum age
    */
    public NorthHouse(String imageFilename, int xPos, int yPos,
        Rectangle bounds, int damage, int health, int maxAge) {
        super(imageFilename, xPos, yPos, bounds,
            damage, health, maxAge);
        ifNorth = false; //so health boost will happen if House starts north
    }

    /**
    * Overrides move the give a healing effect when moving to the North half
    */
    public void move() {
        super.move();
        if (yPos <= 300 && !ifNorth) { //if NorthHouse goes North from South
            health += 20;
        } else if (yPos > 300 && ifNorth) {
            ifNorth = false;
        }
    }
}