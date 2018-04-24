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
    private int numTrains = 45;
    private int playerNum; 
    private Color playerColor;
    private ArrayList<RouteList> controlledRoutes = new ArrayList<RouteList>();
    
    public Player(int playerNumber, Color pColor)
    {
        playerNum = playerNumber;
        playerColor = pColor;
    }
    
    /**
     * This method attempts to add a route to a player object. Returns 
     * true if it has ot been claimed, false otherwise.
     */
    public boolean claimRoute(RouteList route)
    {
        if(route.isRouteClaimed())
        {
            return false;
        }
        else
        {
            controlledRoutes.add(route);
            return true;
        }
    }
    
    public int getPlayerNum()
    {
        return playerNum;
    }
}
