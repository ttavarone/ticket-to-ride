import javax.swing.*;
import java.awt.*;

/**
 * Put all the JPanel objects in here
 */
public class Layout extends JPanel {


    public Layout() {

        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(1200, 875));

        BoardPanel bPanel = new BoardPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 10;
        c.ipady = 10;

        PlayerHand cPanel = new PlayerHand(null);
        GridBagConstraints d = new GridBagConstraints();
        d.anchor = GridBagConstraints.NORTH;
        d.gridx = 850;
        d.gridy = 0;
        d.ipadx = 10;
        d.ipady = 10;

        DeckOfCards dPanel = new DeckOfCards();
        GridBagConstraints e = new GridBagConstraints();
        e.anchor = GridBagConstraints.SOUTH;

        add(bPanel, c);
        add(cPanel, d);
        add(dPanel, e);
    }

}
