////////////////////////////////////////////////////////////////////////////////
/**
 * Enumeration class City - This is an enum that allows us to create city
 * variables that are useful in claiming routes and hovering over them.
 * 
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore, 
 * Tom Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public enum City
{
    DANEMARK1(246,15),
    DANEMARK2(221,9),
    KIEL(262,84),
    BREMERHAVEN(173,165), 
    BREMEN(176,216),
    EMDEN(72,180),
    NIERDERLANDE3(9,291),
    NIERDERLANDE1(17,241),
    NIERDERLANDE2(31,289),
    MUNSTER(106,319),
    DORTMUND(96,375),
    DUSSELDORF(47,398),
    KOLN(44,453),
    KOBLENZ(55,510),
    SAARBRUCKEN(34,620),
    FRANKREICH1(21,671),
    FRANKREICH2(70,702),
    FRANKREICH3(32,745),
    FREIBURG(112,765),
    SCHWEIZ1(118,835),
    SCHWEIZ2(154,818),
    SCHWEIZ3(174,830),
    LINDAU(244,795),
    OSTERREICH1(321,823),
    ULM(265,717),
    KONSTANZ(193,785),
    STUTTGART(199,671),
    KARLSRUHE(143,660),
    MANNHEIM(147,607),
    MAINZ(125,558),
    FRANKFURT(169,529),
    WURZBURG(251,558),
    NURNBERG(332,582),
    AUGSBURG(317,720),
    MUNCHEN(398,739),
    OSTERREICH2(480,816),
    OSTERREICH3(524,756),
    REGENSBURG(438,645),
    DRESDEN(521,431),
    BERLIN(484,270),
    ROSTOCK(403,88),
    SCHWERIN(353,155),
    HAMBURG(276,165),
    HANNOVER(243,298),
    MAGDEBURG(385,321),
    LEIPZIG(418,394),
    CHEMNITZ(473,454),
    ERFUT(329,442),
    KASSEL(232,408)
    ; 
    private int xCoord;
    private int yCoord;
    //private Passenger[] p;
    
    /**
     * This class returns the name of the current city.
     * @return - name of the city as a string
     */
    public String getName()
    {
        return name();
    }
    
    /**
     * This method gets the x coordinate for the city.
     * @return - x coordinate for determining where the city is
     */
    public int getX()
    {
        return xCoord;
    }
    
    /**
     * This method gets the y coordinate for the city.
     * @return - y coordinate for determining where the city is
     */
    public int getY()
    {
        return yCoord;
    }
    
    /**
     * This is a private constructor for creating a city. Since it
     * is private, other classes can't make new cities.
     * @param x - x coordinate for the city.
     * @param y - y coordinate for the city.
     */
    private City(int x, int y)//, Passenger[] newP)
    { 
        xCoord = x;
        yCoord = y;
        //p = newP;
    }
}
