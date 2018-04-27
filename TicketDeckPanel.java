import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
/**
 * Write a description of class TicketDeckPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicketDeckPanel extends BasePanel// implements MouseWheelListener
{
    private static Image orangeDest;
    private static Image blueDest;
    protected Toolkit toolkit;
    protected TicketCard toDraw[] = new TicketCard[4];
    protected int ticketsTaken;
    protected Image test1;
    protected PlayerHand[] p;
    protected int currentPlayer;
    protected int ticketsDrawn = 0;
    protected int currentTrainTicket = 0;
    PlayerTickets[] playerT;
    
    public TicketDeckPanel(TicketDeck d, PlayerHand[] players, PlayerTickets[] tick){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();

        setPreferredSize(new Dimension(150, 550));
        
        playerT = tick;

        p = players;
        currentPlayer = super.currentPlayer;

        orangeDest = toolkit.getImage("TicketToRidePics"+File.separator+"OrangeDest.jpg");
        blueDest = toolkit.getImage("TicketToRidePics"+File.separator+"BlueDest.jpg");

        blueDest = blueDest.getScaledInstance(70, 118, Image.SCALE_FAST);
        orangeDest = orangeDest.getScaledInstance(70, 118, Image.SCALE_FAST);

        //addMouseWheelListener(this);
        addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) { 
                    TrainCard t;
                    if(ticketsTaken < 4)
                    {
                        if(e.getX() >= 0 && e.getX() < 80 && e.getY() <= 118)
                        {
                            if(!d.shortEmpty())
                            {
                                toDraw[ticketsTaken] = d.dequeueShort();
                                Image temp = toDraw[ticketsTaken].getImage();
                                temp = temp.getScaledInstance(75, 118, Image.SCALE_FAST);
                                toDraw[ticketsTaken].setImage(temp);
                                ticketsTaken++;
                                repaint();
                            }
                        }
                        else if(e.getX() >= 80 && e.getX() < 160 && e.getY() <= 118)
                        {
                            if(!d.longEmpty())
                            {
                                toDraw[ticketsTaken] = d.dequeueLong();
                                Image temp = toDraw[ticketsTaken].getImage();
                                temp = temp.getScaledInstance(75, 118, Image.SCALE_FAST);
                                toDraw[ticketsTaken].setImage(temp);
                                ticketsTaken++;
                                repaint();
                            }
                        }
                    }
                    else if(ticketsTaken == 4)
                    {
                        if(e.getX() >= 0 && e.getX() < 80 && e.getY() >= 118 && e.getY() <= 236)
                        {
                            if(toDraw[0] != null)
                            {
                                playerT[currentPlayer].addTicketCard(toDraw[0]);
                                toDraw[0] = null;
                                ticketsDrawn++;
                                playerT[currentPlayer].repaint();
                                repaint();
                            }
                        }
                        else if(e.getX() >= 0 && e.getX() < 80 && e.getY() >= 236 && e.getY() <= 354)
                        {
                            if(toDraw[1] != null)
                            {
                                playerT[currentPlayer].addTicketCard(toDraw[1]);
                                toDraw[1] = null;
                                ticketsDrawn++;
                                playerT[currentPlayer].repaint();
                                repaint();
                            }
                        }
                        else if(e.getX() >= 80 && e.getX() < 160 && e.getY() >= 118 && e.getY() <= 236)
                        {
                            if(toDraw[2] != null)
                            {
                                playerT[currentPlayer].addTicketCard(toDraw[2]);
                                toDraw[2] = null;
                                ticketsDrawn++;
                                playerT[currentPlayer].repaint();
                                repaint();
                            }
                        }
                        else if(e.getX() >= 80 && e.getX() < 160 && e.getY() >= 236 && e.getY() <= 354)
                        {
                            if(toDraw[3] != null)
                            {
                                playerT[currentPlayer].addTicketCard(toDraw[3]);
                                toDraw[3] = null;
                                ticketsDrawn++;
                                playerT[currentPlayer].repaint();
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

        for(int i = 0; i < 4; i++)
        {
            if(toDraw[i] != null)
            {
                Image t = toDraw[i].getImage();
                g.drawImage(t, (0 + 80 * (i / 2)), (118 + 118 * (i % 2)), this);
            }
        }

        if(ticketsDrawn == 4)
        {
            ticketsDrawn = ticketsTaken = 0;
            currentPlayer = (currentPlayer + 1) % super.totalPlayers;
            super.currentPlayer = currentPlayer;
            playerT[currentPlayer].setTrainTicket(0);
            super.currentTrainTicket = 0;
            playerT[currentPlayer].repaint();
            repaint();
        }
    }

    /*public void mouseWheelMoved(MouseWheelEvent e)
    {
        int ticketNum = playerT[currentPlayer].getTrainTicket();
        if(e.getX() >= 40 && e.getX() < 120 && e.getY() >= 425)
        {
            if(playerT[currentPlayer].getPlayer().claimedTickets() >= 2)
            {
                super.currentTrainTicket = (ticketNum + 1) % playerT[currentPlayer].getPlayer().claimedTickets();
                playerT[currentPlayer].setTrainTicket(super.currentTrainTicket);
                repaint();
            }
        }
    }*/
}
