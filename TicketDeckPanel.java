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
    protected TicketCard shortsTaken[] = new TicketCard[4];
    protected int currentShortIndex = 0;
    protected TicketCard longsTaken[] = new TicketCard[4];
    protected int currentLongIndex = 0; 
    protected TicketCard toDraw[] = new TicketCard[4];
    protected Image test1;
    public TicketDeckPanel(TicketDeck d){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();

        setPreferredSize(new Dimension(150, 400));

        orangeDest = toolkit.getImage("TicketToRidePics"+File.separator+"OrangeDest.jpg");
        blueDest = toolkit.getImage("TicketToRidePics"+File.separator+"BlueDest.jpg");

        blueDest = blueDest.getScaledInstance(70, 118, Image.SCALE_FAST);
        orangeDest = orangeDest.getScaledInstance(70, 118, Image.SCALE_FAST);

        addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) { 
                    TrainCard t;
                    if(currentShortIndex + currentLongIndex < 4)
                    {
                        if(e.getX() >= 0 && e.getX() < 80 )
                        {
                            if(!d.shortEmpty())
                            {
                                shortsTaken[currentShortIndex] = d.dequeueShort();
                                Image temp = shortsTaken[currentShortIndex].getImage();
                                temp = temp.getScaledInstance(75, 118, Image.SCALE_FAST);
                                shortsTaken[currentShortIndex].setImage(temp);
                                currentShortIndex++;
                                repaint();
                            }
                        }
                        else if(e.getX() >= 80 && e.getX() < 160)
                        {
                            if(!d.longEmpty())
                            {
                                longsTaken[currentLongIndex] = d.dequeueLong();
                                Image temp = longsTaken[currentLongIndex].getImage();
                                temp = temp.getScaledInstance(75, 118, Image.SCALE_FAST);
                                longsTaken[currentLongIndex].setImage(temp);
                                currentLongIndex++;
                                repaint();
                            }
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
        
        int j = 0;
        for(int i = 0; i < 4; i++)
        {
            if(shortsTaken[i] != null)
            {
                toDraw[j] = shortsTaken[i];
                j++;
            }
            else break;
        }
        for(int i = 0; i < 4; i++)
        {
            if(longsTaken[i] != null)
            {
                toDraw[j] = longsTaken[i];
                j++;
            }
            else break;
        }
        for(int i = 0; i < 4; i++)
        {
            if(toDraw[i] != null)
            {
                Image t = toDraw[i].getImage();
                g.drawImage(t, 0, 128, this);//(0 + 80 * (i / 2)), (80 + 80 * (i % 2)), this);
            }
            else break;
        }
    }
}
