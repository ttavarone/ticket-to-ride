
/**
 * Write a description of class Route here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route
{
    private final String CITY1;
    private final String CITY2;
    private String routeColor;
    private int routeLength;
    private boolean routeClaimed = false;
    private boolean doubleRoute;
    private boolean othersClaimed = false;
    
    public Route(String c1, String c2, String rColor, int rLength, boolean dRoute)
    {
        CITY1 = c1;
        CITY2 = c2; 
        routeColor = rColor;
        routeLength = rLength;
        doubleRoute = dRoute;
    }
}
