////////////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * This method creates a single instance of one of the train cards a
 * player would draw.
 * 
 * @author Logan Brandt, Tucker Tavarone, Tom Fresenius, 
 * Eamonn Conway, Josh DelSignore 
 * @version 1.0
 */
public class TrainCard
{
    protected int cardNum;
    protected Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Image[] imgArr;
    //All the different trains.
    private Image blackTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"BlackCard.jpg");
    private Image blueTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"BlueCard.jpg");
    private Image greenTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"GreenCard.jpg");
    private Image orangeTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"OrangeCard.jpg");
    private Image pinkTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"PurpleCard.jpg");
    private Image redTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"RedCard.jpg");
    private Image whiteTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"WhiteCard.jpg");
    private Image yellowTrain = toolkit.getImage("TicketToRidePics"+
        File.separator+"YellowCard.jpg");
    private Image wildCard = toolkit.getImage("TicketToRidePics"+
        File.separator+"RainbowCard.jpg");

    /**
     * This method initializes the TrainCard with the type of
     * train the card has.
     * @param newCardType - The type of train portrayed on the card
     */
    TrainCard(int newCardNum)
    {
        cardNum = newCardNum;
        
        imgArr = new Image[]{blackTrain, blueTrain, greenTrain, 
                orangeTrain, pinkTrain,redTrain, whiteTrain, 
                yellowTrain, wildCard};

        imgArr[newCardNum] = imgArr[newCardNum].getScaledInstance(
            70, 118, Image.SCALE_FAST);
    }
    
    /**
     * This method returns the current Image of the object.
     * @return - the train in use by this object
     */
    public Image getTrainCard()
    {
        return imgArr[cardNum];
    }
    
    /**
     * This method returns the current index in the imgArr of this object,
     * which gets you the image you want to use as an int.
     * @return - current index in imgArr of the object.
     */
    public int getCurrentNum()
    {
        return cardNum;
    }
}
