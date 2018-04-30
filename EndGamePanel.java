import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
 * This method creates the JPanel for the board at the end of the game.
 * It will diplay the end game image then say who won based on points,
 * or if it is tied by successful tickets
 *
 * @author (Logan, Tucker, Josh, Eamonn, Tom)
 * @version (4 / 30 / 18)
 */
public class EndGamePanel extends JPanel
{
    protected PlayerHand[] p;
    protected static Icon pic;
    protected Toolkit toolkit = Toolkit.getDefaultToolkit();
    protected JButton j1;
    protected JButton j2;
    protected JButton j3;
    protected String globetrotter;
    
    /**
     * This method draws the panel for the end screen board with 
     * the image and which player won the game.
     */
    public void createAndShowGUI() {
        pic = new ImageIcon("TicketToRidePics"+
            File.separator+"EndScreen.jpg");
        JLabel label = new JLabel(pic);
        JFrame f = new JFrame("End Screen");
        f.setLayout(new BorderLayout());
        f.add(label, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 750);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(new Dimension(1200, 875));
        calculateScore();
        f.add(j1, BorderLayout.WEST);
        f.add(j2, BorderLayout.EAST);
        f.add(j3, BorderLayout.SOUTH);
        f.setResizable(false);
        f.pack();
        f.setVisible(true);
    }

    /**
     * This creates a new endgamepanel object that will display who won.
     * @param players - The players in the game, used to determine who won
     */
    public EndGamePanel(PlayerHand[] players)
    {
        p = players;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    /**
     * This method is used to calculate the final score of the game,
     * by first determining who won globetrotter, then seeing 
     * which player has more points, or more train tickets claimed.
     */
    public void calculateScore()
    {
        Player p1 = p[0].getPlayer();
        Player p2 = p[1].getPlayer();
        if(p1.getSuccessfulTickets() > p2.getSuccessfulTickets())
        {
            p1.addTicketPoints(15);
            globetrotter = "Player 1";
        }
        else if(p2.getSuccessfulTickets() > p1.getSuccessfulTickets())
        {
            p2.addTicketPoints(15);
            globetrotter = "Player 2";
        }
        else
        {
            p1.addTicketPoints(15);
            p2.addTicketPoints(15);
            globetrotter = "Both Players";
        }
        
        if(p1.getPoints() > p2.getPoints())
        {
            j1 = new JButton("Player 1 Score: " + p1.getPoints());
            j2 = new JButton("Player 2 Score: " + p2.getPoints());
            j3 = new JButton("Player 1 Wins! " + globetrotter + 
            " won globetrotter.");
        }
        else if(p2.getPoints() > p1.getPoints())
        {
            j1 = new JButton("Player 1 Score: " + p1.getPoints());
            j2 = new JButton("Player 2 Score: " + p2.getPoints());
            j3 = new JButton("Player 2 Wins! " + globetrotter + 
            " won globetrotter.");
        }
        else if(p1.getSuccessfulTickets() > p2.getSuccessfulTickets())
        {
            j1 = new JButton("Player 1 Score: " + p1.getPoints());
            j2 = new JButton("Player 2 Score: " + p2.getPoints());
            j3 = new JButton("Player 1 Wins! " + globetrotter + 
            " won globetrotter.");
        }
        else if(p2.getSuccessfulTickets() > p1.getSuccessfulTickets())
        {
            j1 = new JButton("Player 1 Score: " + p1.getPoints());
            j2 = new JButton("Player 2 Score: " + p2.getPoints());
            j3 = new JButton("Player 2 Wins! " + globetrotter + 
            " won globetrotter.");
        }
        else
        {
            j1 = new JButton("Player 1 Score: " + p1.getPoints());
            j2 = new JButton("Player 2 Score: " + p2.getPoints());
            j3 = new JButton("It's a Draw! " + globetrotter + 
            " won globetrotter.");
        }
    }
}
