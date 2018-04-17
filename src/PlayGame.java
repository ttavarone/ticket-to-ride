import javax.swing.*;
import java.awt.*;

/**
 * Main class to run the game
 *
 * @author (Logan, Tucker, Josh, Eamonn, Tom)
 * @version (4/8/18)
 */
public class PlayGame
{
        private static void createAndShowGUI() {
            //Create and set up the window.
            JFrame frame = new JFrame("Ticket To Ride Board");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 900);
            frame.setResizable(false);
            BoardPanel bPanel = new BoardPanel();
            frame.getContentPane().add(bPanel);

            //Display the window.
            frame.setVisible(true);
        }

        /**
         * This method creates the GUI that will begin to execute the program.
         *
         * @param args - Command line arguments.
         */
        public static void main(String[] args) {
            //Schedule a job for the event-dispatching thread:
            //creating and showing this application's GUI.

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }
}
