import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
/**
 * Main class to run the game
 *
 * @author (Logan, Tucker, Josh, Eamonn, Tom)
 * @version (4/8/18)
 */
public class PlayGame
{
    public static enum STATE{MENU, GAME};
    public static STATE state;
    public static volatile boolean value = false;

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
    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame("Ticket To Ride Board");
        state = STATE.MENU;
        if(state == STATE.MENU){
            Title t = null;
            try{
                t = new Title();
            }
            catch(IOException e){
                f.dispose();
            }
        }
        
        while(!value){
            Thread.sleep((long)1000);
        }
        
        if(state == STATE.GAME){
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        createAndShowGUI();
                    }
                });
            
            f.setVisible(true);

        }
    }
}