import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Write a description of class TicketDeckPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicketDeckPanel extends BasePanel
{
    private static Image orangeDest;
    private static Image blueDest;
    protected Toolkit toolkit;
    public TicketDeckPanel(TicketDeck d){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();

        setPreferredSize(new Dimension(150, 125));
        
        orangeDest = toolkit.getImage("TicketToRidePics"+File.separator+"OrangeDest.jpg");
        blueDest = toolkit.getImage("TicketToRidePics"+File.separator+"BlueDest.jpg");

        blueDest = blueDest.getScaledInstance(70, 118, Image.SCALE_FAST);
        orangeDest = orangeDest.getScaledInstance(70, 118, Image.SCALE_FAST);
        
        addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) { 
                    TrainCard t;
                    if(e.getX() >= 0 && e.getX() < 80)
                    {
                        if(!d.shortEmpty())
                        {
                            
                        }
                    }
                    
                } 
            }); 
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(blueDest, 0, 0, this);
        g.drawImage(orangeDest, 80, 0, this);
    }
}
