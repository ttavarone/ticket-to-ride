import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Contains an array that shows the player what cards they have
 * 
 * @author (Tucker Tavarone, Josh DelSignore, Logan Brandt,
 * Tom Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public class PlayerHand extends JPanel
{
    private Player person;
    private int[] amountEachCard;

    //imgArr = new Image[]{blackTrain, blueTrain, greenTrain, orangeTrain, purpleTrain,
    //        redTrain, whiteTrain, yellowTrain, wildCard};

    private Toolkit toolkit;
    private static TrainCard blackTrain;
    private static TrainCard blueTrain;
    private static TrainCard greenTrain;
    private static TrainCard orangeTrain;
    private static TrainCard purpleTrain;
    private static TrainCard redTrain;
    private static TrainCard whiteTrain;
    private static TrainCard yellowTrain;
    private static TrainCard wildCard;
    
    private int currentTrainTicket = 0;

    public PlayerHand(Player p, DeckOfCards deck)
    {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);

        person = p;
        toolkit = Toolkit.getDefaultToolkit();
        blackTrain = new TrainCard(0);
        blueTrain = new TrainCard(1);
        greenTrain = new TrainCard(2);
        orangeTrain = new TrainCard(3);
        purpleTrain = new TrainCard(4);
        redTrain = new TrainCard(5);
        whiteTrain = new TrainCard(6);
        yellowTrain = new TrainCard(7);
        wildCard = new TrainCard(8);

        TrainCard t;
        for(int i = 0; i < 5; i++)
        {
            t = deck.dequeue(0);
            int toAdd = t.getCurrentNum();
            person.addToHand(t);
        }
        
        setPreferredSize(new Dimension(230, 485));
    }

    public int returnAmtCard(int cardNumIn){
        return person.getAmount(cardNumIn);
    }
    
    public void addCard(TrainCard t)
    {
        person.addToHand(t);
    }
    
    public Player getPlayer()
    {
        return person;
    }
    
    public void addTicketCard(TicketCard t)
    {
        person.claimTicket(t);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); 
        
        g.drawString("Player cards", 0, 385);

        g.drawImage(blackTrain.getTrainCard(), 0, 0, this);
        g.drawImage(blueTrain.getTrainCard(), 0, 128, this);
        g.drawImage(greenTrain.getTrainCard(), 0, 256, this);
        g.drawImage(orangeTrain.getTrainCard(), 80, 0, this);
        g.drawImage(purpleTrain.getTrainCard(), 80, 128, this);
        g.drawImage(redTrain.getTrainCard(), 80, 256, this);
        g.drawImage(whiteTrain.getTrainCard(), 160, 0, this);
        g.drawImage(yellowTrain.getTrainCard(), 160, 128, this);
        g.drawImage(wildCard.getTrainCard(), 160, 256, this);

        //imgArr = new Image[]{blackTrain, blueTrain, greenTrain, orangeTrain, purpleTrain,
        //        redTrain, whiteTrain, yellowTrain, wildCard};

        /*
        The following statements create little black boxes that contain
        a number that represents how many of the card a player has
         */
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 25, 25);//black
        g.fillRect(0, 128, 25, 25);//
        g.fillRect(0, 256, 25, 25);
        g.fillRect(80, 0, 25, 25);
        g.fillRect(80, 128, 25, 25);
        g.fillRect(80, 256, 25, 25);
        g.fillRect(160, 0, 25, 25);
        g.fillRect(160, 128, 25, 25);
        g.fillRect(160, 256, 25, 25);

        /*
        The following statements put the numbers in the black boxes
        that will be strings that update according to the cards a player
        has in their 'hand'
         */

        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.drawString(Integer.toString(returnAmtCard(0)), 0, 20);//black
        g.drawString(Integer.toString(returnAmtCard(3)), 80, 20);//orange
        g.drawString(Integer.toString(returnAmtCard(6)), 160, 20);//white
        g.drawString(Integer.toString(returnAmtCard(1)), 0, 148);//blue
        g.drawString(Integer.toString(returnAmtCard(4)), 80, 148);//purple
        g.drawString(Integer.toString(returnAmtCard(7)), 160, 148);//yellow
        g.drawString(Integer.toString(returnAmtCard(2)), 0, 276);//green
        g.drawString(Integer.toString(returnAmtCard(5)), 80, 276);//red
        g.drawString(Integer.toString(returnAmtCard(8)), 160, 276);//wild
        
        if(person.claimedTickets() > 0)
        {
            g.drawImage(person.getTicket(currentTrainTicket).getImage(), 240, 0, this);
        }
    }
}
