import java.util.ArrayList;
/**
 * Write a description of class ListOfRoutes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListOfRoutes
{
    private ArrayList<Route> list = new ArrayList<Route>();
    
    /**
     * Makes an array list of all the routes and sees if they are claimed.
     */
    public ListOfRoutes()
    {
        list.add(new Route("Danemark", "Kiel", "Gray", 2, false));
        list.add(new Route("Danemark", "BremerHaven", "Black", 5, false));
        list.add(new Route("Kiel", "BremerHaven", "Gray", 3, false));
        list.add(new Route("Kiel", "Hamburg", "Black", 2, true));
        list.add(new Route("Kiel", "Hamburg", "Purple", 2, true));
        list.add(new Route("Kiel", "Schwerin", "Yellow", 3, false));
        list.add(new Route("Kiel", "Rostock", "Orange", 4, false));
        list.add(new Route("BremerHaven", "Emden", "Gray", 3, false));
        list.add(new Route("BremerHaven", "Bremen", "White", 1, false));
        list.add(new Route("BremerHaven", "Hamburg", "Gray", 3, false));
        list.add(new Route("Hamburg", "Schwerin", "Red", 2, false));
        list.add(new Route("Hamburg", "Berlin", "Blue", 7, true));
        list.add(new Route("Hamburg", "Berlin", "White", 7, true));
        list.add(new Route("Hamburg", "Hannover", "Red", 4, true));
        list.add(new Route("Hamburg", "Hannover", "White", 4, true));
        list.add(new Route("Hamburg", "Bremen", "Orange", 3, false));
        list.add(new Route("Schwerin", "Rostock", "Red", 2, false));
        list.add(new Route("Schwerin", "Berlin", "White", 5, false));
        list.add(new Route("Rostock", "Berlin", "Purple", 6, false));
        list.add(new Route("Berlin", "Hannover", "Yellow", 7, false));
        list.add(new Route("Berlin", "Magdebura", "Red", 3, false));
        list.add(new Route("Berlin", "Leipzia", "Purple", 4, false));
        list.add(new Route("Berlin", "Dresden", "Green", 5, false));
        list.add(new Route("Magdeburg", "Leipzig", "Yellow", 2, false));
        list.add(new Route("Magdeburg", "Hannover", "Blue", 4, false));
        list.add(new Route("Bremen", "Emden", "Blue", 3, false));
        list.add(new Route("Bremen", "Munster", "Black", 3, false));
        list.add(new Route("Bremen", "Hannover", "Yellow", 3, false));
        list.add(new Route("Hannover", "Kassel", "Gray", 3, true));
        list.add(new Route("Hannover", "Kassel", "Gray", 3, true));
        list.add(new Route("Hannover", "Erfut", "Green", 5, true));
        list.add(new Route("Hannover", "Erfut", "Orange", 5, true));
        list.add(new Route("Hannover", "Munster", "Purple", 4, false));
        list.add(new Route("Emden", "Munster", "Red", 4, false));
        list.add(new Route("Emden", "Niederlande", "White", 2, false));
        list.add(new Route("Munster", "Niederlande", "Orange", 2, false));
        list.add(new Route("Munster", "Dortmund", "Gray", 1, true));
        list.add(new Route("Munster", "Dortmund", "Gray", 1, true));
        list.add(new Route("Dusseldorf", "Dortmund", "Gray", 1, true));
        list.add(new Route("Dusseldorf", "Dortmund", "Gray", 1, true));
        list.add(new Route("Dusseldorf", "Dortmund", "Gray", 1, true));
        list.add(new Route("Dusseldorf", "Nierdelande", "Purple", 3, false));
        list.add(new Route("Dusseldorf", "Koln", "Gray", 1, true));
        list.add(new Route("Dusseldorf", "Koln", "Gray", 1, true));
        list.add(new Route("Dusseldorf", "Koln", "Gray", 1, true));
        list.add(new Route("Kassel", "Dortmund", "Green", 4, false));
        list.add(new Route("Kassel", "Erfut", "Gray", 3, false));
        list.add(new Route("Kassel", "Frankfurt", "Blue", 4, true));
        list.add(new Route("Kassel", "Frankfurt", "White", 4, true));
        list.add(new Route("Erfut", "Nurnberg", "Yellow", 4, true));
        list.add(new Route("Erfut", "Nurnberg", "Purple", 4, true));
        list.add(new Route("Erfut", "Leipzig", "Red", 3, false));
        list.add(new Route("Erfut", "Chemnitz", "Black", 4, false));
        list.add(new Route("Erfut", "Regensburg", "White", 7, false));
        list.add(new Route("Leipzig", "Dresden", "Black", 3, false));
        list.add(new Route("Leipzig", "Chemnitz", "Blue", 2, false));
        list.add(new Route("Dresden", "Chemnitz", "Yellow", 1, false));
        list.add(new Route("Dresden", "Regensburg", "Red", 7, false));
        list.add(new Route("Chemnitz", "Regensburg", "Purple", 6, false));
        list.add(new Route("Koln", "Frankfurt", "Gray", 4, true));
        list.add(new Route("Koln", "Frankfurt", "Gray", 4, true));
        list.add(new Route("Koln", "Koblenz", "Gray", 1, true));
        list.add(new Route("Koln", "Koblenz", "Gray", 1, true));
        list.add(new Route("Frankfurt", "Mainz", "Gray", 2, true));
        list.add(new Route("Frankfurt", "Mainz", "Gray", 2, true));
    }
    /*
    public void names(){
        cityNames[0] = "Osterreich";
        cityNames[1] = "Munchen";
        cityNames[2] = "Lindau";
        cityNames[3] = "Konstanz";
        cityNames[4] = "Schweiz";
        cityNames[5] = "Freiburg";
        cityNames[6] = "Franbreich";
        cityNames[7] = "Saarbrucken";
        cityNames[8] = "Karlsruhe";
        cityNames[9] = "Manheim";
        cityNames[10] = "Stuttgart";
        cityNames[11] = "Augsburg";
        cityNames[12] = "Regensburg";
        cityNames[13] = "Nurnberg";
        cityNames[14] = "Wurzburg";
        cityNames[15] = "Frankfurt";
        cityNames[16] = "Mainz";
        cityNames[17] = "Koblenz";
        cityNames[18] = "Koln";
        cityNames[19] = "Dusseldorf";
        cityNames[20] = "Kassel";
        cityNames[21] = "Erfurt";
        cityNames[22] = "Chemnitz";
        cityNames[23] = "Leipzig";
        cityNames[24] = "Dresden";
        cityNames[25] = "Dortmund";
        cityNames[26] = "Munster";
        cityNames[27] = "Magdeburg";
        cityNames[28] = "Berlin";
        cityNames[29] = "Hannover";
        cityNames[30] = "Niederlande";
        cityNames[31] = "Bremen";
        cityNames[32] = "Hamburg";
        cityNames[33] = "Schwerin";
        cityNames[34] = "Bremerhaven";
        cityNames[35] = "Emden";
        cityNames[36] = "Kiel";
        cityNames[37] = "Rostock";
        cityNames[38] = "Danemark";
    }*/
}
