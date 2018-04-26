import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        Icon icon = new ImageIcon("TicketToRidePics"+File.separator+"ThomasTheTank2.gif");
        JLabel label = new JLabel(icon);
        JFrame f = new JFrame("Ticket to Ride");
        f.setLayout(new BorderLayout());
        f.add(label, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 750);
        f.setLocationRelativeTo(null);

        JButton btnStart = new JButton("Start");
        f.add(btnStart, BorderLayout.SOUTH);
        btnStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                createAndShowGUI();
                            }
                        });
                }
            });
        f.setVisible(true);

    }
}
