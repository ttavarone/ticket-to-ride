import java.awt.Color;
/**
 * Enumeration class RouteList - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum RouteList
{
    DANEMARK_KIEL(City.DANEMARK1, City.KIEL, Color.GRAY, 2, false, false, false),
    DANEMARK_BREMERHAVEN(City.DANEMARK2, City.BREMERHAVEN, Color.GREEN, 5, false, false, false),
    KIEL_ROSTOCK(City.KIEL, City.ROSTOCK, Color.ORANGE, 4, false, false, false),
    KIEL_HAMBURG1(City.KIEL, City.HAMBURG, Color.BLACK, 2, false, true, false),
    KIEL_HAMBURG2(City.KIEL, City.HAMBURG, Color.PINK, 2, false, true, false),
    KIEL_BREMERHAVEN(City.KIEL, City.BREMERHAVEN, Color.GRAY, 3, false, true, false),
    KIEL_SCHWERIN(City.KIEL, City.SCHWERIN, Color.YELLOW, 3, false, false, false),
    BREMERHAVEN_EMDEN(City.BREMERHAVEN, City.EMDEN, Color.YELLOW, 3, false, false, false),
    BREMERHAVEN_BREMEN(City.BREMERHAVEN, City.BREMEN, Color.WHITE, 1, false, false, false),
    BREMERHAVEN_HAMBURG(City.BREMERHAVEN, City.HAMBURG, Color.GRAY, 3, false, false, false),
    ROSTOCK_BERLIN(City.ROSTOCK, City.BERLIN, Color.PINK, 6, false, false, false),
    ROSTOCK_SCHWERIN(City.ROSTOCK, City.SCHWERIN, Color.RED, 2, false, false, false),
    HAMBURG_SCHWERIN(City.HAMBURG, City.SCHWERIN, Color.GREEN, 2, false, false, false),
    HAMBURG_HANNOVER1(City.HAMBURG, City.HANNOVER, Color.RED, 4, false, true, false),
    HAMBURG_HANNOVER2(City.HAMBURG, City.HANNOVER, Color.WHITE, 4, false, true, false),
    HAMBURG_BERLIN1(City.HAMBURG, City.BERLIN, Color.BLUE, 7, false, true, false),
    HAMBURG_BERLIN2(City.HAMBURG, City.BERLIN, Color.YELLOW, 7, false, true, false),
    HAMBURG_BREMEN(City.HAMBURG, City.BREMEN, Color.ORANGE, 3, false, false, false),
    SCHWERIN_BERLIN(City.SCHWERIN, City.BERLIN, Color.WHITE, 5, false, false, false),
    EMDEN_NIERDERLANDE(City.EMDEN, City.NIERDERLANDE1, Color.WHITE, 2, false, false, false),
    EMDEN_BREMEN(City.EMDEN, City.BREMEN, Color.BLUE, 3, false, false, false),
    EMDEN_MUNSTER(City.EMDEN, City.MUNSTER, Color.RED, 4, false, false, false),
    BREMEN_HANNOVER(City.BREMEN, City.HANNOVER, Color.YELLOW, 3, false, false, false),
    BREMEN_MUNSTER(City.BREMEN, City.MUNSTER, Color.BLACK, 3, false, false, false),
    MUNSTER_NIERDERLANDE(City.MUNSTER, City.NIERDERLANDE2, Color.ORANGE, 2, false, false, false),
    MUNSTER_DORTMUND1(City.MUNSTER, City.DORTMUND, Color.GRAY, 2, false, true, false),
    //MUNSTER_DORTMUND2(City.MUNSTER, City.DORTMUND, Color.GRAY, 2, false, true, false),
    MUNSTER_HANNOVER(City.MUNSTER, City.HANNOVER, Color.PINK, 4, false, false, false),
    HANNOVER_BERLIN(City.HANNOVER, City.BERLIN, Color.BLACK, 7, false, false, false),
    HANNOVER_KASSEL1(City.HANNOVER, City.KASSEL, Color.GRAY, 3, false, true, false),
    //HANNOVER_KASSEL2(City.HANNOVER, City.KASSEL, Color.GRAY, 3, false, true, false),
    HANNOVER_ERFUT1(City.HANNOVER, City.ERFUT, Color.ORANGE, 5, false, true, false),
    HANNOVER_ERFUT2(City.HANNOVER, City.ERFUT, Color.GREEN, 5, false, true, false),
    HANNOVER_MAGDEBURG(City.HANNOVER, City.MAGDEBURG, Color.BLUE, 4, false, false, false),
    BERLIN_MAGDEBURG(City.BERLIN, City.MAGDEBURG, Color.RED, 3, false, false, false),
    BERLIN_LEIPZIG(City.BERLIN, City.LEIPZIG, Color.ORANGE, 4, false, false, false),
    BERLIN_DRESDEN(City.BERLIN, City.DRESDEN, Color.GREEN, 5, false, false, false),
    MAGDEBURG_LEIPZIG(City.MAGDEBURG, City.LEIPZIG, Color.YELLOW, 2, false, false, false),
    DORTMUND_DUSSELDORF1(City.DORTMUND, City.DUSSELDORF, Color.GRAY, 1, false, true, false),
    //DORTMUND_DUSSELDORF2(City.DORTMUND, City.DUSSELDORF, Color.GRAY, 1, false, true, false),
    //DORTMUND_DUSSELDORF3(City.DORTMUND, City.DUSSELDORF, Color.GRAY, 1, false, true, false),
    DORTMUND_KASSEL(City.DORTMUND, City.KASSEL, Color.GREEN, 4, false, false, false),
    KASSEL_ERFUT(City.KASSEL, City.ERFUT, Color.GRAY, 3, false, false, false),
    KASSEL_FRANKFURT1(City.KASSEL, City.FRANKFURT, Color.BLUE, 4, false, true, false),
    KASSEL_FRANKFURT2(City.KASSEL, City.FRANKFURT, Color.WHITE, 4, false, true, false),
    LEIPZIG_ERFUT(City.LEIPZIG, City.ERFUT, Color.RED, 3, false, false, false),
    LEIPZIG_DRESDEN(City.LEIPZIG, City.DRESDEN, Color.BLACK, 3, false, false, false),
    LEIPZIG_CHEMNITZ(City.LEIPZIG, City.CHEMNITZ, Color.BLUE, 2, false, false, false),
    DRESDEN_CHEMNITZ(City.DRESDEN, City.CHEMNITZ, Color.YELLOW, 1, false, false, false),
    DRESDEN_REGENSBURG(City.DRESDEN, City.REGENSBURG, Color.RED, 7, false, false, false),
    DUSSELDORF_NIERDERLANDE(City.DUSSELDORF, City.NIERDERLANDE3, Color.PINK, 3, false, false, false),
    DUSSELDORF_KOLN1(City.DUSSELDORF, City.KOLN, Color.GRAY, 1, false, false, false),
    //DUSSELDORF_KOLN2(City.DUSSELDORF, City.KOLN, Color.GRAY, 1, false, false, false),
    //DUSSELDORF_KOLN3(City.DUSSELDORF, City.KOLN, Color.GRAY, 1, false, false, false),
    ERFUT_NURNBERG1(City.ERFUT, City.NURNBERG, Color.YELLOW, 4, false, true, false),
    ERFUT_NURNBERG2(City.ERFUT, City.NURNBERG, Color.PINK, 4, false, true, false),
    ERFUT_REGENSBURG(City.ERFUT, City.REGENSBURG, Color.WHITE, 7, false, false, false),
    ERFUT_CHEMNITZ(City.ERFUT, City.CHEMNITZ, Color.BLACK, 4, false, false, false),
    CHEMNITZ_REGENSBURG(City.CHEMNITZ, City.REGENSBURG, Color.PINK, 6, false, false, false),
    KOLN_FRANKFURT1(City.KOLN, City.FRANKFURT, Color.GRAY, 4, false, true, false),
    //KOLN_FRANKFURT2(City.KOLN, City.FRANKFURT, Color.GRAY, 4, false, true, false),
    KOLN_KOBLENZ1(City.KOLN, City.KOBLENZ, Color.GRAY, 1, false, true, false),
    //KOLN_KOBLENZ2(City.KOLN, City.KOBLENZ, Color.GRAY, 1, false, true, false),
    FRANKFURT_WURZBURG1(City.FRANKFURT, City.WURZBURG, Color.GRAY, 2, false, true, false),
    //FRANKFURT_WURZBURG2(City.FRANKFURT, City.WURZBURG, Color.GRAY, 2, false, true, false),
    FRANKFURT_MAINZ1(City.FRANKFURT, City.MAINZ, Color.GRAY, 1, false, true, false),
    //FRANKFURT_MAINZ2(City.FRANKFURT, City.MAINZ, Color.GRAY, 1, false, true, false),
    FRANKFURT_MANNHEIM1(City.FRANKFURT, City.MANNHEIM, Color.GRAY, 2, false, true, false),
    //FRANKFURT_MANNHEIM2(City.FRANKFURT, City.MANNHEIM, Color.GRAY, 2, false, true, false),
    WURZBURG_NURNBERG1(City.WURZBURG, City.NURNBERG, Color.GRAY, 2, false, true, false),
    //WURZBURG_NURNBERG2(City.WURZBURG, City.NURNBERG, Color.GRAY, 2, false, true, false),
    NURNBERG_AUGSBURG(City.NURNBERG, City.AUGSBURG, Color.ORANGE, 4, false, false, false),
    NURNBERG_MUNCHEN1(City.NURNBERG, City.MUNCHEN, Color.BLUE, 5, false, true, false),
    NURNBERG_MUNCHEN2(City.NURNBERG, City.MUNCHEN, Color.BLACK, 5, false, true, false),
    NURNBERG_REGENSBURG(City.NURNBERG, City.REGENSBURG, Color.GREEN, 3, false, false, false),
    KOBLENZ_SAARBRUCKEN(City.KOBLENZ, City.SAARBRUCKEN, Color.GRAY, 3, false, false, false),
    KOBLENZ_MAINZ1(City.KOBLENZ, City.MAINZ, Color.GRAY, 2, false, true, false),
    //KOBLENZ_MAINZ2(City.KOBLENZ, City.MAINZ, Color.GRAY, 2, false, true, false),
    MAINZ_SAARBRUCKEN(City.MAINZ, City.SAARBRUCKEN, Color.GRAY, 3, false, false, false),
    MAINZ_MANNHEIM1(City.MAINZ, City.MANNHEIM, Color.GRAY, 1, false, true, false),
    //MAINZ_MANNHEIM2(City.MAINZ, City.MANNHEIM, Color.GRAY, 1, false, true, false),
    MANNHEIM_SAARBRUCKEN(City.MANNHEIM, City.SAARBRUCKEN, Color.GRAY, 3, false, false, false),
    MANNHEIM_KARLSRUHE(City.MANNHEIM, City.KARLSRUHE, Color.BLUE, 1, false, false, false),
    MANNHEIM_STUTTGART1(City.MANNHEIM, City.STUTTGART, Color.GRAY, 2, false, true, false),
    //MANNHEIM_STUTTGART2(City.MANNHEIM, City.STUTTGART, Color.GRAY, 2, false, true, false),
    SAARBRUCKEN_FRANKREICH(City.SAARBRUCKEN, City.FRANKREICH1, Color.GREEN, 1, false, false, false),
    SAARBRUCKEN_KARLSRUHE(City.SAARBRUCKEN, City.KARLSRUHE, Color.GRAY, 2, false, false, false),
    REGENSBURG_OSTERREICH(City.REGENSBURG, City.OSTERREICH3, Color.YELLOW, 4, false, false, false),
    REGENSBURG_MUNCHEN(City.REGENSBURG, City.MUNCHEN, Color.ORANGE, 3, false, false, false),
    KARLSRUHE_FRANKREICH(City.KARLSRUHE, City.FRANKREICH2, Color.BLACK, 2, false, false, false),
    KARLSRUHE_FREIBURG(City.KARLSRUHE, City.FREIBURG, Color.WHITE, 3, false, false, false),
    KARLSRUHE_STUTTGART(City.KARLSRUHE, City.STUTTGART, Color.PINK, 1, false, false, false),
    STUTTGART_FREIBURG(City.STUTTGART, City.FREIBURG, Color.GRAY, 3, false, false, false),
    STUTTGART_KONSTANZ(City.STUTTGART, City.KONSTANZ, Color.GREEN, 3, false, false, false),
    STUTTGART_ULM1(City.STUTTGART, City.ULM, Color.GRAY, 2, false, true, false),
    //STUTTGART_ULM2(City.STUTTGART, City.ULM, Color.GRAY, 2, false, true, false),
    ULM_LINDAU(City.ULM, City.LINDAU, Color.RED, 2, false, false, false),
    ULM_AUGSBURG1(City.ULM, City.AUGSBURG, Color.GRAY, 1, false, true, false),
    //ULM_AUGSBURG2(City.ULM, City.AUGSBURG, Color.GRAY, 1, false, true, false),
    AUGSBURG_MUNCHEN1(City.AUGSBURG, City.MUNCHEN, Color.GRAY, 2, false, true, false),
    //AUGSBURG_MUNCHEN2(City.AUGSBURG, City.MUNCHEN, Color.GRAY, 2, false, true, false),
    MUNCHEN_LINDAU(City.MUNCHEN, City.LINDAU, Color.GRAY, 5, false, false, false),
    MUNCHEN_OSTERREICH(City.MUNCHEN, City.OSTERREICH2, Color.RED, 3, false, false, false),
    FREIBURG_FRANKREICH(City.FREIBURG, City.FRANKREICH3, Color.YELLOW, 2, false, false, false),
    FREIBURG_SCHWEIZ(City.FREIBURG, City.SCHWEIZ1, Color.ORANGE, 2, false, false, false),
    FREIBURG_KONSTANZ(City.FREIBURG, City.KONSTANZ, Color.BLACK, 2, false, false, false),
    KONSTANZ_SCHWEIZ(City.KONSTANZ, City.SCHWEIZ2, Color.WHITE, 1, false, false, false),
    KONSTANZ_LINDAU(City.KONSTANZ, City.LINDAU, Color.YELLOW, 1, false, false, false),
    LINDAU_SCHWEIZ(City.LINDAU, City.SCHWEIZ3, Color.BLUE, 2, false, false, false),
    LINDAU_OSTERREICH(City.LINDAU, City.OSTERREICH1, Color.PINK, 2, false, false, false),
    ;
    private City CITY1;
    private City CITY2;
    private Color routeColor;
    private int routeLength;
    private boolean routeClaimed = false;
    private boolean doubleRoute;
    private boolean othersClaimed = false;
    
    private RouteList(City c1, City c2, Color col, int length, boolean claimed, boolean dRoute, boolean others)
    {
        CITY1 = c1;
        CITY2 = c2;
        routeColor = col;
        routeLength = length;
        routeClaimed = claimed;
        doubleRoute = dRoute;
        othersClaimed = others;
    }

    public City getCITY1() {
        return CITY1;
    }

    public void setCITY1(City CITY1) {
        this.CITY1 = CITY1;
    }

    public City getCITY2() {
        return CITY2;
    }

    public void setCITY2(City CITY2) {
        this.CITY2 = CITY2;
    }

    public Color getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(Color routeColor) {
        this.routeColor = routeColor;
    }

    public int getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(int routeLength) {
        this.routeLength = routeLength;
    }

    public boolean isRouteClaimed() {
        return routeClaimed;
    }

    public void setRouteClaimed(boolean routeClaimed) {
        this.routeClaimed = routeClaimed;
    }
    
    public boolean isDoubleRoute()
    {
        return doubleRoute;
    }
}
