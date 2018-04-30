////////////////////////////////////////////////////////////////////////////////
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class for the colored passengers placed at each city and taken at the 
 * end of a turn when a connection is made. We did not have time to implement 
 * this class into the game.
 *
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore, 
 * Tom, Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public class Passenger
{
    Color red, black, white, blue, yellow, green;
    ArrayList<Color> remainingToPlace; //number remaining that can be placed
    ArrayList<Color> remainingOnBoard; //number remaining on board

    /**
     * Default constructor for the Passenger class. Fills the array of
     * meeples to be placed on the board.
     */
    Passenger(){
        red = new Color(255,0,0);
        black = new Color(0,0,0);
        white = new Color(255,0,0);
        blue = new Color(0,0,255);
        yellow = new Color(255,255,0);
        green = new Color(0,255,0);

        remainingToPlace = new ArrayList<Color>();
        remainingOnBoard = new ArrayList<Color>();
        for(int i = 0; i < 10; i++){
            remainingToPlace.add(red);
            remainingToPlace.add(black);
            remainingToPlace.add(white);
            remainingToPlace.add(blue);
            remainingToPlace.add(yellow);
            remainingToPlace.add(green);
        }
    }

    /**
     * Places number of people in the city
     * @param num - the number of people to be put in the city
     */
    public void place(int num){
        Random rand = new Random();
        for(int i = 0; i < num; i++){
            int index = rand.nextInt(remainingToPlace.size());

            //add person to city using (remainingToPlace(index));

            remainingOnBoard.add(remainingToPlace.get(index));
            remainingToPlace.remove(index);
        }
    }

    /**
     * Takes the person and adds to the player's stack
     * @param c - color to take
     */
    public void take(Player p, Color c){
        for(int i = 0; i < remainingOnBoard.size(); i++){
            if(remainingOnBoard.get(i).equals(c)){

                if(c.equals(red)){
                    p.redMeeple++;
                }
                else if(c.equals(black)){
                    p.blackMeeple++;
                }
                else if(c.equals(white)){
                    p.whiteMeeple++;
                }
                else if(c.equals(blue)){
                    p.blueMeeple++;
                }
                else if(c.equals(yellow)){
                    p.yellowMeeple++;
                }
                else if(c.equals(green)){
                    p.greenMeeple++;
                }
                
                //remove from city once city class is created
                
                remainingOnBoard.remove(i);
            }
        }
    }
}
