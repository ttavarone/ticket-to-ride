import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DeckOfCardsPanel extends JPanel {

    private Toolkit toolkit;
    private Image trainCardBack;
    private DeckOfCards deck;

    public DeckOfCardsPanel(){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        trainCardBack = toolkit.getImage("TicketToRidePics"+File.separator+"TrainCardBack.JPG");
        trainCardBack = trainCardBack.getScaledInstance(70, 118, Image.SCALE_FAST);
        deck = new DeckOfCards();

        setPreferredSize(new Dimension(480, 128));
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
