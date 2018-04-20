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
public class PlayerHand extends JPanel
{
    private Player person;
    private ArrayList<TrainCard> hand = new ArrayList<>();
    private int[] amountEachCard;

    //imgArr = new Image[]{blackTrain, blueTrain, greenTrain, orangeTrain, purpleTrain,
    //        redTrain, whiteTrain, yellowTrain, wildCard};

    private Toolkit toolkit;
    private TrainCard blackTrain;
    private TrainCard blueTrain;
    private TrainCard greenTrain;
    private TrainCard orangeTrain;
    private TrainCard purpleTrain;
    private TrainCard redTrain;
    private TrainCard whiteTrain;
    private TrainCard yellowTrain;
    private TrainCard wildCard;

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

        setPreferredSize(new Dimension(160, 256));
    }

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
        g.drawImage(blackTrain.getTrainCard(), 600, 50, this);
        g.drawImage(blueTrain.getTrainCard(), 600, 178, this);
        g.drawImage(greenTrain.getTrainCard(), 600, 306, this);
        g.drawImage(orangeTrain.getTrainCard(), 680, 50, this);
        g.drawImage(purpleTrain.getTrainCard(), 680, 178, this);
        g.drawImage(redTrain.getTrainCard(), 680, 306, this);
        g.drawImage(whiteTrain.getTrainCard(), 760, 50, this);
        g.drawImage(yellowTrain.getTrainCard(), 760, 178, this);
        g.drawImage(wildCard.getTrainCard(), 760, 306, this);

        //imgArr = new Image[]{blackTrain, blueTrain, greenTrain, orangeTrain, purpleTrain,
        //        redTrain, whiteTrain, yellowTrain, wildCard};

        /*
        The following statements create little black boxes that contain
        a number that represents how many of the card a player has
         */
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(600, 50, 25, 25);//black
        g.fillRect(600, 178, 25, 25);//
        g.fillRect(600, 306, 25, 25);
        g.fillRect(680, 50, 25, 25);
        g.fillRect(680, 178, 25, 25);
        g.fillRect(680, 306, 25, 25);
        g.fillRect(760, 50, 25, 25);
        g.fillRect(760, 178, 25, 25);
        g.fillRect(760, 306, 25, 25);

        /*
        The following statements put the numbers in the black boxes
        that will be strings that update according to the cards a player
        has in their 'hand'
         */

        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.drawString(Integer.toString(returnAmtCard(0)), 600, 70);//black
        g.drawString(Integer.toString(returnAmtCard(3)), 680, 70);//orange
        g.drawString(Integer.toString(returnAmtCard(6)), 760, 70);//white
        g.drawString(Integer.toString(returnAmtCard(1)), 600, 198);//blue
        g.drawString(Integer.toString(returnAmtCard(4)), 680, 198);//purple
        g.drawString(Integer.toString(returnAmtCard(7)), 760, 198);//yellow
        g.drawString(Integer.toString(returnAmtCard(2)), 600, 326);//green
        g.drawString(Integer.toString(returnAmtCard(5)), 680, 326);//red
        g.drawString(Integer.toString(returnAmtCard(8)), 760, 326);//wild

    }
}
