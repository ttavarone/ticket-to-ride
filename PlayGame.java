import javax.swing.*;
import javax.swing.border.Border;
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
            //frame.setSize(new Dimension(1200, 875));
            frame.setResizable(false);

            frame.getContentPane().add(new MainPanel());

            //Display the window.
            frame.pack();
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
