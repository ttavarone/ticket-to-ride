import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
/**
 * Write a description of class PlayerTickets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTickets extends JPanel implements MouseWheelListener
{
    private Player person;

    private Toolkit toolkit;

    private int currentTrainTicket = 0;
    private int playerNumber = 0;
    private int playerTurn = 0;

    public PlayerTickets(Player p)
    {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);

        person = p;
        toolkit = Toolkit.getDefaultToolkit();

        playerNumber = p.getPlayerNum();

        setPreferredSize(new Dimension(80, 485));
    }

    public int returnAmtCard(int cardNumIn){
        return person.getAmount(cardNumIn);
    }

    public Player getPlayer()
    {
        return person;
    }

    public void addTicketCard(TicketCard t)
    {
        person.claimTicket(t);
    }
    
    public TicketCard getTrainTicket()
    {
        return person.getTicket(currentTrainTicket);
    }
    
    public void setTrainTicket(int n)
    {
        currentTrainTicket = n;
    }
    
    public void setPlayerTurn(int turn)
    {
        playerTurn = turn;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(person.getPlayerNum() == 0 && playerTurn == 0)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 20, 118);
            if(person.claimedTickets() > 0)
            {
                g.drawImage(person.getTicket(currentTrainTicket).getImage(), 0, 118, this);
            }
        }
        else
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 118, 20, 118);
            if(person.claimedTickets() > 0)
            {
                g.drawImage(person.getTicket(currentTrainTicket).getImage(), 0, 0, this);
            }
        }

        g.drawString("Player Tickets", 0, 385);
    }
    
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if(playerNumber == 0 && playerNumber == playerTurn)
        {
            if(e.getY() <= 118)
            {
                if(person.claimedTickets() > 1)
                {
                    currentTrainTicket = (currentTrainTicket + 1) % person.claimedTickets();
                    repaint();
                }
            }
        }
        else
        {
            if(e.getY() > 118 && e.getY() <= 236)
            {
                if(person.claimedTickets() > 1)
                {
                    currentTrainTicket = (currentTrainTicket + 1) % person.claimedTickets();
                    repaint();
                }
            }
        }
    }
}
