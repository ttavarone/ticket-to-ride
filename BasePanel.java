import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Write a description of class BasePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasePanel extends JPanel
{
    protected int currentPlayer = 0;
    protected int totalPlayers = 2;
    protected PlayerHand[] p;
    protected int currentTrainTicket = 0;
    protected TicketDeckPanel tDeck;
    protected DeckOfCardsPanel dPanel;
    protected int ticketsDrawn = 0;
    protected int ticketsTaken = 0;
    protected boolean blockTrainDraw = true;
    protected boolean blockTicketDraw = false;
    protected boolean firstTurn = true;
    
    public BasePanel(){  }
    
    public void setPlayerHand(PlayerHand[] players)
    {
        p = players;
    }
    
    public void setBlockTrainDraw(boolean trainDraw)
    {
        blockTrainDraw = trainDraw;
    }
    
    public void setBlockTicketDraw(boolean ticketDraw)
    {
        blockTicketDraw = ticketDraw;
    }
    
    public void setFirstTurn(boolean first)
    {
        firstTurn = first;
    }
}
