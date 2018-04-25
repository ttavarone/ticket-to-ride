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
public class BoardPanel extends JPanel implements MouseListener, MouseMotionListener{
    private Toolkit toolkit;
    private Image board;
    private int bHeight;
    private int bWidth;
    private int cityDiameter = 90;

    public BoardPanel() {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        board = toolkit.getImage("TTRGermanyMap.jpg");
        bHeight = board.getHeight(this);
        bWidth = board.getWidth(this);

        board = board.getScaledInstance(550, 850, Image.SCALE_SMOOTH);

        setPreferredSize(new Dimension(550, 850));
        
        addMouseListener( this );
        addMouseMotionListener( this );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(board, bWidth, bHeight, this);
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
        repaint();
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
        for(City c: City.values()){
            if(e.getX() >= (c.getX() - 11) && e.getX() <= (c.getX() + 11)){
                if(e.getY() >= (c.getY() - 11) && e.getY() <= (c.getY() + 11))
                {
                    JOptionPane.showMessageDialog((Component) e.getSource(), "2 Meeples");
                    repaint();
                }
            }
        }
        repaint();
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
