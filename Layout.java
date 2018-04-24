import javax.swing.*;
import java.awt.*;

/**
 * Put all the JPanel objects in here
 */
public class Layout extends JPanel {
    public Layout() {

        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(1200, 875));

        DeckOfCards deck = new DeckOfCards();
        
        BoardPanel bPanel = new BoardPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 10;
        c.ipady = 10;

        Player[] players = {new Player(0, Color.RED)};
        
        PlayerHand cPanel = new PlayerHand(players[0], deck);
        //CardsPanel cPanel = new CardsPanel(players[0]);
        GridBagConstraints d = new GridBagConstraints();
        d.anchor = GridBagConstraints.NORTH;
        d.gridx = 850;
        d.gridy = 0;
        d.ipadx = 10;
        d.ipady = 10;

        DeckOfCardsPanel dPanel = new DeckOfCardsPanel(new PlayerHand[] {cPanel}, deck);
        GridBagConstraints e = new GridBagConstraints();
        e.anchor = GridBagConstraints.SOUTH;
        e.gridx = 850;
        e.gridy = 0;
        e.ipadx = 10;
        e.ipady = 10;

        JPanel temp = new JPanel();
        temp.setPreferredSize(new Dimension(150, 150));
        temp.setOpaque(true);
        temp.setBackground(Color.WHITE);
        GridBagConstraints f = new GridBagConstraints();
        f.anchor = GridBagConstraints.CENTER;
        f.gridx = 850;

        add(bPanel, c);
        add(cPanel, d);
        add(dPanel, e);
        add(temp, f);
    }
}
