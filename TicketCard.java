
/**
 * Write a description of class TicketCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicketCard
{
    private final String START_CITY, END_CITY, LENGTH;
    private final int VALUE;
    private boolean isRouteComplete;
     
    /**
     * Constructor for objects of class TicketCard
     */
    public TicketCard(String startCity, String endCity, String length, int value)
    {
        START_CITY = startCity;
        END_CITY = endCity;
        LENGTH = length;
        VALUE = value;
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
}