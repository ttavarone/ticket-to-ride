import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Contains an array that shows the player what cards they have
 * 
 * @author (Tucker Tavarone, Josh DelSignore, Logan Brandt,
 * Tom Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public class PlayerHand extends DeckOfCardsPanel
{
    private Player person;
    private ArrayList<TrainCard> hand = new ArrayList<>();
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

    public PlayerHand(Player p)
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
        amountEachCard = new int[9];

        TrainCard t;
        for(int i = 0; i < 5; i++)
        {
            t = super.deck.dequeue(i - i);
            int toAdd = t.getCurrentNum();
            amountEachCard[toAdd]++;
        }
        
        setPreferredSize(new Dimension(230, 385));
    }
    /*
    public void drawCard(DeckOfCards d)
    {
        if(!d.isEmpty())
        {
            hand.add(d.dequeue());
        }
        else
        {
            d.reshuffle();
            if(!d.isEmpty())
            {
                hand.add(d.dequeue());
            }
        }
    }

    public void addToHand(TrainCard c){
        int cardNum = c.getCurrentNum();
        hand.add(cardNum, c);
    }
    */
    /**
     * For returning the current that the player has
     * @return ArrayList representing the players current hand
     */
    public ArrayList returnCurrentHand(){
        return hand;
    }

    public void generateAmtEachCard(){
        for(int i = 0; i < hand.size(); i++){
            int cardNum = hand.get(i).getCurrentNum();
            amountEachCard[cardNum]++;
        }
    }

    public int returnAmtCard(int cardNumIn){
        return amountEachCard[cardNumIn];
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

    }
}
