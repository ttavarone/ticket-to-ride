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
public class PlayerTicketsb extends JPanel implements MouseWheelListener
{
    private Player person;

    private Toolkit toolkit;

    private int currentTrainTicket = 0;
    private int playerNumber = 0;
    private int playerTurn = 0;

    public PlayerTicketsb(Player p)
    {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);

        person = p;
        toolkit = Toolkit.getDefaultToolkit();

        playerNumber = p.getPlayerNum();

        addMouseWheelListener(this);
        setPreferredSize(new Dimension(90, 160));
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
        
        g.drawString("Player 2 Tickets", 0, 130);
        g.drawString(person.getPoints() + " points", 0, 140);
        g.drawString(person.getTrainsLeft() + " trains left", 0, 150);
        if(playerTurn == 1)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 20, 118);
            if(person.claimedTickets() > 0)
            {
                g.drawImage(person.getTicket(currentTrainTicket).getImage(), 0, 0, this);
            }
        }
        else
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 20, 118);
        }
    }
    
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if(playerTurn == 1)
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
    }
}