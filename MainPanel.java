import javax.swing.*;
import java.awt.*;

/**
 * Put all the JPanel objects in here
 */
public class MainPanel extends JPanel{


    public MainPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 875));


        BoardPanel bPanel = new BoardPanel();
        PlayerHand cPanel = new PlayerHand(null);

        add(bPanel, BorderLayout.WEST);
        add(cPanel, BorderLayout.CENTER);
    }

}
