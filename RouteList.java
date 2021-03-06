import java.awt.Color;
/**
 * Enumeration class RouteList - This class contains the names of all
 * the routes a player can claim
 * 
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore, 
 * Tom, Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public enum RouteList
{
    DANEMARK_KIEL(City.DANEMARK1, City.KIEL, Color.GRAY, 
        2, false, false),
    DANEMARK_BREMERHAVEN(City.DANEMARK2, City.BREMERHAVEN, Color.GREEN, 
        5, false, false),
    KIEL_ROSTOCK(City.KIEL, City.ROSTOCK, Color.ORANGE, 
        4, false, false),
    KIEL_HAMBURG1(City.KIEL, City.HAMBURG, Color.BLACK, 
        2, false, true),
    KIEL_HAMBURG2(City.KIEL, City.HAMBURG, Color.PINK, 
        2, false, true),
    KIEL_BREMERHAVEN(City.KIEL, City.BREMERHAVEN, Color.GRAY, 
        3, false, true),
    KIEL_SCHWERIN(City.KIEL, City.SCHWERIN, Color.YELLOW, 
        3, false, false),
    BREMERHAVEN_EMDEN(City.BREMERHAVEN, City.EMDEN, Color.YELLOW, 
        3, false, false),
    BREMERHAVEN_BREMEN(City.BREMERHAVEN, City.BREMEN, Color.WHITE, 
        1, false, false),
    BREMERHAVEN_HAMBURG(City.BREMERHAVEN, City.HAMBURG, Color.GRAY, 
        3, false, false),
    ROSTOCK_BERLIN(City.ROSTOCK, City.BERLIN, Color.PINK, 
        6, false, false),
    ROSTOCK_SCHWERIN(City.ROSTOCK, City.SCHWERIN, Color.RED, 
        2, false, false),
    HAMBURG_SCHWERIN(City.HAMBURG, City.SCHWERIN, Color.GREEN, 
        2, false, false),
    HAMBURG_HANNOVER1(City.HAMBURG, City.HANNOVER, Color.RED, 
        4, false, true),
    HAMBURG_HANNOVER2(City.HAMBURG, City.HANNOVER, Color.WHITE, 
        4, false, true),
    HAMBURG_BERLIN1(City.HAMBURG, City.BERLIN, Color.BLUE, 
        7, false, true),
    HAMBURG_BERLIN2(City.HAMBURG, City.BERLIN, Color.YELLOW, 
        7, false, true),
    HAMBURG_BREMEN(City.HAMBURG, City.BREMEN, Color.ORANGE, 
        3, false, false),
    SCHWERIN_BERLIN(City.SCHWERIN, City.BERLIN, Color.WHITE, 
        5, false, false),
    EMDEN_NIERDERLANDE(City.EMDEN, City.NIERDERLANDE1, Color.WHITE, 
        2, false, false),
    EMDEN_BREMEN(City.EMDEN, City.BREMEN, Color.BLUE, 
        3, false, false),
    EMDEN_MUNSTER(City.EMDEN, City.MUNSTER, Color.RED, 
        4, false, false),
    BREMEN_HANNOVER(City.BREMEN, City.HANNOVER, Color.YELLOW, 
        3, false, false),
    BREMEN_MUNSTER(City.BREMEN, City.MUNSTER, Color.BLACK, 
        3, false, false),
    MUNSTER_NIERDERLANDE(City.MUNSTER, City.NIERDERLANDE2, Color.ORANGE, 
        2, false, false),
    MUNSTER_DORTMUND1(City.MUNSTER, City.DORTMUND, Color.GRAY, 
        2, false, true),
    MUNSTER_HANNOVER(City.MUNSTER, City.HANNOVER, Color.PINK, 
        4, false, false),
    HANNOVER_BERLIN(City.HANNOVER, City.BERLIN, Color.BLACK, 
        7, false, false),
    HANNOVER_KASSEL1(City.HANNOVER, City.KASSEL, Color.GRAY, 
        3, false, true),
    HANNOVER_ERFUT1(City.HANNOVER, City.ERFUT, Color.ORANGE, 
        5, false, true),
    HANNOVER_ERFUT2(City.HANNOVER, City.ERFUT, Color.GREEN, 
        5, false, true),
    HANNOVER_MAGDEBURG(City.HANNOVER, City.MAGDEBURG, Color.BLUE, 
        4, false, false),
    BERLIN_MAGDEBURG(City.BERLIN, City.MAGDEBURG, Color.RED, 
        3, false, false),
    BERLIN_LEIPZIG(City.BERLIN, City.LEIPZIG, Color.ORANGE, 
        4, false, false),
    BERLIN_DRESDEN(City.BERLIN, City.DRESDEN, Color.GREEN, 
        5, false, false),
    MAGDEBURG_LEIPZIG(City.MAGDEBURG, City.LEIPZIG, Color.YELLOW, 
        2, false, false),
    DORTMUND_DUSSELDORF1(City.DORTMUND, City.DUSSELDORF, Color.GRAY, 
        1, false, true),
    DORTMUND_KASSEL(City.DORTMUND, City.KASSEL, Color.GREEN, 
        4, false, false),
    KASSEL_ERFUT(City.KASSEL, City.ERFUT, Color.GRAY, 
        3, false, false),
    KASSEL_FRANKFURT1(City.KASSEL, City.FRANKFURT, Color.BLUE, 
        4, false, true),
    KASSEL_FRANKFURT2(City.KASSEL, City.FRANKFURT, Color.WHITE, 
        4, false, true),
    LEIPZIG_ERFUT(City.LEIPZIG, City.ERFUT, Color.RED, 
        3, false, false),
    LEIPZIG_DRESDEN(City.LEIPZIG, City.DRESDEN, Color.BLACK, 
        3, false, false),
    LEIPZIG_CHEMNITZ(City.LEIPZIG, City.CHEMNITZ, Color.BLUE, 
        2, false, false),
    DRESDEN_CHEMNITZ(City.DRESDEN, City.CHEMNITZ, Color.YELLOW, 
        1, false, false),
    DRESDEN_REGENSBURG(City.DRESDEN, City.REGENSBURG, Color.RED, 
        7, false, false),
    DUSSELDORF_NIERDERLANDE(City.DUSSELDORF, City.NIERDERLANDE3, Color.PINK, 
        3, false, false),
    DUSSELDORF_KOLN1(City.DUSSELDORF, City.KOLN, Color.GRAY, 
        1, false, false),
    ERFUT_NURNBERG1(City.ERFUT, City.NURNBERG, Color.YELLOW, 
        4, false, true),
    ERFUT_NURNBERG2(City.ERFUT, City.NURNBERG, Color.PINK, 
        4, false, true),
    ERFUT_REGENSBURG(City.ERFUT, City.REGENSBURG, Color.WHITE, 
        7, false, false),
    ERFUT_CHEMNITZ(City.ERFUT, City.CHEMNITZ, Color.BLACK, 
        4, false, false),
    CHEMNITZ_REGENSBURG(City.CHEMNITZ, City.REGENSBURG, Color.PINK, 
        6, false, false),
    KOLN_FRANKFURT1(City.KOLN, City.FRANKFURT, Color.GRAY, 
        4, false, true),
    KOLN_KOBLENZ1(City.KOLN, City.KOBLENZ, Color.GRAY, 
        1, false, true),
    FRANKFURT_WURZBURG1(City.FRANKFURT, City.WURZBURG, Color.GRAY, 
        2, false, true),
    FRANKFURT_MAINZ1(City.FRANKFURT, City.MAINZ, Color.GRAY, 
        1, false, true),
    FRANKFURT_MANNHEIM1(City.FRANKFURT, City.MANNHEIM, Color.GRAY, 
        2, false, true),
    WURZBURG_NURNBERG1(City.WURZBURG, City.NURNBERG, Color.GRAY, 
        2, false, true),
    NURNBERG_AUGSBURG(City.NURNBERG, City.AUGSBURG, Color.ORANGE, 
        4, false, false),
    NURNBERG_MUNCHEN1(City.NURNBERG, City.MUNCHEN, Color.BLUE, 
        5, false, true),
    NURNBERG_MUNCHEN2(City.NURNBERG, City.MUNCHEN, Color.BLACK, 
        5, false, true),
    NURNBERG_REGENSBURG(City.NURNBERG, City.REGENSBURG, Color.GREEN, 
        3, false, false),
    KOBLENZ_SAARBRUCKEN(City.KOBLENZ, City.SAARBRUCKEN, Color.GRAY, 
        3, false, false),
    KOBLENZ_MAINZ1(City.KOBLENZ, City.MAINZ, Color.GRAY, 
        2, false, true),
    MAINZ_SAARBRUCKEN(City.MAINZ, City.SAARBRUCKEN, Color.GRAY, 
        3, false, false),
    MAINZ_MANNHEIM1(City.MAINZ, City.MANNHEIM, Color.GRAY, 
        1, false, true),
    MANNHEIM_SAARBRUCKEN(City.MANNHEIM, City.SAARBRUCKEN, Color.GRAY, 
        3, false, false),
    MANNHEIM_KARLSRUHE(City.MANNHEIM, City.KARLSRUHE, Color.BLUE, 
        1, false, false),
    MANNHEIM_STUTTGART1(City.MANNHEIM, City.STUTTGART, Color.GRAY, 
        2, false, true),
    SAARBRUCKEN_FRANKREICH(City.SAARBRUCKEN, City.FRANKREICH1, Color.GREEN, 
        1, false, false),
    SAARBRUCKEN_KARLSRUHE(City.SAARBRUCKEN, City.KARLSRUHE, Color.GRAY, 
        2, false, false),
    REGENSBURG_OSTERREICH(City.REGENSBURG, City.OSTERREICH3, Color.YELLOW, 
        4, false, false),
    REGENSBURG_MUNCHEN(City.REGENSBURG, City.MUNCHEN, Color.ORANGE, 
        3, false, false),
    KARLSRUHE_FRANKREICH(City.KARLSRUHE, City.FRANKREICH2, Color.BLACK, 
        2, false, false),
    KARLSRUHE_FREIBURG(City.KARLSRUHE, City.FREIBURG, Color.WHITE, 
        3, false, false),
    KARLSRUHE_STUTTGART(City.KARLSRUHE, City.STUTTGART, Color.PINK, 
        1, false, false),
    STUTTGART_FREIBURG(City.STUTTGART, City.FREIBURG, Color.GRAY, 
        3, false, false),
    STUTTGART_KONSTANZ(City.STUTTGART, City.KONSTANZ, Color.GREEN, 
        3, false, false),
    STUTTGART_ULM1(City.STUTTGART, City.ULM, Color.GRAY, 
        2, false, true),
    ULM_LINDAU(City.ULM, City.LINDAU, Color.RED, 
        2, false, false),
    ULM_AUGSBURG1(City.ULM, City.AUGSBURG, Color.GRAY, 
        1, false, true),
    AUGSBURG_MUNCHEN1(City.AUGSBURG, City.MUNCHEN, Color.GRAY, 
        2, false, true),
    MUNCHEN_LINDAU(City.MUNCHEN, City.LINDAU, Color.GRAY, 
        5, false, false),
    MUNCHEN_OSTERREICH(City.MUNCHEN, City.OSTERREICH2, Color.RED, 
        3, false, false),
    FREIBURG_FRANKREICH(City.FREIBURG, City.FRANKREICH3, Color.YELLOW, 
        2, false, false),
    FREIBURG_SCHWEIZ(City.FREIBURG, City.SCHWEIZ1, Color.ORANGE, 
        2, false, false),
    FREIBURG_KONSTANZ(City.FREIBURG, City.KONSTANZ, Color.BLACK, 
        2, false, false),
    KONSTANZ_SCHWEIZ(City.KONSTANZ, City.SCHWEIZ2, Color.WHITE, 
        1, false, false),
    KONSTANZ_LINDAU(City.KONSTANZ, City.LINDAU, Color.YELLOW, 
        1, false, false),
    LINDAU_SCHWEIZ(City.LINDAU, City.SCHWEIZ3, Color.BLUE, 
        2, false, false),
    LINDAU_OSTERREICH(City.LINDAU, City.OSTERREICH1, Color.PINK, 
        2, false, false),
    ;
    private City CITY1;
    private City CITY2;
    private Color routeColor;
    private int routeLength;
    private boolean routeClaimed = false;
    private boolean doubleRoute;
    
    /**
     * This is a private constructor for creating a route 
     * that players can claim
     * @param c1 - One city in the route.
     * @param c2 - The other city in the route
     * @param col - The color of the route.
     * @param length - how long the route is
     * @param claimed - whether a player owns the route or not
     * @param dRoute - if the route is a double route
     */
    private RouteList(City c1, City c2, Color col, int length, 
    boolean claimed, boolean dRoute)
    {
        CITY1 = c1;
        CITY2 = c2;
        routeColor = col;
        routeLength = length;
        routeClaimed = claimed;
        doubleRoute = dRoute;
    }

    /**
     * This method gets city1 in the route
     * @return - one of the cities in the route
     */
    public City getCITY1() {
        return CITY1;
    }

    /**
     * This method gets city2 in the route
     * @return - one of the cities in the route
     */
    public City getCITY2() {
        return CITY2;
    }

    /**
     * This method gets the color of the route
     * @return - color of the current route
     */
    public Color getRouteColor() {
        return routeColor;
    }

    /**
     * This method gets the length of the route
     * @return - length of the current route
     */
    public int getRouteLength() {
        return routeLength;
    }

    /**
     * This method determines if a player has claimed a route
     * @return - true if a player has claimed the route, false otherwise
     */
    public boolean isRouteClaimed() {
        return routeClaimed;
    }

    /**
     * This method will either set a route to be claimed or 
     * unclaim a route.
     * @param routeClaimed - true if the route is becoming claimed,
     * false if it is being unclaimed.
     */
    public void setRouteClaimed(boolean routeClaimed) {
        this.routeClaimed = routeClaimed;
    }
    
    /**
     * This method determines if a route has two or more different 
     * routes to get between two cities
     * @return - True if moer than one route exists between cities, 
     * false if there is only one route.
     */
    public boolean isDoubleRoute()
    {
        return doubleRoute;
    }
}
