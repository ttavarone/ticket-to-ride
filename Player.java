import java.awt.Color;
import java.util.ArrayList;
/**
 * This class contains a player in the game, and the variables they contain.
 * 
 * @author Logan Brandt, Tom Fressenius, Tucker Tavarone, 
 * Eamonn Conway, Joshua DelSignore 
 * @version 1.0
 */
public class Player
{
    protected int greenMeeple, redMeeple, blueMeeple, blackMeeple, whiteMeeple, yellowMeeple = 0;
    private int numTrains = 3;
    private int playerNum; 
    private Color playerColor;
    private ArrayList<TicketCard> tickets = new ArrayList<TicketCard>();
    private ArrayList<RouteList> controlledRoutes = new ArrayList<RouteList>();
    private int[] amountEachCard = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int points = 0;
    public int successfulTickets;

    /**
     * This is a constuctor that assigns a number and color
     * to be associated with a player.
     * @param playerNumber - The number the player is.
     * @param pColor - The color associated with a player.
     */
    public Player(int playerNumber, Color pColor)
    {
        playerNum = playerNumber;
        playerColor = pColor;
    }

    /**
     * This method attempts to add a route to a player object. 
     * @param route - The route to add to the players controlled routes.
     */
    public void claimRoute(RouteList route)
    {
        if(route.isRouteClaimed())
        {
            return;
        }
        else
        {
            int rLength = route.getRouteLength();
            controlledRoutes.add(route);
            route.setRouteClaimed(true);
        }
    }
    
    public ArrayList<RouteList> getRouteList()
    {
        return controlledRoutes;
    }

    public int getTrainsLeft()
    {
        return numTrains;
    }
    
    public Color getPlayerColor()
    {
        return playerColor;
    }

    public void claimTicket(TicketCard t)
    {
        tickets.add(t);
    }

    public TicketCard getTicket(int index)
    {
        return tickets.get(index);
    }

    public int claimedTickets()
    {
        return tickets.size();
    }

    public int getPlayerNum()
    {
        return playerNum;
    }

    public void addToHand(TrainCard c){
        int cardNum = c.getCurrentNum();
        amountEachCard[cardNum]++;
    }

    public int getAmount(int numIn)
    {
        return amountEachCard[numIn];
    }

    public int getPoints()
    {
        return points;
    }

    public void addPoints(int length)
    {
        if(length == 1)
        {
            points = points + 1;
        }
        else if(length == 2)
        {
            points = points + 2;
        }
        else if(length == 3)
        {
            points = points + 4;
        }
        else if(length == 4)
        {
            points = points + 7;
        }
        else if(length == 5)
        {
            points = points + 10;
        }
        else if(length == 6)
        {
            points = points + 15;
        }
        else if(length == 7)
        {
            points = points + 18;
        }
        numTrains = numTrains - length;
    }

    public void setAmount(int numIn, int change)
    {
        amountEachCard[numIn] = change;
    }

    public int calculateFinalScore()
    {
        boolean ticketComplete;
        for(int i = 0; i < tickets.size(); i++)
        {
            ticketComplete = false;
            ArrayList<RouteList> controlled = copy(controlledRoutes);
            ArrayList<City> citiesUsed = new ArrayList<City>();
            ArrayList<String> cityNames = new ArrayList<String>();
            TicketCard t = tickets.get(i);
            cityNames.add(t.getStartCity().toUpperCase());
            cityNames.add(t.getEndCity().toUpperCase());
            if(t.containsCountry())
            {
                addCityNames(cityNames);
            }
            print(cityNames);
            if(ticketPath(cityNames, controlled, citiesUsed))
            {
                points = points + t.getValue();
                successfulTickets++;
                System.out.println("Ticket successful");
            }
            else
            {
                points = points - t.getValue();
                System.out.println("Ticket unsuccessful");
            }
        }
        return points;
    }

