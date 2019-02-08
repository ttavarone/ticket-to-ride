import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This class exists so that the different panel share some
 * variables and can thus communicate with with each other
 * 
 * @author Logan Brandt, Tom Fressenius, Tucker Tavarone, 
 * Eamonn Conway, Joshua DelSignore 
 * @version 1.0 
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
    //makes it so multiple actions don't happen at the same time.
    protected boolean blockTrainDraw = true;
    protected boolean blockTicketDraw = false;
    protected boolean blockRouteClaim = true;
    //locks out player actions
    protected boolean firstTurn = true;
    protected boolean almostFinalTurn = false;
    protected boolean oneTurnLeft = false;
    protected boolean finalTurn = false;
    protected boolean disableRepaint = false;
    /**
     * An empty constructor that serves the 
     * same purpose as a default constructor.
     */
    public BasePanel(){  }

    /**
     * This method blocks a player from drawing from the deck of train cards. 
     * Used when a player is taking a different action during a turn.
     * @trainDraw - blocks a player from drawing a card if 
     * they are performing
     * another action, or unlocks them if the turn ends or a 
     * route is cancelled.
     */
    public void setBlockTrainDraw(boolean trainDraw)
    {
        blockTrainDraw = trainDraw;
    }

    /**
     * This method blocks a player from drawing from the deck 
     * of ticket cards. 
     * Used when a player is taking a different action during a turn.
     * @ticketDraw - blocks a player from drawing a card 
     * if they are performing
     * another action, or unlocks them if the turn ends 
     * or a route is cancelled.
     */
    public void setBlockTicketDraw(boolean ticketDraw)
    {
        blockTicketDraw = ticketDraw;
    }

    /**
     *  This method sets whether it is the first turn of play. A player
     *  can only draw ticket cards during the first turn of play.
     *  @param first - whether the first turn is happening or over.
     */
    public void setFirstTurn(boolean first)
    {
        firstTurn = first;
    }
}
