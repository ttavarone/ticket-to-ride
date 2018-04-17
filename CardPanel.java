public class CardPanel extends JPanel{

    private TrainCard blackTrain;
    private TrainCard blueTrain;
    private TrainCard greenTrain;
    private TrainCard orangeTrain;
    private TrainCard purpleTrain;
    private TrainCard redTrain;
    private TrainCard whiteTrain;
    private TrainCard yellowTrain;
    private TrainCard wildCard;

    private Toolkit toolkit;

    //imgArr = new Image[]{blackTrain, blueTrain, greenTrain, orangeTrain, purpleTrain,
    //        redTrain, whiteTrain, yellowTrain, wildCard};
    public CardPanel(){
        super();
        toolkit = Toolkit.getDefaultToolkit();
        setOpaque(true);
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        add(blackTrain.getTrainCard(0));
        add(blueTrain.getTrainCard(1));
        add(greenTrain.getTrainCard(2));
        add(orangeTrain.getTrainCard(3));
        add(purpleTrain.getTrainCard(4));
        add(redTrain.getTrainCard(5));
        add(whiteTrain.getTrainCard(6));
        add(yellowTrain.getTrainCard(7));
        add(wildCard.getTrainCard(8));

    }

    public void updateCard(TrainCard c){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(blackTrain.getTrainCard(0), );
    }
}
