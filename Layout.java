import javax.swing.*;
import java.awt.*;

/**
 * Put all the JPanel objects in here
 */
public class Layout extends JPanel {


    public Layout() {

        setLayout(new BorderLayout());
        //setPreferredSize(new Dimension(1200, 875));


        BoardPanel bPanel = new BoardPanel();
        PlayerHand cPanel = new PlayerHand(null);
        DeckOfCards dPanel = new DeckOfCards();

        add(bPanel, BorderLayout.WEST);
        add(cPanel, BorderLayout.NORTH);
        add(dPanel, BorderLayout.CENTER);
    }

}
