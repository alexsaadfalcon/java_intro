import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.*;

/**
 * The Dots class is a GUI which allows the user to add red, green, or blue
 * dots to a black screen. The user chooses the color of the Dot he or she
 * wants to add by pressing either the 1, 2, or 3 key. If the user clicks
 * on a Dot that is currently on the screen, that Dot should be removed
 * from view.
 *
 * The only method that you need to add to is the start method, but you should
 * read the other comments in the code, as they may help you come up with your
 * solution. Note that you must use your SinglyLinkedList class to store the
 * Dots that are currently on the screen. When a user clicks the screen, you
 * first check every Dot in the LinkedList to see if the user clicked on that
 * Dot. If a Dot was clicked, remove that Dot from the screen. If no Dot was
 * clicked, add a new Dot at the location that was clicked. Solutions that
 * do not make use of a linked list in this way will lose points.
 *
 * @author Justin Nieto
 * @version 1.2
 */
public class Dots extends Application {
    /** The height and width of the window (passed into Scene's constructor) */
    public static final int SIZE = 500;

    /** The radius of the dots that appear in the application */
    public static final int DOT_RADIUS = 20;

    /** LinkedList used to store the dots currently on the screen */
    private LinkedList<Dot> dotList;

    /**
     * The current dot color. Whenever a Dot object is made, it will have
     * this as its color. Possible colors for this GUI are red, blue, and green.
     */
    private Color currentColor;

    /**
     * Adding this main method allows us to run the Javafx application from
     * the command line in the usual way ("java Dots"). You should not change
     * this method.
     *
     * @param args command line arguments (this GUI doesn't use any)
     */
    public static void main(String...args) {
        launch(args);
    }

    /**
     * This is the method that handles setting up all of the graphical
     * components of the application, as well as the logic which handles
     * what happens when the user presses a key or clicks the screen.
     *
     * This is the only method that you need to add code to for this file.
     * You are responsible for adding to the application the graphical
     * components (Group, Scene) and the logic necessary for allowing the
     * user to add dots to the screen by clicking on it. At the start of the
     * application, the Dots should be red by default. If at any point the user
     * presses the 1, 2, or 3 keys, the Dot color should be changed to red,
     * blue, or green, respectively. Note that changing the color should only
     * change the color of future Dots added to the screen, not change the
     * color of the Dots that are already on the screen.
     *
     * Clicking on a Dot that already exists should cause the Dot to be removed
     * from the screen.
     *
     * The logic for handling MouseEvents and KeyEvents can be done using
     * a lambda expression.
     *
     * @param stage the window containing the application
     */
    public void start(Stage stage) {
        stage.setTitle("Dots!");

        currentColor = Color.RED;
        dotList = new SinglyLinkedList<>();
        Group group = new Group();
        Scene scene = new Scene(group, SIZE, SIZE);
        scene.setFill(Color.BLACK);

        scene.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                case DIGIT1:
                    currentColor = Color.RED;
                    break;
                case DIGIT2:
                    currentColor = Color.BLUE;
                    break;
                case DIGIT3:
                    currentColor = Color.GREEN;
                    break;
                default:
                    break;
                }
            });

        scene.setOnMouseClicked(event -> {
                double x = event.getX();
                double y = event.getY();
                Dot toAdd = new Dot(x, y);
                boolean dotRemoved = false;
                for (int i = 0; i < dotList.size() && !dotRemoved; i++) {
                    Dot toCheck = dotList.get(i);
                    if (toAdd.contains(toCheck.getCenterX(),
                            toCheck.getCenterY())) {
                        dotList.remove(toCheck);
                        group.getChildren().remove(toCheck);
                        dotRemoved = true;
                    }
                } //Doesn't work because of error I couldnt fix in remove
                if (!dotRemoved) {
                    dotList.add(toAdd);
                    group.getChildren().add(toAdd);
                }
            });
        stage.setTitle("Dots!"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // makes the window visible to the user
    }

    /**
     * The Dot class represents a colored circle which is visible on the
     * GUI. It's basically just a Circle with some added features. None
     * of the code in this class should be altered. Instead, use the code
     * provided here when writing your code to handle adding dots to the
     * screen.
     */
    private class Dot extends Circle {

        /**
         * Constructor for Dot. Instantiates a Dot using currentColor
         * at the given location.
         *
         * @param x the x-location of the Dot in the application
         * @param y the y-location of the Dot in the application
         */
        public Dot(double x, double y) {
            super(x, y, DOT_RADIUS);
            setFill(currentColor);
        }

        /**
         * Given the x and y coordinates of a point in the application,
         * determines whether or not the point is located inside this
         * Dot.
         *
         * @param x the x-location of the point to check
         * @param y the y-location of the point to check
         * @return true if this Dot contains the given point
         */
        public boolean contains(double x, double y) {
            double dx = x - getCenterX();
            double dy = y - getCenterY();
            double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

            return distance <= DOT_RADIUS;
        }

        @Override
        public String toString() {
            return "Dot(" + getCenterX() + "," + getCenterY() + ")";
        }
    }
}
