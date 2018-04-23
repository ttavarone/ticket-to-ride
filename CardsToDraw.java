import java.util.ArrayList;
/**
 * Write a description of class CardsToDraw here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardsToDraw
{
    private ArrayList<TrainCard> toDraw = new ArrayList<TrainCard>();
    public CardsToDraw(DeckOfCards d)
    {
        for(int i = 0; i < 5; i++)
        {
            toDraw.add(d.dequeue());
        }
    }

    public boolean checkValid(DeckOfCards d)
    {
        int wild = 0;
        for(TrainCard tc : toDraw)
        {
            if(tc.getCurrentNum() == 8)
            {
                wild++;
            }
        }
        if(wild >= 3)
        {
            toDraw.clear();
            for(int i = 0; i < 5; i++)
            {
                if(!d.isEmpty())
                {
                    toDraw.add(d.dequeue());
                }
                else
                {
                    d.reshuffle();
                    if(!d.isEmpty())
                    {
                        toDraw.add(d.dequeue());
                    }
                    else break;
                }
            }
            return false;
        }
        if(toDraw.size() < 5)
        {
            if(!d.isEmpty())
            {
                while(toDraw.size() < 5)
                    toDraw.add(d.dequeue());
            }
            else
            {
                d.reshuffle();
                if(!d.isEmpty())
                {
                    while(toDraw.size() < 5)
                        toDraw.add(d.dequeue());
                }
            }
            return false;
        }
        return true;
    }

    public TrainCard drawCard(DeckOfCards d, int index)
    {
        TrainCard answer = toDraw.remove(index);
        if(!d.isEmpty())
        {
            toDraw.add(d.dequeue());
        }
        else
        {
            d.reshuffle();
            if(!d.isEmpty())
            {
                toDraw.add(d.dequeue());
            }
        }
        return answer;
    }
}
