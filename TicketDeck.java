import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class TicketDeck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicketDeck
{
    private static TicketCard[] ticketCardsDeck = new TicketCard[89];
    protected Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static String[] cityNames = new String[39];
    
    public TicketDeck(){
        // long cards
        ticketCardsDeck[0] = new TicketCard("Berlin", "Chemnitz","short", 6, toolkit.getImage("TicketToRidePics\\BerlChem"));
        ticketCardsDeck[1] = new TicketCard("Berlin", "Dusseldorf", "long", 13, toolkit.getImage("TicketToRidePics\\BerlChem"));
        ticketCardsDeck[2] = new TicketCard("Berlin", "Erfurt", "short",  7, toolkit.getImage("TicketToRidePics\\BerlChem"));
        ticketCardsDeck[3] = new TicketCard("Berlin", "Frankfurt","long", 14);
        ticketCardsDeck[4] = new TicketCard("Berlin", "Koln","long", 14);
        ticketCardsDeck[5] = new TicketCard("Berlin", "Leipzig", "short", 4);
        ticketCardsDeck[6] = new TicketCard("Berlin", "Mainz", "long", 15);
        ticketCardsDeck[7] = new TicketCard("Berlin", "Munchen","long", 15);
        ticketCardsDeck[8] = new TicketCard("Berlin", "Schweiz", "long", 20);
        ticketCardsDeck[8] = new TicketCard("Berlin", "Stuttgart", "long", 18);
        ticketCardsDeck[8] = new TicketCard("Bremen", "Berlin", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Berlin", "Dusseldorf", "short", 5);
        ticketCardsDeck[8] = new TicketCard("Bremerhaven", "Frankreich", "long", 12);
        ticketCardsDeck[8] = new TicketCard("Bremen", "Kassel", "short", 6);
        ticketCardsDeck[8] = new TicketCard("Bremerhaven", "koln", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Bremerhaven", "Regensburg", "long", 16);
        ticketCardsDeck[8] = new TicketCard("Danemark", "Berlin", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Danemark", "Lindau", "long", 22);
        ticketCardsDeck[8] = new TicketCard("Danemark", "Niederlande", "short",10);
        ticketCardsDeck[8] = new TicketCard("Dortmund", "Erfurt", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Dortmund", "Magdeburg", "short", 9);
        ticketCardsDeck[8] = new TicketCard("Dortmund", "Mannheim", "short", 6);
        ticketCardsDeck[8] = new TicketCard("Dortmund", "Munchen", "long", 13);
        ticketCardsDeck[8] = new TicketCard("Dresden", "Augsburg", "long", 12);
        ticketCardsDeck[8] = new TicketCard("Dresden", "Saarbrucken", "long", 16);
        ticketCardsDeck[8] = new TicketCard("Dusseldorf", "Konstanz", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Emden", "Freiburg", "long", 15);
        ticketCardsDeck[8] = new TicketCard("Emden", "hamburg", "short", 6);
        ticketCardsDeck[8] = new TicketCard("Emden", "Osterreich", "short", 20);//two paths
        ticketCardsDeck[8] = new TicketCard("Erfurt", "Wurzburg", "short", 6);
        ticketCardsDeck[8] = new TicketCard("Frankreich", "Danemark", "long", 17);
        ticketCardsDeck[8] = new TicketCard("Frankfurt", "Munchen", "short", 9);
        ticketCardsDeck[8] = new TicketCard("Frankreich", "Munchen", "short", 8);
        ticketCardsDeck[8] = new TicketCard("Frankreich", "Leipzig", "long", 15);
        ticketCardsDeck[8] = new TicketCard("Frankfurt", "Lindau", "short", 8);
        ticketCardsDeck[8] = new TicketCard("Frankfurt", "Osterreich", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Frankfurt", "Stuttgart", "short", 4);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Berlin", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Dresden", "long", 12);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Frankfurt", "short", 11);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Karlsruhe", "long", 14);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Kassel", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Koblenz", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Koln", "short", 9);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Leipzig", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Munchen", "long", 18);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Rostock", "short", 4);
        ticketCardsDeck[8] = new TicketCard("Hamburg", "Stuttgart", "long", 15);
        ticketCardsDeck[8] = new TicketCard("Hannover", "Frankfurt", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Hannover", "Leipzig", "short", 6);
        ticketCardsDeck[8] = new TicketCard("Hannover", "Saarbrucken", "short", 11);
        ticketCardsDeck[8] = new TicketCard("Karlsruhe", "Augsburg", "short", 4);
        ticketCardsDeck[8] = new TicketCard("Karlsruhe", "Regensburg", "short", 9);
        ticketCardsDeck[8] = new TicketCard("Kassel", "Freiburg", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Keil", "Nurnberg", "long", 15);
        ticketCardsDeck[8] = new TicketCard("Keil", "Schweiz", "long", 20);
        ticketCardsDeck[8] = new TicketCard("Keil", "Stuttgart", "long", 17);
        ticketCardsDeck[8] = new TicketCard("Koblenz", "Ulm", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Koln", "Frankfurt", "short", 4);
        ticketCardsDeck[8] = new TicketCard("Koln", "Leipzig", "long", 12);
        ticketCardsDeck[8] = new TicketCard("Koln", "Munchen", "short", 11);
        ticketCardsDeck[8] = new TicketCard("Koln", "Nurnberg", "short", 8);
        ticketCardsDeck[8] = new TicketCard("Koln", "Regensburg", "short", 11);
        ticketCardsDeck[8] = new TicketCard("Koln", "Saarbrucken", "short", 4);
        ticketCardsDeck[8] = new TicketCard("Koln", "Schweiz", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Leipzig", "Munchen", "short", 11);
        ticketCardsDeck[8] = new TicketCard("Leipzig", "Stuttgart", "long", 14);
        ticketCardsDeck[8] = new TicketCard("Leipzig", "Ulm", "long", 12);
        ticketCardsDeck[8] = new TicketCard("Leipzig", "Frankfurt", "short", 10);
        ticketCardsDeck[8] = new TicketCard("Leipzig", "Nurnberg", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Magdeburg", "Koln", "short", 11);
        ticketCardsDeck[8] = new TicketCard("Mainz", "Stuttgart", "short", 3);
        ticketCardsDeck[8] = new TicketCard("Mannheim", "Stuttgart", "short", 2);
        ticketCardsDeck[8] = new TicketCard("Mannheim", "Wurzburg", "short", 4);
        ticketCardsDeck[8] = new TicketCard("Munchen", "Freiburg", "short", 8);
        ticketCardsDeck[8] = new TicketCard("Munchen", "Konstanz", "short", 6);
        ticketCardsDeck[8] = new TicketCard("Munchen", "Stuttgart", "short", 5);
        ticketCardsDeck[8] = new TicketCard("Munchen", "Wurzburg", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Munster", "Munchen", "long", 14);
        ticketCardsDeck[8] = new TicketCard("Munster", "Osterreich", "long", 15);//two paths
        ticketCardsDeck[8] = new TicketCard("Munster", "Stuttgart", "short", 9);
        ticketCardsDeck[8] = new TicketCard("Niederlande", "Berlin", "long", 13);
        ticketCardsDeck[8] = new TicketCard("Niederlande", "Frankfurt", "short", 8);
        ticketCardsDeck[8] = new TicketCard("Niederlande", "Karlsruhe", "short", 9);
        ticketCardsDeck[8] = new TicketCard("Nurnberg", "Stuttgart", "short", 7);
        ticketCardsDeck[8] = new TicketCard("Rostock", "Konstanz", "long", 22);
        ticketCardsDeck[8] = new TicketCard("Rostock", "Osterreich", "long", 22);
        ticketCardsDeck[8] = new TicketCard("Schwerin", "Koblenz", "long", 12);
        ticketCardsDeck[8] = new TicketCard("Schwerin", "Frankfurt", "long", 13);
    }
    
    public TicketCard[] shuffle(){
        Random rand = new Random();
        for(int i = 0; i < ticketCardsDeck.length; i++){
            int randomPos = rand.nextInt(ticketCardsDeck.length);
            TicketCard temp = ticketCardsDeck[i];
            ticketCardsDeck[i] = ticketCardsDeck[randomPos];
            ticketCardsDeck[randomPos] = temp;
        }
        return ticketCardsDeck;
    }
    
    public void names(){
        cityNames[0] = "Osterreich";
        cityNames[1] = "Munchen";
        cityNames[2] = "Lindau";
        cityNames[3] = "Konstanz";
        cityNames[4] = "Schweiz";
        cityNames[5] = "Freiburg";
        cityNames[6] = "Franbreich";
        cityNames[7] = "Saarbrucken";
        cityNames[8] = "Karlsruhe";
        cityNames[9] = "Manheim";
        cityNames[10] = "Stuttgart";
        cityNames[11] = "Augsburg";
        cityNames[12] = "Regensburg";
        cityNames[13] = "Nurnberg";
        cityNames[14] = "Wurzburg";
        cityNames[15] = "Frankfurt";
        cityNames[16] = "Mainz";
        cityNames[17] = "Koblenz";
        cityNames[18] = "Koln";
        cityNames[19] = "Dusseldorf";
        cityNames[20] = "Kassel";
        cityNames[21] = "Erfurt";
        cityNames[22] = "Chemnitz";
        cityNames[23] = "Leipzig";
        cityNames[24] = "Dresden";
        cityNames[25] = "Dortmund";
        cityNames[26] = "Munster";
        cityNames[27] = "Magdeburg";
        cityNames[28] = "Berlin";
        cityNames[29] = "Hannover";
        cityNames[30] = "Niederlande";
        cityNames[31] = "Bremen";
        cityNames[32] = "Hamburg";
        cityNames[33] = "Schwerin";
        cityNames[34] = "Bremerhaven";
        cityNames[35] = "Emden";
        cityNames[36] = "Kiel";
        cityNames[37] = "Rostock";
        cityNames[38] = "Danemark";
    }
    
    public static void main(String args[]){
    }
}
