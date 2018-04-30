import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
 * Write a description of class EndGamePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGamePanel extends JPanel
{
    PlayerHand[] p;
    protected static Icon pic;
    protected Toolkit toolkit = Toolkit.getDefaultToolkit();
    protected JButton j1;
    protected JButton j2;
    protected JButton j3;
    
    public void createAndShowGUI() {
        pic = new ImageIcon("TicketToRidePics"+File.separator+"EndScreen.jpg");
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

    public EndGamePanel(PlayerHand[] players)
    {
        p = players;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    public void calculateScore()
    {
        Player p1 = p[0].getPlayer();
        Player p2 = p[1].getPlayer();
        if(p1.getPoints() > p2.getPoints())
        {
            j1 = new JButton("Player 1 Score: " + p1.getPoints());
            j2 = new JButton("Player 2 Score: " + p2.getPoints());
            j3 = new JButton("Player 1 Wins!");
        }
        else if(p2.getPoints() > p1.getPoints())
        {
            j1 = new JButton("Player 2 Score: " + p2.getPoints());
            j2 = new JButton("Player 1 Score: " + p1.getPoints());
            j3 = new JButton("Player 2 Wins!");
        }
        else if(p1.claimedTickets() > p2.claimedTickets())
        {
            j1 = new JButton("Player 2 Score: " + p2.getPoints());
            j2 = new JButton("Player 1 Score: " + p1.getPoints());
            j3 = new JButton("Player 2 Wins!");
        }
        else if(p2.claimedTickets() > p1.claimedTickets())
        {
            j1 = new JButton("Player 2 Score: " + p2.getPoints());
            j2 = new JButton("Player 1 Score: " + p1.getPoints());
            j3 = new JButton("Player 2 Wins!");
        }
        else
        {
            j1 = new JButton("Player 2 Score: " + p2.getPoints());
            j2 = new JButton("Player 1 Score: " + p1.getPoints());
            j3 = new JButton("It's a Draw!");
        }
    }
}