    public void addCityNames(ArrayList<String> cities)
    {
        for(int i = 0; i < 2; i++)
        {
            if(cities.get(i).equals("DANEMARK"))
            {
                cities.remove(i);
                cities.add(1, "DANEMARK1");
                cities.add(1, "DANEMARK2");
                i--;
            }
            else if(cities.get(i).equals("FRANKREICH"))
            {
                cities.remove(i);
                cities.add(1, "FRANKREICH1");
                cities.add(1, "FRANKREICH2");
                cities.add(1, "FRANKREICH3");
                i--;
            }
            else if(cities.get(i).equals("OSTERREICH"))
            {
                cities.remove(i);
                cities.add(1, "OSTERREICH1");
                cities.add(1, "OSTERREICH2");
                cities.add(1, "OSTERREICH3");
                i--;
            }
            else if(cities.get(i).equals("SCHWEIZ"))
            {
                cities.remove(i);
                cities.add(1, "SCHWEIZ1");
                cities.add(1, "SCHWEIZ2");
                cities.add(1, "SCHWEIZ3");
                i--;
            }
            else if(cities.get(i).equals("NIERDERLANDE"))
            {
                cities.remove(i);
                cities.add(1, "NIERDERLANDE1");
                cities.add(1, "NIERDERLANDE2");
                cities.add(1, "NIERDERLANDE3");
                i--;
            }
        }
    }

    /**
     * This method performs a deep copy of the routes into an array list
     * so they aren't permanently altered by the recursive call.
     * @param r - current list of routes a player has.
     * @return - deep copy of r that can be changed without altering r.
     */
    public ArrayList<RouteList> copy(ArrayList<RouteList> r)
    {
        ArrayList<RouteList> answer = new ArrayList<RouteList>();
        for(int i = 0; i < r.size(); i++)
        {
            RouteList toAdd = r.get(i);
            answer.add(toAdd);
        }
        return answer;
    }

    /**
     * This is a "fun" recursive method that tests if a ticekt is valid. To do this,
     * it first sees if it has visted the cities that were part of the route. If it doesn't work,
     * then it sees if a cityName matches one of the citynames in the route. If it does, adds it to 
     * citiesVisted, removes it from the route list, and goes through again.
     * @param cityNames - cities that are either the routes or have not been visited.
     * @param routes - routes that haven't been connected for the ticket.
     * @param citiesVisited - cities that have been visited.
     */
    public boolean ticketPath(ArrayList<String> cityNames, ArrayList<RouteList> routes, ArrayList<City> citiesVisited)
    {
        int visited = 0;
        for(int i = 0; i < citiesVisited.size(); i++)
        {
            if(cityNames.get(0).equals(citiesVisited.get(i).getName()))
            {
                visited++;
            }
            else if(cityNames.get(1).equals(citiesVisited.get(i).getName()))
            {
                visited++;
            }
            if(visited == 2)
            {
                return true;
            }
        }
        if(routes.size() == 0)
        {
            return false;
        }
        for(int i = 0; i < cityNames.size(); i++)
        {
            for(int j = 0; j < routes.size(); j++)
            {
                if(cityNames.get(i).equals(routes.get(j).getCITY1().getName()))
                {
                    String city = cityNames.get(i);
                    cityNames.add(routes.get(j).getCITY2().getName());
                    citiesVisited.add(routes.get(j).getCITY1());
                    RouteList currentRoute = routes.get(j);
                    routes.remove(j);
                    if(ticketPath(cityNames, routes, citiesVisited))
                    {
                        return true;
                    }
                    else 
                    {
                        return false;
                    }
                }
                else if(cityNames.get(i).equals(routes.get(j).getCITY2().getName()))
                {
                    String city = cityNames.get(i);
                    cityNames.add(routes.get(j).getCITY1().getName());
                    citiesVisited.add(routes.get(j).getCITY2());
                    RouteList currentRoute = routes.get(j);
                    routes.remove(j);
                    if(ticketPath(cityNames, routes, citiesVisited))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    
    public void print(ArrayList<String> str)
    {
        for(String s1 : str)
        {
            System.out.println(s1);
        }
    }
}