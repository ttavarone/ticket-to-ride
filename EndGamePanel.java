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
    protected Toolkit toolkit = Toolkit.getDefaultToolkit();;

    public static void createAndShowGUI() {
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

    @Override 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        calculateScore(g);
    }

    public void calculateScore(Graphics g)
    {
        Player p1 = p[0].getPlayer();
        Player p2 = p[1].getPlayer();
        g.setFont(new Font("Times New Roman", 10, 50));
        if(p1.getPoints() > p2.getPoints())
        {
            g.drawString("Player 1 Score: " + p1.getPoints(), 400, 250);
            g.drawString("Player 2 Score: " + p2.getPoints(), 400, 400);
            g.drawString("Player 1 Wins!", 400, 100);
        }
        else if(p2.getPoints() > p1.getPoints())
        {
            g.drawString("Player 2 Score: " + p2.getPoints(), 400, 250);
            g.drawString("Player 1 Score: " + p1.getPoints(), 400, 400);
            g.drawString("Player 2 Wins!", 400, 100);
        }
        else if(p1.claimedTickets() > p2.claimedTickets())
        {
            g.drawString("Player 1 Score: " + p1.getPoints(), 400, 250);
            g.drawString("Player 2 Score: " + p2.getPoints(), 400, 400);
            g.drawString("Player 1 Wins!", 400, 100);
        }
        else if(p2.claimedTickets() > p1.claimedTickets())
        {
            g.drawString("Player 2 Score: " + p2.getPoints(), 400, 250);
            g.drawString("Player 1 Score: " + p1.getPoints(), 400, 400);
            g.drawString("Player 1 Wins!", 400, 100);
        }
        else
        {
            g.drawString("Player 1 Score: " + p1.getPoints(), 400, 250);
            g.drawString("Player 2 Score: " + p2.getPoints(), 400, 400);
            g.drawString("It's a Draw!", 400, 100);
        }
    }
}
