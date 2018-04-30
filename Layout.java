import javax.swing.*;
import java.awt.*;

/**
 * This method places on the JPanels on the screen in an ordered way
 * 
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore, 
 * Tom, Fresenius, Eamonn Conway)
 * @version (1.0)
 */
public class Layout extends JPanel {
    /**
     * This constructor cretates the board state, putting all of the
     * JPanel objects onto locations on the board.
     */
    public Layout() {
        setLayout(new GridBagLayout());

        DeckOfCards deck = new DeckOfCards();

        BasePanel baseline = new BasePanel();

        Player[] players = {new Player(0, Color.RED), 
                new Player(1, Color.BLUE)};

        PlayerHand cPanela = new PlayerHand(players[0], deck);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 0;
        add(cPanela, c);
        
        PlayerHand cPanelb = new PlayerHand(players[1], deck);
        add(cPanelb, c);

        PlayerTicketsa hPanela = new PlayerTicketsa(players[0]);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 1;
        c.gridy = 0;
        add(hPanela, c);
        
        PlayerTicketsb hPanelb = new PlayerTicketsb(players[1]);
        c.anchor = GridBagConstraints.NORTHEAST;
        c.gridx = 1;
        c.gridy = 0;
        add(hPanelb, c);

        TicketDeck t = new TicketDeck();

        PlayerHand[] playerHands = new PlayerHand[]{cPanela, cPanelb};

        BoardPanel bPanel = new BoardPanel(playerHands, hPanela, hPanelb, baseline, deck);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        add(bPanel, c);

        TicketDeckPanel tPanel = new TicketDeckPanel(t, playerHands, 
            hPanela, hPanelb, baseline);
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 0;
        add(tPanel, c);

        DeckOfCardsPanel dPanel = new DeckOfCardsPanel(playerHands, 
            deck, hPanela, hPanelb, baseline);
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 1;
        c.gridy = 0;
        add(dPanel, c);
    }
}
