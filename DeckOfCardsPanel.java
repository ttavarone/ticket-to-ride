import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeckOfCardsPanel extends BasePanel{

    private Toolkit toolkit;
    private Image trainCardBack;
    private boolean cardDrawn = false;
    protected DeckOfCards deck;
    int displayCurrentHand  = 0;
    private int cardsDrawn;
    protected PlayerHand[] p;
    PlayerTicketsa player0;
    PlayerTicketsb player1;
    BasePanel baseline;

    public DeckOfCardsPanel(PlayerHand[] p, DeckOfCards d, PlayerTicketsa p0, PlayerTicketsb p1, BasePanel bp){
        baseline = bp;
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        trainCardBack = toolkit.getImage("TicketToRidePics"+File.separator+"TrainCardBack.JPG");
        trainCardBack = trainCardBack.getScaledInstance(70, 118, Image.SCALE_FAST);

        baseline.totalPlayers = p.length;
        deck = d;
        setPreferredSize(new Dimension(480, 256));//128));   

        this.p = p;
        player0 = p0;
        player1 = p1;

        addMouseListener(new MouseAdapter() { 
                public void mousePressed(MouseEvent e) { 
                    TrainCard t;
                    int deckSize = deck.getDeckSize();
                    if(!baseline.blockTrainDraw)
                    {
                        if(e.getX() >= 0 && e.getX() < 80)
                        {
                            if(deckSize >= 6)
                            {
                                t = deck.dequeue(5);
                                p[baseline.currentPlayer].addCard(t);
                                cardDrawn = true;
                                cardsDrawn++;
                            }
                        }
                        else
                        {
                            for(int i = 0; i < Math.min(5, deckSize); i++)
                            {
                                if(e.getX() >= 80 + (80 * i) && e.getX() < 160 + (80 * i))
                                {
                                    if(deck.peek(i).getCurrentNum() == 8 && cardsDrawn == 1)
                                    {
                                        break;
                                    }
                                    else
                                    {
                                        t = deck.dequeue(i);
                                        if(t.getCurrentNum() == 8)
                                        {
                                            cardsDrawn++;
                                        }
                                        cardsDrawn++;
                                        p[baseline.currentPlayer].addCard(t);
                                        cardDrawn = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if(cardDrawn)
                        {
                            p[baseline.currentPlayer].repaint();
                            baseline.blockTicketDraw = true;
                            baseline.blockRouteClaim = true;
                            repaint();
                        }
                    } 
                }
            }); 
    }

    public Image getScaledInstanceOf(TrainCard trainCard){
        return trainCard.getTrainCard()
        .getScaledInstance(70, 118, Image.SCALE_FAST);

    }

    public int getPlayerNum()
    {
        return displayCurrentHand;
    }

    /**
     * Returns true if there are not three wilds, false otherwise.
     */
    public boolean checkWilds()
    {
        int wildsFound = 0;
        if(deck.getDeckSize() >= 3)
        {
            for(int i = 0; i < Math.min(5, deck.getDeckSize()); i++)
            {
                if(deck.peek(i).getCurrentNum() == 8)
                {
                    wildsFound++;
                }
            }
            if(wildsFound >= 3)
            {
                for(int i = 0;  i < Math.min(5, deck.getDeckSize()); i++)
                    deck.discardTrain(deck.dequeue());
                return false;
            }
            return true;
        }
        else return true;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(baseline.disableRepaint){  }
        else
        {
            g.setColor(Color.BLACK);
            g.drawString("Cards you can draw", 0,128);
            if(baseline.finalTurn)
            {
                baseline.disableRepaint = true;
                int p1Score = p[0].getPlayer().calculateFinalScore();
                int p2Score = p[1].getPlayer().calculateFinalScore();
                g.drawString("Player 1 scored " + p1Score + " total", 100, 100);
                g.drawString("Player 2 scored " + p1Score + " total", 100, 200);
                EndGamePanel e = new EndGamePanel(p);
            }
            if(deck.isEmpty())
            {
                deck.reshuffle();
            }
            if(deck.getDeckSize() >= 6)
            {
                g.drawImage(trainCardBack, 0, 0, this);
            }
            while(!checkWilds());
            for(int i = 0; i < Math.min(5, deck.getDeckSize()); i++)
            {
                if(deck.peek(i) != null)
                {
                    g.drawImage(deck.peek(i).getTrainCard(), (80 + 80 * i), 0, this);
                }
                else
                {
                    deck.reshuffle();
                    if(deck.peek(i) != null)
                    {
                        g.drawImage(deck.peek(i).getTrainCard(), (80 + 80 * i), 0, this);
                    }
                    else break;
                }
            }

            if(cardsDrawn == 2)
            {
                cardsDrawn = 0;
                baseline.currentPlayer = (baseline.currentPlayer + 1) % baseline.totalPlayers;
                player0.setTrainTicket(0);
                player0.setPlayerTurn(baseline.currentPlayer);
                player1.setTrainTicket(0);
                player1.setPlayerTurn(baseline.currentPlayer);
                baseline.currentTrainTicket = 0;
                baseline.blockTicketDraw = false;
                baseline.blockRouteClaim = false;
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

                //there should be methods here to update cards as they are chosen or removed
            }
        }
    }
}
