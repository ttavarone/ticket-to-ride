import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class EndGamePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGamePanel extends JPanel
{
    PlayerHand[] p;

    public EndGamePanel(PlayerHand[] players)
    {
        p = players;
        setPreferredSize(new Dimension(1200, 875));
    }

    @Override 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        calculateScore(g);
    }

    public void calculateScore(Graphics g)
    {
        Player p1 = p[0].getPlayer();
        Player p2 = p[1].getPlayer();
        g.setFont(new Font("Times New Roman", 0, 30));
        if(p1.getPoints() > p2.getPoints())
        {
            g.drawString("Player 1 Score: " + p1.getPoints(), 30, 50);
            g.drawString("Player 2 Score: " + p2.getPoints(), 30, 100);
        }
        else if(p2.getPoints() > p1.getPoints())
        {
            g.drawString("Player 2 Score: " + p2.getPoints(), 30, 50);
            g.drawString("Player 1 Score: " + p1.getPoints(), 30, 100);
        }
    }
}
