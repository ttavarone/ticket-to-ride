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
            JFrame frame = new JFrame("Ticket To Ride Board");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setSize(new Dimension(1200, 875));
            frame.setResizable(false);

            frame.getContentPane().add(new Layout());

            frame.pack();
            frame.setVisible(true);
        }

        /**
         * This method creates the GUI that will begin to execute the program.
         *
         * @param args - Command line arguments.
         */
        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }
}
