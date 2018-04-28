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
    BasePanel baseline;
    PlayerHand[] players;
    PlayerTicketsa tickets1;
    PlayerTicketsb tickets2;

    public BoardPanel(PlayerHand[] p, PlayerTicketsa player1, PlayerTicketsb player2, BasePanel bPanel) {
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
        
        board = board.getScaledInstance(550, 850, Image.SCALE_SMOOTH);

        setPreferredSize(new Dimension(550, 850));
        
        addMouseListener( this );
        addMouseMotionListener( this );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(board, bWidth, bHeight, this);
        
        if(isMouseOnCity){
            g.setColor(Color.BLUE);
            g.fillRect(meepleBoxX,meepleBoxY,110,40);
            g.setColor(Color.WHITE);
            currentCityName = currentCityName.replaceAll("[^A-Z]","");
            g.drawString(currentCityName, meepleBoxX + 10, meepleBoxY + 10);
            g.drawString("Has 2 meeples", meepleBoxX + 10, meepleBoxY + 30);
        }
    }
    
    /**
     * Only exists to override an abstract method
     * @param e - Mouse event
     */
    @Override
    public void mouseEntered( MouseEvent e ) { 
        
    }

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
    public void mouseClicked( MouseEvent e ) { }
    
    /**
     * This method will determine if the user pressed the mouse down on a valid piece, and then send it into that
     * pieces mouse pressed handler to determine what happens.
     * @param e - when the mouse is pushed down
     */
    @Override
    public void mousePressed( MouseEvent e ) { }
    
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
            else{
                isMouseOnCity = false;
            }
            repaint();
        }
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
