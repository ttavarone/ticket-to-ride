import javax.swing.*;
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
    private int[] amountOfCards;

    //imgArr = new Image[]{blackTrain, blueTrain, greenTrain, orangeTrain, purpleTrain,
    //        redTrain, whiteTrain, yellowTrain, wildCard};

    public PlayerHand(Player p)
    {
        amountOfCards = new int[hand.size()];
        person = p;
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
        amountOfCards[cardNum]++;
    }

    /**
     * NOT CORRECT OR FINISHED
     * @return
     */
    public ArrayList returnCurrentHand(){
        for(int i = 0; i < hand.size(); i++){
            int x = amountOfCards[i];
        }
        return hand;

    }
    
    
}
