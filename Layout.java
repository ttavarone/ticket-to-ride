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

        DeckOfCardsPanel dPanel = new DeckOfCardsPanel();
        GridBagConstraints e = new GridBagConstraints();
        e.anchor = GridBagConstraints.SOUTH;
        e.gridx = 850;
        e.gridy = 0;
        e.ipadx = 10;
        e.ipady = 10;

        add(bPanel, c);
        add(cPanel, d);
        add(dPanel, e);
    }
}
