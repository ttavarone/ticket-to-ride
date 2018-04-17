import java.util.ArrayList;
/**
 * Write a description of class PlayerHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHand
{
    private Player person;
    private ArrayList<TrainCard> hand = new ArrayList<TrainCard>();

    public PlayerHand(Player p)
    {
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
    
    
}
