import javax.swing.*;
import java.awt.*;
import java.io.File;

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
    private Toolkit toolkit;

    /**
     * Default constructor, ONLY used to display the backs of ticket cards
     *
     * This is so a user can click on something and then a new ticket card will
     * be initialized
     */
    public TicketCard(){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        START_CITY = END_CITY = LENGTH = null;
        VALUE = 0;
        setPreferredSize(new Dimension(150, 125));
    }

    /**
     * Constructor for objects of class TicketCard
     */
    public TicketCard(String startCity, String endCity, String length, int value, Image i)
    {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        START_CITY = startCity;
        END_CITY = endCity;
        LENGTH = length;
        VALUE = value;
        isRouteComplete = false;
        setPreferredSize(new Dimension(150, 125));
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
        super.paintComponent(g);
    }
}
