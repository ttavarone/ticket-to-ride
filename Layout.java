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
        add(bPanel, c);

        Player[] players = {new Player(0, Color.RED), new Player(1, Color.BLUE)};
        
        PlayerHand cPanela = new PlayerHand(players[0], deck);
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 0;
        add(cPanela, c);
        PlayerHand cPanelb = new PlayerHand(players[1], deck);
        add(cPanelb, c);

        TicketDeck t = new TicketDeck();
        
        PlayerHand[] playerHands = new PlayerHand[]{cPanela, cPanelb};
        
        TicketDeckPanel tPanel = new TicketDeckPanel(t, playerHands);
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 0;
        add(tPanel, c);
        
        DeckOfCardsPanel dPanel = new DeckOfCardsPanel(playerHands, deck);
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 1;
        c.gridy = 0;
        add(dPanel, c);
    }
}
