import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class for the people placed at each city
 *
 * @author Tom, Eamonn, Logan, Tucker, and Josh
 * @version 4/13/18
 */
public class People implements MouseListener
{
    Color red, black, white, blue, yellow, green;
    ArrayList<Color> remainingToPlace; //number remaining that can be placed
    ArrayList<Color> remainingOnBoard; //number remaining on board

    People(){
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
    public void take(Color c){
        for(int i = 0; i < remainingOnBoard.size(); i++){
            if(remainingOnBoard.get(i).equals(c)){
                                
                //add to person's stack of people 
                
                remainingOnBoard.remove(i);
            }
        }
    }
    
    // dont need yet but just incase
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }
}
