////////////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    protected Toolkit toolkit;
    private Image[] imgArr;
    private Image blackTrain = toolkit.getImage("TicketToRidePics\\BlackCard");
    private Image blueTrain = toolkit.getImage("TicketToRidePics\\BlueCard");
    private Image greenTrain = toolkit.getImage("TicketToRidePics\\GreenCard");
    private Image orangeTrain = toolkit.getImage("TicketToRidePics\\OrangeCard");
    private Image purpleTrain = toolkit.getImage("TicketToRidePics\\PurpleCard");
    private Image redTrain = toolkit.getImage("TicketToRidePics\\RedCard");
    private Image whiteTrain = toolkit.getImage("TicketToRidePics\\WhiteCard");
    private Image yellowTrain = toolkit.getImage("TicketToRidePics\\YellowCard");
    private Image wildCard = toolkit.getImage("TicketToRidePics\\RainbowCard");

    /**
     * This method initializes the TrainCard with the type of
     * train the card has.
     * @param newCardType - The type of train portrayed on the card
     */
    TrainCard(int newCardNum)
    {
        cardNum = newCardNum;
        
        imgArr = new Image[]{blackTrain, blueTrain, greenTrain, orangeTrain, purpleTrain,
        redTrain, whiteTrain, yellowTrain, wildCard};
        
    }
    
    public Image getTrainCard()
    {
        return imgArr[cardNum];
    }
}
