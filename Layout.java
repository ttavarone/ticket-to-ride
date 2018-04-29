import javax.swing.*;
import java.awt.*;

/**
 * Put all the JPanel objects in here
 */
public class Layout extends JPanel {
    TicketDeckPanel tPanel;
    public Layout() {
        setLayout(new GridBagLayout());
        //setPreferredSize(new Dimension(1200, 875));

        DeckOfCards deck = new DeckOfCards();

        BasePanel baseline = new BasePanel();

        Player[] players = {new Player(0, Color.RED), new Player(1, Color.BLUE)};

        PlayerHand cPanelb = new PlayerHand(players[1], deck);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.gridy = 0;
        add(cPanelb, c);
        
        PlayerHand cPanela = new PlayerHand(players[0], deck);
        add(cPanela, c);

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

        TicketDeckPanel tPanel = new TicketDeckPanel(t, playerHands, hPanela, hPanelb, baseline);
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 0;
        add(tPanel, c);

        DeckOfCardsPanel dPanel = new DeckOfCardsPanel(playerHands, deck, hPanela, hPanelb, baseline);
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 1;
        c.gridy = 0;
        add(dPanel, c);
    }
    
    public Layout(PlayerHand[] p)
    {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1200, 875));
        EndGamePanel eGame = new EndGamePanel(p);
        
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        add(eGame, c);
    }
}
