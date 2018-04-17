import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class TicketDeck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicketDeck
{
    private static ArrayList<TicketCard> ticketcardsDeck = new ArrayList<TicketCard>();
    protected Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static String[] cityNames = new String[39];
    private static ArrayList<TicketCard> shortRoutesDeck = new ArrayList<TicketCard>();
    private static ArrayList<TicketCard> longRoutesDeck = new ArrayList<TicketCard>();
    
    public TicketDeck(){
        ticketcardsDeck.add(new TicketCard("Berlin", "Chemnitz","short", 6, toolkit.getImage("TicketToRidePics\\BerlChem")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Dusseldorf", "long", 13, toolkit.getImage("TicketToRidePics\\BerlDuss")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Erfurt", "short",  7, toolkit.getImage("TicketToRidePics\\BurlErfu")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Frankfurt","long", 14, toolkit.getImage("TicketToRidePics\\BerlFran")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Koln","long", 14, toolkit.getImage("TicketToRidePics\\BerlKoln")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Leipzig", "short", 4, toolkit.getImage("TicketToRidePics\\BerlLeip")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Mainz", "long", 15, toolkit.getImage("TicketToRidePics\\BerlMain")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Munchen","long", 15, toolkit.getImage("TicketToRidePics\\BerlMunc")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Schweiz", "long", 20, toolkit.getImage("TicketToRidePics\\BerlSchw")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Stuttgart", "long", 18, toolkit.getImage("TicketToRidePics\\BerlStut")));
        ticketcardsDeck.add(new TicketCard("Bremen", "Berlin", "short", 10, toolkit.getImage("TicketToRidePics\\BremBerl")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Dusseldorf", "short", 5, toolkit.getImage("TicketToRidePics\\BremDuss")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven", "Frankreich", "long", 12, toolkit.getImage("TicketToRidePics\\BremFran")));
        ticketcardsDeck.add(new TicketCard("Bremen", "Kassel", "short", 6, toolkit.getImage("TicketToRidePics\\BremKass")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven", "koln", "short", 7, toolkit.getImage("TicketToRidePics\\BremKoln")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven", "Regensburg", "long", 16, toolkit.getImage("TicketToRidePics\\BremRege")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Berlin", "short", 10, toolkit.getImage("TicketToRidePics\\DaneBerl")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Lindau", "long", 22, toolkit.getImage("TicketToRidePics\\DaneLind")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Niederlande", "short",10, toolkit.getImage("TicketToRidePics\\DaneNied")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Erfurt", "short", 7, toolkit.getImage("TicketToRidePics\\DortErfu")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Magdeburg", "short", 9, toolkit.getImage("TicketToRidePics\\DortMagd")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Mannheim", "short", 6, toolkit.getImage("TicketToRidePics\\DortMann")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Munchen", "long", 13, toolkit.getImage("TicketToRidePics\\DortMunc")));
        ticketcardsDeck.add(new TicketCard("Dresden", "Augsburg", "long", 12, toolkit.getImage("TicketToRidePics\\DresAugs")));
        ticketcardsDeck.add(new TicketCard("Dresden", "Saarbrucken", "long", 16, toolkit.getImage("TicketToRidePics\\DresSaar")));
        ticketcardsDeck.add(new TicketCard("Dusseldorf", "Konstanz", "short", 10, toolkit.getImage("TicketToRidePics\\DussKons")));
        ticketcardsDeck.add(new TicketCard("Emden", "Freiburg", "long", 15, toolkit.getImage("TicketToRidePics\\EmdeFrei")));
        ticketcardsDeck.add(new TicketCard("Emden", "hamburg", "short", 6, toolkit.getImage("TicketToRidePics\\EmdeHamb")));
        //two paths
        ticketcardsDeck.add(new TicketCard("Emden", "Osterreich", "short", 20, toolkit.getImage("TicketToRidePics\\EmdeOste")));
        ticketcardsDeck.add(new TicketCard("Erfurt", "Wurzburg", "short", 6, toolkit.getImage("TicketToRidePics\\ErfuWurz")));
        ticketcardsDeck.add(new TicketCard("Frankreich", "Danemark", "long", 17, toolkit.getImage("TicketToRidePics\\FranDane")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Munchen", "short", 9, toolkit.getImage("TicketToRidePics\\FrankfMunc")));
        ticketcardsDeck.add(new TicketCard("Frankreich", "Munchen", "short", 8, toolkit.getImage("TicketToRidePics\\FrankrMunc")));
        ticketcardsDeck.add(new TicketCard("Frankreich", "Leipzig", "long", 15, toolkit.getImage("TicketToRidePics\\FranLeip")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Lindau", "short", 8, toolkit.getImage("TicketToRidePics\\FranLind")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Osterreich", "short", 10, toolkit.getImage("TicketToRidePics\\FranOste")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Stuttgart", "short", 4, toolkit.getImage("TicketToRidePics\\FranStut")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Berlin", "short", 7, toolkit.getImage("TicketToRidePics\\HambBerl")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Dresden", "long", 12, toolkit.getImage("TicketToRidePics\\HambDres")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Frankfurt", "short", 11, toolkit.getImage("TicketToRidePics\\HambFran")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Karlsruhe", "long", 14, toolkit.getImage("TicketToRidePics\\HambKarl")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Kassel", "short", 7, toolkit.getImage("TicketToRidePics\\HambKass")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Koblenz", "short", 10, toolkit.getImage("TicketToRidePics\\HambKobl")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Koln", "short", 9, toolkit.getImage("TicketToRidePics\\HambKoln")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Leipzig", "short", 10, toolkit.getImage("TicketToRidePics\\HambLeip")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Munchen", "long", 18, toolkit.getImage("TicketToRidePics\\HambMunc")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Rostock", "short", 4, toolkit.getImage("TicketToRidePics\\HambRost")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Stuttgart", "long", 15, toolkit.getImage("TicketToRidePics\\HambStut")));
        ticketcardsDeck.add(new TicketCard("Hannover", "Frankfurt", "short", 7, toolkit.getImage("TicketToRidePics\\HannFran")));
        ticketcardsDeck.add(new TicketCard("Hannover", "Leipzig", "short", 6, toolkit.getImage("TicketToRidePics\\HannLeip")));
        ticketcardsDeck.add(new TicketCard("Hannover", "Saarbrucken", "short", 11, toolkit.getImage("TicketToRidePics\\HannSaar")));
        ticketcardsDeck.add(new TicketCard("Karlsruhe", "Augsburg", "short", 4, toolkit.getImage("TicketToRidePics\\KarlAugs")));
        ticketcardsDeck.add(new TicketCard("Karlsruhe", "Regensburg", "short", 9, toolkit.getImage("TicketToRidePics\\KarlRege")));
        ticketcardsDeck.add(new TicketCard("Kassel", "Freiburg", "short", 10, toolkit.getImage("TicketToRidePics\\KassFrei")));
        ticketcardsDeck.add(new TicketCard("Keil", "Nurnberg", "long", 15, toolkit.getImage("TicketToRidePics\\KielNurn")));
        ticketcardsDeck.add(new TicketCard("Keil", "Schweiz", "long", 20, toolkit.getImage("TicketToRidePics\\KielSchw")));
        ticketcardsDeck.add(new TicketCard("Keil", "Stuttgart", "long", 17, toolkit.getImage("TicketToRidePics\\KielStut")));
        ticketcardsDeck.add(new TicketCard("Koblenz", "Ulm", "short", 7, toolkit.getImage("TicketToRidePics\\KoblUlm")));
        ticketcardsDeck.add(new TicketCard("Koln", "Frankfurt", "short", 4, toolkit.getImage("TicketToRidePics\\KolnFran")));
        ticketcardsDeck.add(new TicketCard("Koln", "Leipzig", "long", 12, toolkit.getImage("TicketToRidePics\\KolnLeip")));
        ticketcardsDeck.add(new TicketCard("Koln", "Munchen", "short", 11, toolkit.getImage("TicketToRidePics\\KolnMunc")));
        ticketcardsDeck.add(new TicketCard("Koln", "Nurnberg", "short", 8, toolkit.getImage("TicketToRidePics\\KolnNurn")));
        ticketcardsDeck.add(new TicketCard("Koln", "Regensburg", "short", 11, toolkit.getImage("TicketToRidePics\\KolnRege")));
        ticketcardsDeck.add(new TicketCard("Koln", "Saarbrucken", "short", 4, toolkit.getImage("TicketToRidePics\\KolnSaar")));
        ticketcardsDeck.add(new TicketCard("Koln", "Schweiz", "short", 10, toolkit.getImage("TicketToRidePics\\KolnSchw")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Munchen", "short", 11, toolkit.getImage("TicketToRidePics\\LeipMunc")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Stuttgart", "long", 14, toolkit.getImage("TicketToRidePics\\LeipStut")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Ulm", "long", 12, toolkit.getImage("TicketToRidePics\\LeipUlm")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Frankfurt", "short", 10, toolkit.getImage("TicketToRidePics\\LiepFran")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Nurnberg", "short", 7, toolkit.getImage("TicketToRidePics\\LiepNurn")));
        ticketcardsDeck.add(new TicketCard("Magdeburg", "Koln", "short", 11, toolkit.getImage("TicketToRidePics\\MagdKoln")));
        ticketcardsDeck.add(new TicketCard("Mainz", "Stuttgart", "short", 3, toolkit.getImage("TicketToRidePics\\MainStut")));
        ticketcardsDeck.add(new TicketCard("Mannheim", "Stuttgart", "short", 2, toolkit.getImage("TicketToRidePics\\MannStut")));
        ticketcardsDeck.add(new TicketCard("Mannheim", "Wurzburg", "short", 4, toolkit.getImage("TicketToRidePics\\MannWurz")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Freiburg", "short", 8, toolkit.getImage("TicketToRidePics\\MuncFrei")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Konstanz", "short", 6, toolkit.getImage("TicketToRidePics\\MuncKons")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Stuttgart", "short", 5, toolkit.getImage("TicketToRidePics\\MuncStut")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Wurzburg", "short", 7, toolkit.getImage("TicketToRidePics\\MuncWurz")));
        ticketcardsDeck.add(new TicketCard("Munster", "Munchen", "long", 14, toolkit.getImage("TicketToRidePics\\MunsMunc")));
        //two paths
        ticketcardsDeck.add(new TicketCard("Munster", "Osterreich", "long", 15, toolkit.getImage("TicketToRidePics\\MunsOste")));
        ticketcardsDeck.add(new TicketCard("Munster", "Stuttgart", "short", 9, toolkit.getImage("TicketToRidePics\\MunsStut")));
        ticketcardsDeck.add(new TicketCard("Niederlande", "Berlin", "long", 13, toolkit.getImage("TicketToRidePics\\NiedBerl")));
        ticketcardsDeck.add(new TicketCard("Niederlande", "Frankfurt", "short", 8, toolkit.getImage("TicketToRidePics\\NiedFran")));
        ticketcardsDeck.add(new TicketCard("Niederlande", "Karlsruhe", "short", 9, toolkit.getImage("TicketToRidePics\\NiedKarl")));
        ticketcardsDeck.add(new TicketCard("Nurnberg", "Stuttgart", "short", 7, toolkit.getImage("TicketToRidePics\\NurnStut")));
        ticketcardsDeck.add(new TicketCard("Rostock", "Konstanz", "long", 22, toolkit.getImage("TicketToRidePics\\RostKons")));
        ticketcardsDeck.add(new TicketCard("Rostock", "Osterreich", "long", 22, toolkit.getImage("TicketToRidePics\\RostOste")));
        ticketcardsDeck.add(new TicketCard("Schwerin", "Koblenz", "long", 12, toolkit.getImage("TicketToRidePics\\SchKob")));
        ticketcardsDeck.add(new TicketCard("Schwerin", "Frankfurt", "long", 13, toolkit.getImage("TicketToRidePics\\SchwFran")));
        
        for(TicketCard t: ticketcardsDeck){
            if(t.getLength().equals("short")){
                shortRoutesDeck.add(t);
            }
            else{
                longRoutesDeck.add(t);
            }
        }
        
        Collections.shuffle(shortRoutesDeck);
        Collections.shuffle(longRoutesDeck);
    }
    
    /*public TicketCard[] shuffle(){
        Random rand = new Random();
        for(int i = 0; i < ticketCardsDeck.length; i++){
            //int randomPos = rand.nextInt(ticketCardsDeck.length);
            //TicketCard temp = ticketcardsDeck.add();
            //ticketcardsDeck.add(iticketcardsDeck.add(randomPos];
            //ticketcardsDeck.add(randomPostemp);
        }
        return ticketCardsDeck;
    }*/
    
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
