import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This is a panel for showing the deck of cards at the bottom of the screen.
 * The deck is continuously updated throughout the game.
 * 
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore, 
 * Tom, Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public class DeckOfCardsPanel extends BasePanel{

    private Toolkit toolkit;
    private Image trainCardBack;
    private boolean cardDrawn = false;
    protected DeckOfCards deck;
    private int displayCurrentHand  = 0;
    private int cardsDrawn;
    protected PlayerHand[] p;
    protected PlayerTicketsa player0;
    protected PlayerTicketsb player1;
    protected BasePanel baseline;
    
    /**
     * This is a constructor that initializes the DeckOfCards for the game
     * @param p - The hands of the players, as well as the actual players.
     * @param d - The deck to be used for the game.
     * @param p0 - The tickets in player 1's hand. 
     * Only here to switch the tickets shown
     * when the turn changes.
     * @param p1 - The tickets in player 2's hand. 
     * Only here to switch the tickets shown
     * when the turn changes.
     * @param bp - The basePanel this class 
     * will use instead of a super class. Since the three main
     * panels import the same object, it allows them all 
     * to speak with each other.
     */
    public DeckOfCardsPanel(PlayerHand[] p, DeckOfCards d, 
    PlayerTicketsa p0, PlayerTicketsb p1, BasePanel bp){
        baseline = bp;
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        trainCardBack = toolkit.getImage("TicketToRidePics"+
            File.separator+"TrainCardBack.JPG");
        trainCardBack = trainCardBack.getScaledInstance(
            70, 118, Image.SCALE_FAST);

        baseline.totalPlayers = p.length;
        deck = d;
        setPreferredSize(new Dimension(480, 256));

        this.p = p;
        player0 = p0;
        player1 = p1;

        addMouseListener(new MouseAdapter() { 
                /**
                 * If the mouse button is pressed, it will attempt 
                 * to draw a card if it is not blocked
                 * and the draw is valid.
                 * @param e - event where mouse is pressed.
                 */
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
                                if(e.getX() >= 80 + (80 * i) && e.getX() 
                                < 160 + (80 * i))
                                {
                                    if(deck.peek(i).getCurrentNum() == 
                                    8 && cardsDrawn == 1)
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
                                        p[baseline.currentPlayer].
                                            addCard(t);
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

    /**
     * This method scales the cards down to fit the screen
     * @param trainCard - card to resize
     * @return - The image scaled to the set dimensions.
     */
    public Image getScaledInstanceOf(TrainCard trainCard){
        return trainCard.getTrainCard()
        .getScaledInstance(70, 118, Image.SCALE_FAST);
    }

    public int getPlayerNum()
    {
        return displayCurrentHand;
    }

    /**
     * This method checks to see if there are three wilds being diplayed as
     * cards for all players to draw.
     * @return - true if there are not three wilds, false otherwise 
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

    /**
     * This method paints the cards onto the screen, 
     * and also changes the player turn 
     * if they have drawn two cards. 
     * @param g - Graphics to draw on the screen
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(baseline.disableRepaint){  }
        else
        {
            g.setColor(Color.BLACK);
            g.drawString("Cards you can draw", 0,128);
            if(baseline.finalTurn)
            {//if it is the final turn, calculate the score
                baseline.disableRepaint = true;
                int p1Score = p[0].getPlayer().calculateFinalScore();
                int p2Score = p[1].getPlayer().calculateFinalScore();
                g.drawString("Player 1 scored " + 
                    p1Score + " total", 100, 100);
                g.drawString("Player 2 scored " + 
                    p1Score + " total", 100, 200);
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
                    g.drawImage(deck.peek(i).getTrainCard(), 
                        (80 + 80 * i), 0, this);
                }
                else
                {
                    deck.reshuffle();
                    if(deck.peek(i) != null)
                    {
                        g.drawImage(deck.peek(i).getTrainCard(), 
                            (80 + 80 * i), 0, this);
                    }
                    else break;
                }
            }

            if(cardsDrawn == 2)
            {
                cardsDrawn = 0;
                baseline.currentPlayer = (baseline.currentPlayer + 1)
                    % baseline.totalPlayers;
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
            }
        }
    }
}
