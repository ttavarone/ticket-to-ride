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
    //PlayerHand p = new PlayerHand(null);

    public DeckOfCardsPanel(PlayerHand[] p, DeckOfCards d){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        trainCardBack = toolkit.getImage("TicketToRidePics"+File.separator+"TrainCardBack.JPG");
        trainCardBack = trainCardBack.getScaledInstance(70, 118, Image.SCALE_FAST);

        deck = d;
        for(int i = 0; i < 5; i++)
        {
            deck.dequeue();
        }

        setPreferredSize(new Dimension(480, 128));

        addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) { 
                    TrainCard t;

                    for(int i = 0; i < 5; i++)
                    {
                        if(e.getX() >= 80 + (80 * i) && e.getX() < 160 + (80 * i))
                        {
                            t = deck.dequeue(i);
                            p[getPlayerNum()].addCard(t);
                            cardDrawn = true;
                            break;
                        }
                    }
                    if(cardDrawn)
                    {
                        p[getPlayerNum()].repaint();
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

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("Cards you can draw", 0,128);
        g.drawImage(trainCardBack, 0, 0, this);
        for(int i = 0; i < 5; i++)
        {
            if(deck.peek(i) != null)
            {
                g.drawImage(deck.peek(i).getTrainCard(), (80 + 80 * i), 0, this);
            }
        }

        //there should be methods here to update cards as they are chosen or removed
    }
}
