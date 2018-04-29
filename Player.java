import java.awt.Color;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    protected int greenMeeple, redMeeple, blueMeeple, blackMeeple, whiteMeeple, yellowMeeple = 0;
    private int numTrains = 10;
    private int playerNum; 
    private Color playerColor;
    private ArrayList<TicketCard> tickets = new ArrayList<TicketCard>();
    private ArrayList<RouteList> controlledRoutes = new ArrayList<RouteList>();
    private int[] amountEachCard = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int points = 0;
    public int successfulTickets;

    public Player(int playerNumber, Color pColor)
    {
        playerNum = playerNumber;
        playerColor = pColor;
    }

    /**
     * This method attempts to add a route to a player object. Returns 
     * true if it has ot been claimed, false otherwise.
     */
    public void claimRoute(RouteList route, int colorIndex)
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

    public boolean ticketPath(ArrayList<String> cityNames, ArrayList<RouteList> routes, ArrayList<City> citiesVisited)
    {
        int visited = 0;
        for(int i = 0; i < citiesVisited.size(); i++)
        {
            if(cityNames.contains(citiesVisited.get(i).getName()))
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