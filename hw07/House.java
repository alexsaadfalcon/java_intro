import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.Random;

/**
 * The abstract House for the Game of Thrones Simulation
 *@author Alex Saad-Falcon
 *@version 1.0
 */
public abstract class House {

    /**
    * The x Position of the House
    */
    protected int xPos;

    /**
    * The y Position of the House
    */
    protected int yPos;

    /**
    * The map bounds a House is confined to
    */
    protected Rectangle bounds;

    /**
    * The damage a house does in combat
    */
    protected int damage;

    /**
    * The House's current health
    */
    protected int health;

    /**
    * The House's current age
    */
    protected int age;

    /**
    * The House's maximum age
    */
    protected int maxAge;

    /**
    * The House's speed of movement
    */
    protected int speed;

    /**
    * The House's motto/words
    */
    protected String words;

    /**
    * The image of a House's crest. What represents the House on the map
    */
    protected ImageIcon image;

    /**
    * The filename of the House's image
    */
    protected String imageFilename;

    /**
    * Instantiates a House object. To be used by subclasses
    * @param imageFilename The filename of the House's image
    * @param xPos The x position of the House
    * @param yPos The y position of the House
    * @param bounds The bounds on the map a House is confined to
    * @param damage The damage a House does in combat
    * @param health The House's starting health
    * @param maxAge The House's maximum age
    */
    public House(String imageFilename, int xPos, int yPos,
        Rectangle bounds, int damage, int health, int maxAge) {
        this.imageFilename = imageFilename;
        image = new ImageIcon(imageFilename);
        this.xPos = xPos;
        this.yPos = yPos;
        this.bounds = bounds;
        this.damage = damage;
        this.health = health;
        this.age = 14; //always start at 14. They start young
        this.maxAge = maxAge;
        this.speed = 50; //speed the same for all, except Falcon
    }

    /**
     * Should draw the House at its location.
     * @param g A Graphics to draw to
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }

    /**
    * Moves a house randomly, a distance from 1 to speed
    * in a random direction
    */
    public void move() {
        Random gen = new Random();
        int r = gen.nextInt(speed + 1); //range [0,speed]
        double th = gen.nextDouble() * 2 * Math.PI; //random angle
        xPos += (int) (r * Math.cos(th));
        yPos += (int) (r * Math.sin(th));
        if (xPos > bounds.getWidth() - image.getIconWidth()) {
            xPos = (int) bounds.getWidth() - image.getIconWidth();
        } else if (xPos < 0) {
            xPos = 0;
        }
        if (yPos > bounds.getHeight() - image.getIconHeight()) {
            yPos = (int) bounds.getHeight() - image.getIconHeight();
        } else if (yPos < 0) {
            yPos = 0;
        }
        health--;
        age++;
    }

    /**
    * Returns if a House is colliding with another House
    * @param otherHouse The other House to test against
    * @return a boolean of if the houses are colliding
    */
    public boolean collidesWithHouse(House otherHouse) {
        return Math.abs(xPos - otherHouse.xPos) <= image.getIconWidth()
            && Math.abs(yPos - otherHouse.yPos) <= image.getIconHeight();
    }

    /**
    * Abstract method. Returns if a house can reproduce with another House
    * @param otherHouse the House to check against
    * @return Whether or not the houses can reproduce
    */
    public abstract boolean canReproduceWithHouse(House otherHouse);

    /**
    * Bastract. Reproduces with with another house
    * @param otherHouse The house to reproduce with
    * @return The child House
    */
    public abstract House reproduceWithHouse(House otherHouse);

    /**
    * Abstract. Returns if a house can harm another house
    * @param otherHouse The house to check against
    * @return If this House can harm the other house, depending on chance
    */
    public abstract boolean canHarmHouse(House otherHouse);

    /**
    * Deals damage to a House from this House
    * @param otherHouse The house to damage
    */
    public void harmHouse(House otherHouse) {
        otherHouse.health -= damage;
    }

    /**
    * Whether or not a house is too old
    * @return Boolean true if too old, false if not
    */
    public boolean isOld() {
        return age > maxAge;
    }

    /**
    * Kills a house. Sets health to 0
    */
    public void die() {
        health = 0;
    }

    /**
    * Whether or not a house is dead.
    * @return true if health is 0 or less, or if too old
    */
    public boolean isDead() {
        return (health <= 0) || (isOld());
    }
}
