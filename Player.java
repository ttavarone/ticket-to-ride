import java.awt.Color;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    protected int greenMeeple, redMeeple, blueMeeple, blackMeeple, whiteMeeple, yellowMeeple = 0;
    private int numTrains = 3;
    private int playerNum; 
    private Color playerColor;
    private ArrayList<TicketCard> tickets = new ArrayList<TicketCard>();
    private ArrayList<RouteList> controlledRoutes = new ArrayList<RouteList>();
    private int[] amountEachCard = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int points = 0;

    public Player(int playerNumber, Color pColor)
    {
        playerNum = playerNumber;
        playerColor = pColor;
    }

    /**
     * This method attempts to add a route to a player object. Returns 
     * true if it has ot been claimed, false otherwise.
     */
    public void claimRoute(RouteList route, int colorIndex)
    {
        if(route.isRouteClaimed())
        {
            return;
        }
        else
        {
            int rLength = route.getRouteLength();
            controlledRoutes.add(route);
            route.setRouteClaimed(true);
        }
    }
    
    public int getTrainsLeft()
    {
        return numTrains;
    }

    public void claimTicket(TicketCard t)
    {
        tickets.add(t);
    }

    public TicketCard getTicket(int index)
    {
        return tickets.get(index);
    }

    public int claimedTickets()
    {
        return tickets.size();
    }

    public int getPlayerNum()
    {
        return playerNum;
    }

    public void addToHand(TrainCard c){
        int cardNum = c.getCurrentNum();
        amountEachCard[cardNum]++;
    }

    public int getAmount(int numIn)
    {
        return amountEachCard[numIn];
    }

    public int getPoints()
    {
        return points;
    }

    public void addPoints(int length)
    {
        if(length == 1)
        {
            points = points + 1;
        }
        else if(length == 2)
        {
            points = points + 2;
        }
        else if(length == 3)
        {
            points = points + 4;
        }
        else if(length == 4)
        {
            points = points + 7;
        }
        else if(length == 5)
        {
            points = points + 10;
        }
        else if(length == 6)
        {
            points = points + 15;
        }
        else if(length == 7)
        {
            points = points + 18;
        }
        numTrains = numTrains - length;
    }

    public void setAmount(int numIn, int change)
    {
        amountEachCard[numIn] = change;
    }
}
