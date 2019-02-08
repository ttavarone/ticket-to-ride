import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * TicketCard class creates an object called TicketCard.
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
    private Image currentImage;

    /**
     * Default constructor, ONLY used to display the backs of ticket cards
     *
     * This is so a user can click on something and
     * then a new ticket card will
     * be initialized
     */
    public TicketCard(){
        START_CITY = END_CITY = LENGTH = null;
        VALUE = 0;
        currentImage = null;
    }

    /**
     * Constructor for objects of class TicketCard
     *
     *@param START_CITY is the starting city for the TicketCard
     *@param END_CITY is the ending city for the TicketCard
     *@param LENGTH represents whether the TicketCard 
     *  is a short or long route
     *@param value represents the points the card holds.
     *@param image for a TicketCard
     * 
     */
    public TicketCard(String startCity, String endCity, 
    String length, int value, Image i)
    {
        START_CITY = startCity;
        END_CITY = endCity;
        LENGTH = length;
        VALUE = value;
        isRouteComplete = false;
        currentImage = i;
    }
    
    /**
    *@return the image from the TicketCard object
    */
    public Image getImage()
    {
        return currentImage;
    }
    
    /**
    * Sets the image from the TicketCard object
    * @see image of the TicketCard
    */
    public void setImage(Image i)
    {
        currentImage = i;
    }
    
    /**
    * Sets the boolean isRouteComplete to true for a TicketCard
    */
    public void setRouteComplete(){
        isRouteComplete = true;
    }
    
    /**
    *@return the Starting City of TicketCard
    */
    public String getStartCity(){
        return START_CITY;
    }
    
    /**
    *@return the Ending City of TicketCard
    */
    public String getEndCity(){
        return END_CITY;
    }
    
    /**
    * @return the length of TicketCard, short or long
    */
    public String getLength(){
        return LENGTH;
    }
    
    /**
    *@return the point value of TicketCard
    */
    public int getValue(){
        return VALUE;
    }
    
    /**
    * Returns whether or not the object contains a country. 
    * True if yes, false if no
    *@return boolean
    */
    public boolean containsCountry()
    {
        if(END_CITY.equals("DANEMARK") || END_CITY.equals("FRANKREICH") 
        || END_CITY.equals("OSTERREICH")
        || END_CITY.equals("NIERDERLANDE") || END_CITY.equals("SCHWEIZ"))
        {
            return true;
        }
        if(START_CITY.equals("DANEMARK") || START_CITY.equals("FRANKREICH") 
        || START_CITY.equals("OSTERREICH")
        || START_CITY.equals("NIERDERLANDE") || START_CITY.equals("SCHWEIZ"))
        {
            return true;
        }
        return false;
    }
}
