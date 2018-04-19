import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

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

    public CardPanel(){
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
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

        setPreferredSize(new Dimension(160, 256));
    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(blackTrain.getTrainCard(), 600, 50, this);
        g.drawImage(blueTrain.getTrainCard(), 600, 178, this);
        g.drawImage(greenTrain.getTrainCard(), 600, 306, this);
        g.drawImage(orangeTrain.getTrainCard(), 680, 50, this);
        g.drawImage(purpleTrain.getTrainCard(), 680, 178, this);
        g.drawImage(redTrain.getTrainCard(), 680, 306, this);
        g.drawImage(whiteTrain.getTrainCard(), 760, 50, this);
        g.drawImage(yellowTrain.getTrainCard(), 760, 178, this);
        g.drawImage(wildCard.getTrainCard(), 760, 306, this);

        /*
        The following statements create little black boxes that contain
        a number that represents how many of the card a player has
         */
        g.setColor(Color.BLACK);
        g.fillRect(600, 50, 25, 25);//black
        g.fillRect(600, 178, 25, 25);
        g.fillRect(600, 306, 25, 25);
        g.fillRect(680, 50, 25, 25);
        g.fillRect(680, 178, 25, 25);
        g.fillRect(680, 306, 25, 25);
        g.fillRect(760, 50, 25, 25);
        g.fillRect(760, 178, 25, 25);//yellow
        g.fillRect(760, 306, 25, 25);//wild

        /*
        The following statements put the numbers in the black boxes
        that will be strings that update according to the cards a player
        has in their 'hand'
         */

        g.setColor(Color.BLUE);
        g.drawString("1", 650, 50);//blackcard

    }
}
