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

        Player[] players = {new Player(0, Color.RED)};
        
        PlayerHand cPanel = new PlayerHand(players[0], deck);
        GridBagConstraints d = new GridBagConstraints();
        d.anchor = GridBagConstraints.NORTH;
        d.gridx = 1;
        d.gridy = 0;

        DeckOfCardsPanel dPanel = new DeckOfCardsPanel(new PlayerHand[] {cPanel}, deck);
        GridBagConstraints e = new GridBagConstraints();
        e.anchor = GridBagConstraints.SOUTH;
        e.gridx = 1;
        e.gridy = 0;

        TicketCard tPanel = new TicketCard();
        GridBagConstraints f = new GridBagConstraints();
        f.anchor = GridBagConstraints.CENTER;
        f.gridx = 0;
        f.gridy = 1;

        add(bPanel, c);
        add(cPanel, d);
        add(dPanel, e);
        add(tPanel, f);
    }
}
