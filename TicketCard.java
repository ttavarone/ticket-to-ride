import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class TicketCard here.
 *
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore,
 * Eamonn Conway, Tom Fresenius)
 * @version (1.0)
 */
public class TicketCard extends JPanel
{
    private final String START_CITY, END_CITY, LENGTH;
    private final int VALUE;
    private boolean isRouteComplete;
    private Image i;
     
    /**
     * Constructor for objects of class TicketCard
     */
    public TicketCard(String startCity, String endCity, String length, int value, Image i)
    {
        super();
        START_CITY = startCity;
        END_CITY = endCity;
        LENGTH = length;
        VALUE = value;
        this.i = i;
        isRouteComplete = false;
    }
    
    public void setRouteComplete(){
        isRouteComplete = true;
    }
    
    public String getStartCity(){
        return START_CITY;
    }
    
    public String getEndCity(){
        return END_CITY;
    }
    
    public String getLength(){
        return LENGTH;
    }
    
    public int getValue(){
        return VALUE;
    }

    /**
     * This displays the players current ticket cards
     * @param g graphics object to use
     */
    @Override
    public void paintComponent(Graphics g){

    }
}
