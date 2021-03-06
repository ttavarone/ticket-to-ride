import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
/**
 * This Class represents Player 2 in the game. It displays the current
 * ticketcards for player 2 if it is their turn.
 * 
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore, 
 * Tom, Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public class PlayerTicketsb extends JPanel implements MouseWheelListener
{
    private Player person;

    private Toolkit toolkit;

    private int currentTrainTicket = 0;
    private int playerNumber = 0;
    private int playerTurn = 0;

    /**
     * This is the constructor for playerticketsb. It sets
     * up the graphics.
     *
     */
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

    /**
     * This method returns the amount of a specified card
     * that the player has.
     * @param cardNumIn - the index of the desired card
     * @return int the amount of the specified card that the
     * the player has
     */
    public int returnAmtCard(int cardNumIn){
        return person.getAmount(cardNumIn);
    }

    /**
     * This method returns the player object of player 2.
     * @return Player player 2
     */
    public Player getPlayer()
    {
        return person;
    }

    /**
     * This method adds a ticket card to the players hand.
     * @param t - the TicketCard to be obtained by player 2
     */
    public void addTicketCard(TicketCard t)
    {
        person.claimTicket(t);
    }
    
    /**
     * This method returns the current trainticket being displayed.
     * @return TicketCard the ticketcard being displayed
     */
    public TicketCard getTrainTicket()
    {
        return person.getTicket(currentTrainTicket);
    }
    
    /**
     * This method sets the current train ticket to a specified number.
     * @param n - the desired number for the current train ticket
     */
    public void setTrainTicket(int n)
    {
        currentTrainTicket = n;
    }
    
    /**
     * This method sets the players turn to either 0 for player 1's turn
     * or 1 for player 2's turn.
     * @param turn - either zero or one
     */
    public void setPlayerTurn(int turn)
    {
        playerTurn = turn;
    }

    /**
     * This method overrides the paintcomponent class in JPanel.
     * It writes "Player 2 Tickets" and then displays player 2's
     * cards of its player 2's turn.
     * @param t - the TicketCard to be obtained by player 2
     */
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
                g.drawImage(person.getTicket(currentTrainTicket).
                    getImage(), 0, 0, this);
            }
        }
        else
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 20, 118);
        }
    }
    
    /**
     * This method checks if the mousewheel was moved, and if so
     * changes what card is displayed.
     * @param e - checks if the mousewheel is moved.
     */
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if(playerTurn == 1)
        {
            if(e.getY() <= 118)
            {
                if(person.claimedTickets() > 1)
                {
                    currentTrainTicket = (currentTrainTicket + 1) 
                        % person.claimedTickets();
                    repaint();
                }
            }
        }
    }
}