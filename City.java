//////////////////////////////////////////////////////////////////////
/**
 * Enumeration class City - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum City
{
    DANEMARK1(0,0),
    DANEMARK2(0,0),
    KIEL(0,0),
    BREMERHAVEN(0,0), 
    BREMEN(0,0),
    EMDEN(0,0),
    NIERDERLANDE1(0,0),
    NIERDERLANDE2(0,0),
    NIERDERLANDE3(0,0),
    MUNSTER(0,0),
    DORTMUND(0,0),
    DUSSELDORF(0,0),
    KOLN(0,0),
    KOBLENZ(0,0),
    SAARBRUCKEN(0,0),
    FRANKREICH1(0,0),
    FRANKREICH2(0,0),
    FRANKREICH3(0,0),
    FREIBURG(0,0),
    SCHWEIZ1(0,0),
    SCHWEIZ2(0,0),
    SCHWEIZ3(0,0),
    LINDAU(0,0),
    OSTERREICH1(0,0),
    ULM(0,0),
    KONSTANZ(0,0),
    STUTTGART(0,0),
    KARLSRUHE(0,0),
    MANNHEIM(0,0),
    MAINZ(0,0),
    FRANKFURT(0,0),
    WURZBURG(0,0),
    NURNBERG(0,0),
    AUGSBURG(0,0),
    MUNCHEN(0,0),
    OSTERREICH2(0,0),
    OSTERREICH3(0,0),
    REGENSBURG(0,0),
    DRESDEN(0,0),
    BERLIN(0,0),
    ROSTOCK(0,0),
    SCHWERIN(0,0),
    HAMBURG(0,0),
    HANNOVER(0,0),
    MAGDEBURG(0,0),
    LEIPZIG(0,0),
    CHEMNITZ(0,0),
    ERFUT(0,0),
    KASSEL(0,0),
    ; 
    private int xCoord;
    private int yCoord;
    private Passenger[] p;
    
    public String getName()
    {
        return name();
    }
    
    public int getX()
    {
        return xCoord;
    }
    
    public int getY()
    {
        return yCoord;
    }
    
    private City(int x, int y)//, Passenger[] newP)
    { 
        xCoord = x;
        yCoord = y;
        //p = newP;
    }
}
