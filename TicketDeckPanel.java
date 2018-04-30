////////////////////////////////////////////////////////////////////////////////
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
    protected int ticketsDrawn = 0;
    protected int currentTrainTicket = 0;
    PlayerTicketsa player0;
    PlayerTicketsb player1;
    BasePanel baseline;

    public TicketDeckPanel(TicketDeck d, PlayerHand[] players, PlayerTicketsa p0, PlayerTicketsb p1, BasePanel bp){
        baseline = bp;
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();

        setPreferredSize(new Dimension(150, 550));

        player0 = p0;
        player1 = p1;

        p = players;

        orangeDest = toolkit.getImage("TicketToRidePics"+File.separator+"OrangeDest.jpg");
        blueDest = toolkit.getImage("TicketToRidePics"+File.separator+"BlueDest.jpg");

        blueDest = blueDest.getScaledInstance(70, 118, Image.SCALE_FAST);
        orangeDest = orangeDest.getScaledInstance(70, 118, Image.SCALE_FAST);

        //addMouseWheelListener(this);
        addMouseListener(new MouseAdapter() { 
                public void mousePressed(MouseEvent e) { 
                    TicketCard t;
                    if(!baseline.blockTicketDraw)
                    {
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
                                    baseline.blockTrainDraw = true;
                                    baseline.blockRouteClaim = true;
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
                                    baseline.blockTrainDraw = true;
                                    baseline.blockRouteClaim = true;
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
                                    if(baseline.currentPlayer == 0)
                                    {
                                        Image temp = toDraw[0].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[0].setImage(temp);
                                        player0.addTicketCard(toDraw[0]);
                                        toDraw[0] = null;
                                        ticketsDrawn++;
                                        player0.repaint();
                                    }
                                    else if(baseline.currentPlayer == 1)
                                    {
                                        Image temp = toDraw[0].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[0].setImage(temp);
                                        player1.addTicketCard(toDraw[0]);
                                        toDraw[0] = null;
                                        ticketsDrawn++;
                                        player1.repaint();
                                    }
                                    repaint();
                                }
                            }
                            else if(e.getX() >= 0 && e.getX() < 80 && e.getY() >= 236 && e.getY() <= 354)
                            {
                                if(toDraw[1] != null)
                                {
                                    if(baseline.currentPlayer == 0)
                                    {
                                        Image temp = toDraw[1].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[1].setImage(temp);
                                        player0.addTicketCard(toDraw[1]);
                                        toDraw[1] = null;
                                        ticketsDrawn++;
                                        player0.repaint();
                                    }
                                    else if(baseline.currentPlayer == 1)
                                    {
                                        Image temp = toDraw[1].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[1].setImage(temp);
                                        player1.addTicketCard(toDraw[1]);
                                        toDraw[1] = null;
                                        ticketsDrawn++;
                                        player1.repaint();
                                    }
                                    repaint();
                                }
                            }
                            else if(e.getX() >= 80 && e.getX() < 160 && e.getY() >= 118 && e.getY() <= 236)
                            {
                                if(toDraw[2] != null)
                                {
                                    if(baseline.currentPlayer == 0)
                                    {
                                        Image temp = toDraw[2].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[2].setImage(temp);
                                        player0.addTicketCard(toDraw[2]);
                                        toDraw[2] = null;
                                        ticketsDrawn++;
                                        player0.repaint();
                                    }
                                    else if(baseline.currentPlayer == 1)
                                    {
                                        Image temp = toDraw[2].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[2].setImage(temp);
                                        player1.addTicketCard(toDraw[2]);
                                        toDraw[2] = null;
                                        ticketsDrawn++;
                                        player1.repaint();
                                    }
                                    repaint();
                                }
                            }
                            else if(e.getX() >= 80 && e.getX() < 160 && e.getY() >= 236 && e.getY() <= 354)
                            {
                                if(toDraw[3] != null)
                                {
                                    if(baseline.currentPlayer == 0)
                                    {
                                        Image temp = toDraw[3].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[3].setImage(temp);
                                        player0.addTicketCard(toDraw[3]);
                                        toDraw[3] = null;
                                        ticketsDrawn++;
                                        player0.repaint();
                                    }
                                    else if(baseline.currentPlayer == 1)
                                    {
                                        Image temp = toDraw[3].getImage();
                                        temp = temp.getScaledInstance(80, 120, Image.SCALE_FAST);
                                        toDraw[3].setImage(temp);
                                        player1.addTicketCard(toDraw[3]);
                                        toDraw[3] = null;
                                        ticketsDrawn++;
                                        player1.repaint();
                                    }
                                    repaint();
                                }
                            }
                            else if(ticketsDrawn > 0)
                            {
                                if(e.getX() >= 20 && e.getX() < 145 && e.getY() >= 450 && e.getY() < 475)
                                {
                                    for(int i = 0; i < 4; i++)
                                    {
                                        if(toDraw[i] != null)
                                        {
                                            t = toDraw[i];
                                            if(t.getLength().equals("short"))
                                            {
                                                d.discardShort(t);
                                            }
                                            else
                                            {
                                                d.discardLong(t);
                                            }
                                            toDraw[i] = null;
                                        }
                                    }
                                    ticketsDrawn = 4;
                                    repaint();
                                }
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
        if(baseline.disableRepaint){  }
        else
        {
            
            g.drawImage(blueDest, 0, 0, this);
            g.drawImage(orangeDest, 80, 0, this);
            //g.setColor(Color.BLACK);
            g.fillRect(20, 450, 125, 25);
            g.setColor(Color.WHITE);
            g.drawString("Stop drawing tickets", 25, 460);
            
            if(baseline.finalTurn)
            {
                baseline.disableRepaint = true;
                int p1Score = p[0].getPlayer().calculateFinalScore();
                int p2Score = p[1].getPlayer().calculateFinalScore();
                g.drawString("Player 1 scored " + p1Score + " total", 100, 100);
                g.drawString("Player 2 scored " + p1Score + " total", 100, 200);
                EndGamePanel e = new EndGamePanel(p);
            }
            
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
                baseline.currentPlayer = (baseline.currentPlayer + 1) % baseline.totalPlayers;
                player0.setTrainTicket(0);
                player0.setPlayerTurn(baseline.currentPlayer);
                player1.setTrainTicket(0);
                player1.setPlayerTurn(baseline.currentPlayer);
                baseline.currentTrainTicket = 0;
                if(baseline.firstTurn)
                {
                    baseline.setFirstTurn(false);
                }
                else
                {
                    baseline.setBlockTrainDraw(false);
                    baseline.blockRouteClaim = false;
                }
                if(baseline.oneTurnLeft)
                {
                    baseline.finalTurn = true;
                }
                else if(baseline.almostFinalTurn)
                {
                    baseline.oneTurnLeft = true;
                }
                player0.repaint();
                player1.repaint();
                p[baseline.currentPlayer].repaint();
                repaint();
            }
        }
    }

    /*public void mouseWheelMoved(MouseWheelEvent e)
    {
    int ticketNum = playerT[currentPlayer].getTrainTicket();
    if(e.getX() >= 40 && e.getX() < 120 && e.getY() >= 425)
    {
    if(playerT[currentPlayer].getPlayer().claimedTickets() >= 2)
    {
    baseline.currentTrainTicket = (ticketNum + 1) % playerT[currentPlayer].getPlayer().claimedTickets();
    playerT[currentPlayer].setTrainTicket(baseline.currentTrainTicket);
    repaint();
    }
    }
    }*/
}
