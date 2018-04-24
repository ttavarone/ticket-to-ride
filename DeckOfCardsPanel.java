import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeckOfCardsPanel extends JPanel{

    private Toolkit toolkit;
    private Image trainCardBack;
    private DeckOfCards deck;
    private boolean cardDrawn = false;

    public DeckOfCardsPanel(){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        trainCardBack = toolkit.getImage("TicketToRidePics"+File.separator+"TrainCardBack.JPG");
        trainCardBack = trainCardBack.getScaledInstance(70, 118, Image.SCALE_FAST);
        deck = new DeckOfCards();

        setPreferredSize(new Dimension(480, 128));

        addMouseListener(new MouseAdapter() { 
                public void mouseClicked(MouseEvent e) { 
                    TrainCard t;

                    for(int i = 0; i < 5; i++)
                    {
                        if(e.getX() >= 80 + (80 * i) && e.getX() < 160 + (80 * i))
                        {
                            t = deck.dequeue(i);
                            cardDrawn = true;
                            break;
                        }
                    }
                    if(cardDrawn)
                    {
                        //add it to a player's hand
                        repaint();
                    }

                } 
            }); 
    }

    public Image getScaledInstanceOf(TrainCard trainCard){
        return trainCard.getTrainCard()
        .getScaledInstance(70, 118, Image.SCALE_FAST);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("Cards you can draw", 0,128);
        g.drawImage(trainCardBack, 0, 0, this);

        g.drawImage(deck.peek(0).getTrainCard(), 80, 0, this);
        g.drawImage(deck.peek(1).getTrainCard(), 160, 0, this);
        g.drawImage(deck.peek(2).getTrainCard(), 240, 0, this);
        g.drawImage(deck.peek(3).getTrainCard(), 320, 0, this);
        g.drawImage(deck.peek(4).getTrainCard(), 400, 0, this);

        //there should be methods here to update cards as they are chosen or removed
    }
}
