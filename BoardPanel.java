import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * GUI for the board
 *
 * @author (Logan, Tucker, Josh, Eamonn, Tom)
 * @version (4 / 8 / 18)
 */
public class BoardPanel extends BasePanel implements MouseListener, MouseMotionListener{
    private Toolkit toolkit;
    private Image board;
    private int bHeight;
    private int bWidth;
    private boolean isMouseOnCity = false;
    private int meepleBoxX, meepleBoxY = 0;
    private String currentCityName;
    private boolean firstClick = false;
    BasePanel baseline;
    PlayerHand[] players;
    PlayerTicketsa tickets1;
    PlayerTicketsb tickets2;
    City c1;
    City c2;
    protected boolean printWorked;
    protected boolean printValid;
    Color[] colorsUsed = new Color[]{Color.BLACK, Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW, Color.GRAY};
    RouteList currentRoutea;
    RouteList currentRouteb;
    DeckOfCards deck;

    public BoardPanel(PlayerHand[] p, PlayerTicketsa player1, PlayerTicketsb player2, BasePanel bPanel, DeckOfCards d) {
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(board, bWidth, bHeight, this);

        if(baseline.finalTurn)
        {
            System.exit(0);
        }
        
        if(isMouseOnCity){
            g.setColor(Color.BLUE);
            g.fillRect(meepleBoxX,meepleBoxY,110,40);
            g.setColor(Color.WHITE);
            currentCityName = currentCityName.replaceAll("[^A-Z]","");
            g.drawString(currentCityName, meepleBoxX + 10, meepleBoxY + 10);
            g.drawString("Has 2 meeples", meepleBoxX + 10, meepleBoxY + 30);
        }

        if(firstClick)
        {
            String cityName = c1.getName();
            g.drawString(cityName, 150, 150);
        }

        if(c2 != null)
        {
            String cityName = c2.getName();
            g.drawString(cityName, 250, 250);
        }

        if(printValid)
        {
            g.drawString("Route valid!", 350, 250);
        }

        if(printWorked)
        {
            printWorked = false;
            baseline.currentPlayer = (baseline.currentPlayer + 1) % baseline.totalPlayers;
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
                            if(c1 == r.getCITY1() && c2 == r.getCITY2() ||
                            c1 == r.getCITY2() && c2 == r.getCITY1())
                            {
                                if(r2 == r)
                                {
                                    continue;
                                }
                                currentRouteb = r;
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

    public boolean checkTrainCount()
    {
        Player current = players[baseline.currentPlayer].getPlayer();
        Color currentColor = Color.GRAY;
        for(int i = 0; i < 9; i++)
        {
            if(colorsUsed[i] == currentRoutea.getRouteColor())
            {
                currentColor = colorsUsed[i];
                if(currentColor != Color.GRAY)
                {
                    int trains = current.getAmount(i);
                    int wilds = current.getAmount(8);
                    if(trains + wilds >= currentRoutea.getRouteLength())
                    {
                        current.claimRoute(currentRoutea, i);
                        current.addPoints(currentRoutea.getRouteLength());
                        discardTrains(currentRoutea.getRouteLength(), i);
                        if(currentRouteb != null)
                        {
                            currentRouteb.setRouteClaimed(true);
                        }
                        return true;
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
                            current.claimRoute(currentRoutea, index);
                            current.addPoints(currentRoutea.getRouteLength());
                            discardTrains(currentRoutea.getRouteLength(), index);
                            if(currentRouteb != null)
                            {
                                currentRouteb.setRouteClaimed(true);
                            }
                            return true;
                        }
                    }
                }
                return false;
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
                            current.claimRoute(currentRouteb, i);
                            current.addPoints(currentRouteb.getRouteLength());
                            discardTrains(currentRouteb.getRouteLength(), i);
                            currentRoutea.setRouteClaimed(true);
                            return true;
                        }
                    }
                    else
                    {
                        int wilds = p[baseline.currentPlayer].returnAmtCard(8);
                        for(int index = 0; index < 8; index++)
                        {
                            int trains = p[baseline.currentPlayer].returnAmtCard(index);
                            if(trains + wilds >= currentRouteb.getRouteLength())
                            {
                                current.claimRoute(currentRouteb, index);
                                current.addPoints(currentRouteb.getRouteLength());
                                discardTrains(currentRouteb.getRouteLength(), index);
                                currentRoutea.setRouteClaimed(true);
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

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
    public void mouseExited( MouseEvent e ) { 
    }

    /**
     * This method will determine if a piece is right clicked on, and if it is in the correct difficulty,
     * it will go into that pieces mouseClicked method and rotate it
     * @param e - The event where the mouse is clicked down
     */
    @Override
    public void mouseClicked( MouseEvent e ) {  }

    /**
     * This method will determine if the user pressed the mouse down on a valid piece, and then send it into that
     * pieces mouse pressed handler to determine what happens.
     * @param e - when the mouse is pushed down
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
                    if(e.getX() >= (c.getX() - 11) && e.getX() <= (c.getX() + 11)){
                        if(e.getY() >= (c.getY() - 11) && e.getY() <= (c.getY() + 11))
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
                    if(e.getX() >= (c.getX() - 11) && e.getX() <= (c.getX() + 11)){
                        if(e.getY() >= (c.getY() - 11) && e.getY() <= (c.getY() + 11))
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
     * This method determines if the mouse is released over a piece, and then sends it 
     * into the piece to determine what it does.
     * @param e - the event where the mouse button is pulled up.
     */
    @Override
    public void mouseReleased( MouseEvent e ) { }

    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseMoved( MouseEvent e ){
        //cities
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
        //Danemark
        // if(e.getX() >= (233 - 27) && e.getX() <= (233 + 27)){
        // if(e.getY() >= 0 && e.getY() <= (25 + 28))
        // {
        // isMouseOnCity = true;
        // meepleBoxX = 233;
        // meepleBoxY = 25;
        // currentCityName = "DANEMARK";
        // }
        // }
        // //Niederlande
        // else if(e.getX() >= 0 && e.getX() <= (20 + 35)){
        // if(e.getY() >= (269 - 36) && e.getY() <= (269 + 36))
        // {
        // isMouseOnCity = true;
        // meepleBoxX = 20;
        // meepleBoxY = 269;
        // currentCityName = "NIEDERLANDE";
        // }
        // }
        // //Frankreich
        // else if(e.getX() >= 0 && e.getX() <= (31 + 44)){
        // if(e.getY() >= (706 - 45) && e.getY() <= (706 + 45))
        // {
        // isMouseOnCity = true;
        // meepleBoxX = 31;
        // meepleBoxY = 706;
        // currentCityName = "FRANKREICH";
        // }
        // }
        // //Schweiz
        // else if(e.getX() >= (142 - 28) && e.getX() <= (142 + 28)){
        // if(e.getY() >= (824 - 29) && e.getY() <= (824 + 29))
        // {
        // isMouseOnCity = true;
        // meepleBoxX = 142;
        // meepleBoxY = 824;
        // currentCityName = "SCHWEIZ";
        // }
        // }
        // //Osterreich small
        // else if(e.getX() >= (338 - 23) && e.getX() <= (338 + 23)){
        // if(e.getY() >= (827 - 22) && e.getY() <= (827 + 22))
        // {
        // isMouseOnCity = true;
        // meepleBoxX = 338;
        // meepleBoxY = 827;
        // currentCityName = "OSTERREICH";
        // }
        // }
        // //Osterreich large
        // else if(e.getX() >= (507 - 45) && e.getX() <= (507 + 45)){
        // if(e.getY() >= (791 - 45) && e.getY() <= (791 + 45))
        // {
        // isMouseOnCity = true;
        // meepleBoxX = 507;
        // meepleBoxY = 791;
        // currentCityName = "OSTERREICH";
        // }
        // }
        // else{
        // isMouseOnCity = false;
        // }
    }

    /**
     * This method determines if the mouse is dragged over a valid piece, and then sends it 
     * down into that pieces method to determine what occurs. 
     * @param e - The event where the mouse if moved while being held down.
     */
    @Override
    public void mouseDragged( MouseEvent e) { 
    }
}
