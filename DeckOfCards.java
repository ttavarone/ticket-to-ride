import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
/**
 * This method creates a deck of train cards to be used for Ticket to Ride.
 * 
 * @author Logan Brandt, Tom Fressenius, Tucker Tavarone, 
 * Eamonn Conway, Joshua DelSignore 
 * @version 1.0
 */
public final class DeckOfCards extends JPanel
{
    private static Image trainCardBack;
    private Toolkit toolkit;
    private ArrayList<TrainCard> deck = new ArrayList<TrainCard>();
    private ArrayList<TrainCard> discard = new ArrayList<TrainCard>();

    /**
     * This method adds a card to the deck if it has less than 110, since 
     * 110 is the max.
     * @param c - Train Card to be added to the deck.
     * @return - true if the card was added, false otherwise.
     */
    public boolean enqueue(TrainCard c)
    {
        if(deck.size() < 110)
        {
            deck.add(c);
            return true;
        }
        return false;
    }

    /**
     * This method removes the top card of the deck, then returns the card that was on top.
     * @return - The card that was on top of the deck, or nothing if the deck is empty.
     */
    public TrainCard dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        TrainCard answer = deck.get(0);
        deck.remove(0);
        discard.add(answer);
        return answer;
    }
    
    /**
     * This method removes the top card of the deck, then returns the card that was on top.
     * @return - The card that was on top of the deck, or nothing if the deck is empty.
     */
    public TrainCard dequeue(int index)
    {
        if(isEmpty())
        {
            return null;
        }
        TrainCard answer = deck.get(index);
        deck.remove(index);
        discard.add(answer);
        return answer;
    }

    /**
     * This method peeks at the next card, but doesn't remove it from the deck.
     * Potentially useful for determining if there are going to be three wild cards face up.
     * @return - the next TrainCard that is going to be displayed, or null if the deck is empty.
     */
    public TrainCard peek(int loc) {
        if (isEmpty()) {
            return null;
        }
        return deck.get(loc);
    }

    /**
     * This method sees if the deck has any TrainCards left in it.
     * @return - true if there are no cards left, false if there is a card
     */
    public boolean isEmpty()
    {
        if(deck.size() == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * This constructor creates a deck of 110 cards of the appropriate amount 
     * of cards, then proceeds shuffle the deck.
     */
    public DeckOfCards()
    {


        for(int color = 0; color < 9; color++)
        {
            int loco = 0;
            if(color == 8)
            {
                loco = 2;
            }
            for(int index = 0; index < 12 + loco; index++)
            {
                enqueue(new TrainCard(color));
            }
        }

        Collections.shuffle(deck);
    }
    
    public void print() {
        for(int i = 0; i < discard.size(); i++)
        {
            System.out.println(discard.get(i).getCurrentNum());
        }
    }
    
    /**
     * This method is called to shuffle the discard pile back into the main deck. It then
     * shuffles the main deck. If the discard pile is empty, returns false.
     * @return - true if the discard pile was shuffled into the deck false otherwise
     */
    public boolean reshuffle()
    {
        if(discard.size() == 0)
        {
            return false;
        }
        for(int i = 0; i < discard.size(); i++)
        {
            TrainCard toAdd = discard.get(i);
            deck.add(toAdd);
        }
        Collections.shuffle(deck);
        discard.clear();
        return true;
    }
}
