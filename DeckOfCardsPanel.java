import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeckOfCardsPanel extends JPanel{

    private Toolkit toolkit;
    private Image trainCardBack;
    private boolean cardDrawn = false;
    protected DeckOfCards deck;
    int displayCurrentHand  = 0;
    private int cardsDrawn;
    int currentPlayer = 0;
    int totalPlayers = 2;
    PlayerHand[] p = new PlayerHand[1];

    public DeckOfCardsPanel(PlayerHand[] p, DeckOfCards d){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        trainCardBack = toolkit.getImage("TicketToRidePics"+File.separator+"TrainCardBack.JPG");
        trainCardBack = trainCardBack.getScaledInstance(70, 118, Image.SCALE_FAST);

        totalPlayers = p.length;
        deck = d;
        setPreferredSize(new Dimension(480, 128));

        this.p = p;
        
        addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) { 
                    TrainCard t;
                    int deckSize = deck.getDeckSize();
                    if(e.getX() >= 0 && e.getX() < 80)
                    {
                        if(deckSize >= 6)
                        {
                            t = deck.dequeue(5);
                            p[getPlayerNum()].addCard(t);
                            cardDrawn = true;
                            cardsDrawn++;
                        }
                    }
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
                                p[currentPlayer].addCard(t);
                                cardDrawn = true;
                                break;
                            }
                        }
                    }
                    if(cardDrawn)
                    {
                        p[currentPlayer].repaint();
                        repaint();
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

        g.setColor(Color.BLACK);
        g.drawString("Cards you can draw", 0,128);
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
            currentPlayer = (currentPlayer + 1) % totalPlayers;
            p[currentPlayer].repaint();
        }
        //there should be methods here to update cards as they are chosen or removed
    }
}
