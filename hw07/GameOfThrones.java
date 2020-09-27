import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
* Game of Thrones driver class
* @author Not me
* @version 1.0
*/
public class GameOfThrones {

    /**
    * Driver for the Game of Thrones
    * @param args String args default arg
    */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Westeros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);
        frame.add(new Westeros(control)); //defaults to CENTER
        frame.pack();
        frame.setVisible(true);
    }
}