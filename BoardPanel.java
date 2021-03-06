import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * This method creates the GUI for the board. It also is used to claim 
 * routes for the player and updates their hands and remaining trains 
 * accordingly.
 *
 * @author (Logan, Tucker, Josh, Eamonn, Tom)
 * @version (4 / 30 / 18)
 */
public class BoardPanel extends BasePanel implements MouseListener, 
MouseMotionListener{
    private Toolkit toolkit;
    private Image board;
    private int bHeight;
    private int bWidth;
    private boolean isMouseOnCity = false;
    private int meepleBoxX, meepleBoxY = 0;
    private String currentCityName;
    private boolean firstClick = false;
    protected BasePanel baseline;
    protected PlayerHand[] players;
    protected PlayerTicketsa tickets1;
    protected PlayerTicketsb tickets2;
    protected City c1;
    protected City c2;
    protected boolean printWorked;
    protected boolean printValid;
    private Color[] colorsUsed = new Color[]{Color.BLACK, Color.BLUE, 
        Color.GREEN, Color.ORANGE, Color.PINK,
        Color.RED, Color.WHITE, Color.YELLOW, Color.GRAY};
    private RouteList currentRoutea;
    private RouteList currentRouteb;
    protected DeckOfCards deck;

    /**
     * This constructor initializes the board panel with the players 
     * and other necessities
     * @param p - the players and what is in their hands.
     * @param player1 - the tickets player 1 has, not the actual player
     * @param player2 - the tickets player 2 has, not the actual player
     * @param bPanel - the variables from a super class that the 3 main
     * panels all share.
     * @param d - the deck of cards that discarded cards will be added to
     */
    public BoardPanel(PlayerHand[] p, PlayerTicketsa player1, 
        PlayerTicketsb player2, BasePanel bPanel, DeckOfCards d) {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        board = toolkit.getImage("TTRGermanyMap.jpg");
        bHeight = board.getHeight(this);
        bWidth = board.getWidth(this);

        players = p;
        baseline = bPanel;
        tickets1 = player1;
        tickets2 = player2;
        deck = d;

        board = board.getScaledInstance(550, 850, Image.SCALE_SMOOTH);

        setPreferredSize(new Dimension(550, 850));

        addMouseListener( this );
        addMouseMotionListener( this );
    }
    
    /**
     * This method will draw the board, the all routes players have 
     * claimed. Will also show a text box for the city the mouse is on if it
     * is on one. Will also ake the game go into final turn if a route is 
     * claimed and brings their train count below 3.
     * @param g - The Graphics to be drawn for the class.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(board, bWidth, bHeight, this);

        if(baseline.disableRepaint){  }
        else
        {
            if(baseline.finalTurn)
            {
                baseline.disableRepaint = true;
                int p1Score = players[0].getPlayer().calculateFinalScore();
                int p2Score = players[1].getPlayer().calculateFinalScore();
                g.drawString("Player 1 scored " + p1Score +
                    " total", 100, 100);
                g.drawString("Player 2 scored " + p1Score + 
                    " total", 100, 200);
                EndGamePanel e = new EndGamePanel(players);
            }
            else
            {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(10));
                drawRoutes(g, players[0].getPlayer());
                drawRoutes(g, players[1].getPlayer());
                g.setColor(Color.BLACK);

                if(isMouseOnCity){
                    g.setColor(Color.BLUE);
                    g.fillRect(meepleBoxX,meepleBoxY,110,40);
                    g.setColor(Color.WHITE);
                    currentCityName = currentCityName.replaceAll("[^A-Z]","");
                    g.drawString(currentCityName, meepleBoxX + 
                        10, meepleBoxY + 10);
                    //g.drawString("Has 2 meeples", meepleBoxX + 
                    //    10, meepleBoxY + 30);
                }

                /*if(firstClick)
                {
                    String cityName = c1.getName();
                    //g.drawString(cityName, 150, 150);
                }*/

                /*if(c2 != null)
                {
                    String cityName = c2.getName();
                    //g.drawString(cityName, 250, 250);
                }*/

                if(printWorked)
                {
                    printWorked = false;
                    baseline.currentPlayer = 
                    (baseline.currentPlayer + 1) % baseline.totalPlayers;
                    tickets1.setTrainTicket(0);
                    tickets1.setPlayerTurn(baseline.currentPlayer);
                    tickets2.setTrainTicket(0);
                    tickets2.setPlayerTurn(baseline.currentPlayer);
                    baseline.currentTrainTicket = 0;
                    if(baseline.oneTurnLeft)
                    {
                        baseline.finalTurn = true;
                    }
                    else if(baseline.almostFinalTurn)
                    {
                        baseline.oneTurnLeft = true;
                    }
                    tickets1.repaint();
                    tickets2.repaint();
                    players[baseline.currentPlayer].repaint();
                    repaint();
                }
                if(players[currentPlayer].getPlayer().getTrainsLeft() < 3)
                {
                    baseline.almostFinalTurn = true;
                }
            }
        }
    }

    /**
     * This method goes first to make sure that a route exists between
     * the two selested cities. If the route is a double route, will try
     * and find the other route if it exists.
     * @return - true if a route exists, false othewise.
     */
    public boolean checkValidRoute()
    {
        for(RouteList r : RouteList.values())
        {
            if(!r.isRouteClaimed())
            {
                if(c1 == r.getCITY1() && c2 == r.getCITY2() ||
                c1 == r.getCITY2() && c2 == r.getCITY1())
                {
                    currentRoutea = r;
                    if(r.isDoubleRoute() && r.getRouteColor() != Color.GRAY)
                    {
                        for(RouteList r2 : RouteList.values())
                        {
                            if((c1 == r2.getCITY1() && c2 == r2.getCITY2())
                            && r2.getRouteColor() != r.getRouteColor())
                            {
                                currentRouteb = r2;
                                return true;
                            }
                        }
                    }
                    currentRouteb = null;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks if a player has enough trains of the 
     * color to claim a route. For gray routes, it will return the 
     * first train color that successfully completes the route
     * @return - true if a player can claim a train route, false
     * if the player is unable to
     */
    public boolean checkTrainCount()
    {
        Player current = players[baseline.currentPlayer].getPlayer();
        Color currentColor = Color.GRAY;
        for(int i = 0; i < 9; i++)
        {
            if(current.getTrainsLeft() < currentRoutea.getRouteLength())
            {
                return false;
            }
            if(colorsUsed[i] == currentRoutea.getRouteColor())
            {
                currentColor = colorsUsed[i];
                if(currentColor != Color.GRAY)
                {
                    int trains = current.getAmount(i);
                    int wilds = current.getAmount(8);
                    if(trains + wilds >= currentRoutea.getRouteLength())
                    {
                        if(current.getTrainsLeft() >
                        currentRoutea.getRouteLength())
                        {
                            current.claimRoute(currentRoutea);
                            current.addPoints(currentRoutea.getRouteLength());
                            discardTrains(currentRoutea.getRouteLength(), i);
                            if(currentRouteb != null)
                            {
                                currentRouteb.setRouteClaimed(true);
                            }
                            return true;
                        }
                    }
                }
                else
                {
                    int wilds = current.getAmount(8);
                    for(int index = 0; index < 8; index++)
                    {
                        int trains = current.getAmount(index);
                        if(trains + wilds >= currentRoutea.getRouteLength())
                        {
                            if(current.getTrainsLeft() > 
                            currentRoutea.getRouteLength())
                            {
                                current.claimRoute(currentRoutea);
                                current.addPoints(
                                currentRoutea.getRouteLength());
                                discardTrains(currentRoutea.getRouteLength(),
                                index);
                                if(currentRouteb != null)
                                {
                                    currentRouteb.setRouteClaimed(true);
                                }
                                return true;
                            }
                        }
                    }
                }
            }
            if(currentRouteb != null)
            {
                if(colorsUsed[i] == currentRouteb.getRouteColor())
                {
                    currentColor = colorsUsed[i];
                    if(currentColor != Color.GRAY)
                    {
                        int trains = current.getAmount(i);
                        int wilds = current.getAmount(8);
                        if(trains + wilds >= currentRouteb.getRouteLength())
                        {
                            if(current.getTrainsLeft() >=
                            currentRouteb.getRouteLength())
                            {
                                current.claimRoute(currentRouteb);
                                current.addPoints(
                                currentRouteb.getRouteLength());
                                discardTrains(currentRouteb.
                                getRouteLength(), i);
                                currentRoutea.setRouteClaimed(true);
                                return true;
                            }
                        }
                    }
                    else
                    {
                        int wilds = p[baseline.currentPlayer].
                        returnAmtCard(8);
                        for(int index = 0; index < 8; index++)
                        {
                            int trains = p[baseline.currentPlayer].
                            returnAmtCard(index);
                            if(trains + wilds >= currentRouteb.
                            getRouteLength())
                            {
                                if(current.getTrainsLeft() >= 
                                currentRouteb.getRouteLength())
                                {
                                    current.claimRoute(currentRouteb);
                                    current.addPoints(
                                    currentRouteb.getRouteLength());
                                    discardTrains(currentRouteb.
                                    getRouteLength(), index);
                                    currentRoutea.setRouteClaimed(true);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method draws a line between two cities based on the 
     * routes a player has claimed.
     * @param g - The graphics that are drawn for the board.
     * @param currentPlayer - the player who's routes are being drawn.
     */
    public void drawRoutes(Graphics g, Player currentPlayer)
    {
        ArrayList<RouteList> rList = currentPlayer.getRouteList();
        g.setColor(currentPlayer.getPlayerColor());
        for(int i = 0; i < rList.size(); i++)
        {
            RouteList r = rList.get(i);
            int x1 = r.getCITY1().getX();
            int y1 = r.getCITY1().getY();
            int x2 = r.getCITY2().getX();
            int y2 = r.getCITY2().getY();
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * This method will discard trains from the player class and
     * add them to the discard pile of the deck.
     * @param routeLength - how long the route being claimed is.
     * @param index - Index of the color in the array so it knows
     * which trains to remove from a players hand.
     */
    public void discardTrains(int routeLength, int index)
    {
        PlayerHand current = players[baseline.currentPlayer];
        int numTrains;
        for(int i = 0; i < routeLength; i++)
        {
            numTrains = current.returnAmtCard(index);
            if(numTrains > 0)
            {
                deck.discardTrain(new TrainCard(index));
                current.setAmtCard(index, numTrains - 1); 
            }
            else
            {
                numTrains = current.returnAmtCard(8);
                deck.discardTrain(new TrainCard(8));
                current.setAmtCard(8, numTrains - 1); 
            }
        }
    }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseEntered( MouseEvent e ) {  }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseExited( MouseEvent e ) { }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseClicked( MouseEvent e ) {  }

    /**
     * This method will determine which city was clicked on first,
     * then when a second click is made, if it was a city, it will see if
     * there is a valid route between the cities and claim it for a player.
     * @param e - event where mouse is pressed down.
     */
    @Override
    public void mousePressed( MouseEvent e ) {
        if(!baseline.blockRouteClaim)
        {
            printWorked = false;
            printValid = false;
            if(!firstClick)
            {
                for(City c: City.values()){
                    if(e.getX() >= (c.getX() - 11) && e.getX() <=
                    (c.getX() + 11)){
                        if(e.getY() >= (c.getY() - 11) && e.getY() <=
                        (c.getY() + 11))
                        {
                            c1 = c;
                            c2 = null;
                            firstClick = true;
                            baseline.blockTrainDraw = true;
                            baseline.blockTicketDraw = true;
                            break;
                        }
                    }
                }
                repaint();
            }
            else
            {
                firstClick = false;
                baseline.blockTicketDraw = false;
                baseline.blockTrainDraw = false;
                for(City c: City.values()){
                    if(e.getX() >= (c.getX() - 11) && e.getX() <=
                    (c.getX() + 11)){
                        if(e.getY() >= (c.getY() - 11) && e.getY() <=
                        (c.getY() + 11))
                        {
                            c2 = c;
                            if(checkValidRoute())
                            {
                                printValid = true;
                                if(checkTrainCount())
                                {
                                    printWorked = true;                                
                                }
                            }
                            break;
                        }
                    }
                }
                repaint();
            }
        }
    }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseReleased( MouseEvent e ) { }

    /**
     * If the mouse is moved over a city, it will draw a box and 
     * display the name of the city.
     * @param e - Mouse event where mouse is moved.
     */
    @Override
    public void mouseMoved( MouseEvent e ){
        isMouseOnCity = false;
        for(City c: City.values()){
            if(e.getX() >= (c.getX() - 11) && e.getX() <= (c.getX() + 11)){
                if(e.getY() >= (c.getY() - 11) && e.getY() <= (c.getY() + 11))
                {
                    isMouseOnCity = true;
                    if((c.getX() + 100) > 548){
                        meepleBoxX = c.getX() - 100;
                    }
                    else{
                        meepleBoxX = c.getX();
                    }
                    if((c.getX() + 40) > 851){
                        meepleBoxX = (c.getY() - 40);
                    }
                    else{
                        meepleBoxY = c.getY();
                    }
                    currentCityName = c.getName();
                    break;
                }
            }
        }
        repaint();
    }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseDragged( MouseEvent e) {  }
}
