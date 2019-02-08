import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
/**
 * Contains an array that shows the player what cards they have
 * 
 * @author (Tucker Tavarone, Josh DelSignore, Logan Brandt,
 * Tom Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public class PlayerHand extends JPanel// implements MouseWheelListener
{
    private Player person;
    private int[] amountEachCard;

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
    private int playerNumber = 0;

    /**
     * This creates a new player hand for a player, and has a
     * deck to add the top 4 into a player's hand.
     * @param p - The player this playerhand represents
     * @param d - the deck of cards the player gets cards from
     * at the beginning of the game.
     */
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

        playerNumber = p.getPlayerNum();

        TrainCard t;
        for(int i = 0; i < 4; i++)
        {
            t = deck.dequeue(0);
            int toAdd = t.getCurrentNum();
            person.addToHand(t);
        }

        //addMouseWheelListener(this);
        setPreferredSize(new Dimension(230, 485));
    }

    /**
     * This method returns how many train cards are
     * of a certain color.
     * @param cardNumIn - The color to check train amount for.
     * @return - how many trains of a color are in the players hand
     */
    public int returnAmtCard(int cardNumIn){
        return person.getAmount(cardNumIn);
    }

    /**
     * This method sets the number of train cards of a certain
     * color that are in a players hand.
     * @param cardNumIn - The color to change train amount for.
     * @param toChange - the new amount of trains cards of the color
     */
    public void setAmtCard(int cardNumIn, int toChange){
        person.setAmount(cardNumIn, toChange);
    }

    /**
     * Adds the train card to a players hand.
     * @param t - The Trains card to add to a player's hand.
     */
    public void addCard(TrainCard t)
    {
        person.addToHand(t);
    }

    /**
     * Returns the player that this playerhand object represents
     * @return - the player whose hand this is
     */
    public Player getPlayer()
    {
        return person;
    }

    /**
     * This class draws all the train cards, and then prints how many
     * of each card the player has.
     * @param g - the graphics for this class
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); 

        g.drawString("Player " + (playerNumber + 1) + 
            "'s cards", 0, 385);

        g.drawImage(blackTrain.getTrainCard(), 0, 0, this);
        g.drawImage(blueTrain.getTrainCard(), 0, 128, this);
        g.drawImage(greenTrain.getTrainCard(), 0, 256, this);
        g.drawImage(orangeTrain.getTrainCard(), 80, 0, this);
        g.drawImage(purpleTrain.getTrainCard(), 80, 128, this);
        g.drawImage(redTrain.getTrainCard(), 80, 256, this);
        g.drawImage(whiteTrain.getTrainCard(), 160, 0, this);
        g.drawImage(yellowTrain.getTrainCard(), 160, 128, this);
        g.drawImage(wildCard.getTrainCard(), 160, 256, this);
        /*
        The following statements create little black boxes that contain
        a number that represents how many of the card a player has
         */
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 25, 25);//black
        g.fillRect(0, 128, 25, 25);
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
