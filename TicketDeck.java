import java.io.File;
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
        ticketcardsDeck.add(new TicketCard("Berlin", "Chemnitz","short", 6, toolkit.getImage("TicketToRidePics"+File.separator+"BerlChem")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Dusseldorf", "long", 13, toolkit.getImage("TicketToRidePics"+File.separator+"BerlDuss")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Erfurt", "short",  7, toolkit.getImage("TicketToRidePics"+File.separator+"BurlErfu")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Frankfurt","long", 14, toolkit.getImage("TicketToRidePics"+File.separator+"BerlFran")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Koln","long", 14, toolkit.getImage("TicketToRidePics"+File.separator+"BerlKoln")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Leipzig", "short", 4, toolkit.getImage("TicketToRidePics"+File.separator+"BerlLeip")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Mainz", "long", 15, toolkit.getImage("TicketToRidePics"+File.separator+"BerlMain")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Munchen","long", 15, toolkit.getImage("TicketToRidePics"+File.separator+""+File.separator+"BerlMunc")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Schweiz", "long", 20, toolkit.getImage("TicketToRidePics"+File.separator+"BerlSchw")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Stuttgart", "long", 18, toolkit.getImage("TicketToRidePics"+File.separator+"BerlStut")));
        ticketcardsDeck.add(new TicketCard("Bremen", "Berlin", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"BremBerl")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Dusseldorf", "short", 5, toolkit.getImage("TicketToRidePics"+File.separator+"BremDuss")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven", "Frankreich", "long", 12, toolkit.getImage("TicketToRidePics"+File.separator+"BremFran")));
        ticketcardsDeck.add(new TicketCard("Bremen", "Kassel", "short", 6, toolkit.getImage("TicketToRidePics"+File.separator+"BremKass")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven", "koln", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"BremKoln")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven", "Regensburg", "long", 16, toolkit.getImage("TicketToRidePics"+File.separator+"BremRege")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Berlin", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"DaneBerl")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Lindau", "long", 22, toolkit.getImage("TicketToRidePics"+File.separator+"DaneLind")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Niederlande", "short",10, toolkit.getImage("TicketToRidePics"+File.separator+"DaneNied")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Erfurt", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"DortErfu")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Magdeburg", "short", 9, toolkit.getImage("TicketToRidePics"+File.separator+"DortMagd")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Mannheim", "short", 6, toolkit.getImage("TicketToRidePics"+File.separator+"DortMann")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Munchen", "long", 13, toolkit.getImage("TicketToRidePics"+File.separator+"DortMunc")));
        ticketcardsDeck.add(new TicketCard("Dresden", "Augsburg", "long", 12, toolkit.getImage("TicketToRidePics"+File.separator+"DresAugs")));
        ticketcardsDeck.add(new TicketCard("Dresden", "Saarbrucken", "long", 16, toolkit.getImage("TicketToRidePics"+File.separator+"DresSaar")));
        ticketcardsDeck.add(new TicketCard("Dusseldorf", "Konstanz", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"DussKons")));
        ticketcardsDeck.add(new TicketCard("Emden", "Freiburg", "long", 15, toolkit.getImage("TicketToRidePics"+File.separator+"EmdeFrei")));
        ticketcardsDeck.add(new TicketCard("Emden", "hamburg", "short", 6, toolkit.getImage("TicketToRidePics"+File.separator+"EmdeHamb")));
        //two paths
        ticketcardsDeck.add(new TicketCard("Emden", "Osterreich", "short", 20, toolkit.getImage("TicketToRidePics"+File.separator+"EmdeOste")));
        ticketcardsDeck.add(new TicketCard("Erfurt", "Wurzburg", "short", 6, toolkit.getImage("TicketToRidePics"+File.separator+"ErfuWurz")));
        ticketcardsDeck.add(new TicketCard("Frankreich", "Danemark", "long", 17, toolkit.getImage("TicketToRidePics"+File.separator+"FranDane")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Munchen", "short", 9, toolkit.getImage("TicketToRidePics"+File.separator+"FrankfMunc")));
        ticketcardsDeck.add(new TicketCard("Frankreich", "Munchen", "short", 8, toolkit.getImage("TicketToRidePics"+File.separator+"FrankrMunc")));
        ticketcardsDeck.add(new TicketCard("Frankreich", "Leipzig", "long", 15, toolkit.getImage("TicketToRidePics"+File.separator+"FranLeip")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Lindau", "short", 8, toolkit.getImage("TicketToRidePics"+File.separator+"FranLind")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Osterreich", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"FranOste")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Stuttgart", "short", 4, toolkit.getImage("TicketToRidePics"+File.separator+"FranStut")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Berlin", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"HambBerl")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Dresden", "long", 12, toolkit.getImage("TicketToRidePics"+File.separator+"HambDres")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Frankfurt", "short", 11, toolkit.getImage("TicketToRidePics"+File.separator+"HambFran")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Karlsruhe", "long", 14, toolkit.getImage("TicketToRidePics"+File.separator+"HambKarl")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Kassel", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"HambKass")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Koblenz", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"HambKobl")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Koln", "short", 9, toolkit.getImage("TicketToRidePics"+File.separator+"HambKoln")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Leipzig", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"HambLeip")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Munchen", "long", 18, toolkit.getImage("TicketToRidePics"+File.separator+"HambMunc")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Rostock", "short", 4, toolkit.getImage("TicketToRidePics"+File.separator+"HambRost")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Stuttgart", "long", 15, toolkit.getImage("TicketToRidePics"+File.separator+"HambStut")));
        ticketcardsDeck.add(new TicketCard("Hannover", "Frankfurt", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"HannFran")));
        ticketcardsDeck.add(new TicketCard("Hannover", "Leipzig", "short", 6, toolkit.getImage("TicketToRidePics"+File.separator+"HannLeip")));
        ticketcardsDeck.add(new TicketCard("Hannover", "Saarbrucken", "short", 11, toolkit.getImage("TicketToRidePics"+File.separator+"HannSaar")));
        ticketcardsDeck.add(new TicketCard("Karlsruhe", "Augsburg", "short", 4, toolkit.getImage("TicketToRidePics"+File.separator+"KarlAugs")));
        ticketcardsDeck.add(new TicketCard("Karlsruhe", "Regensburg", "short", 9, toolkit.getImage("TicketToRidePics"+File.separator+"KarlRege")));
        ticketcardsDeck.add(new TicketCard("Kassel", "Freiburg", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"KassFrei")));
        ticketcardsDeck.add(new TicketCard("Keil", "Nurnberg", "long", 15, toolkit.getImage("TicketToRidePics"+File.separator+"KielNurn")));
        ticketcardsDeck.add(new TicketCard("Keil", "Schweiz", "long", 20, toolkit.getImage("TicketToRidePics"+File.separator+"KielSchw")));
        ticketcardsDeck.add(new TicketCard("Keil", "Stuttgart", "long", 17, toolkit.getImage("TicketToRidePics"+File.separator+"KielStut")));
        ticketcardsDeck.add(new TicketCard("Koblenz", "Ulm", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"KoblUlm")));
        ticketcardsDeck.add(new TicketCard("Koln", "Frankfurt", "short", 4, toolkit.getImage("TicketToRidePics"+File.separator+"KolnFran")));
        ticketcardsDeck.add(new TicketCard("Koln", "Leipzig", "long", 12, toolkit.getImage("TicketToRidePics"+File.separator+"KolnLeip")));
        ticketcardsDeck.add(new TicketCard("Koln", "Munchen", "short", 11, toolkit.getImage("TicketToRidePics"+File.separator+"KolnMunc")));
        ticketcardsDeck.add(new TicketCard("Koln", "Nurnberg", "short", 8, toolkit.getImage("TicketToRidePics"+File.separator+"KolnNurn")));
        ticketcardsDeck.add(new TicketCard("Koln", "Regensburg", "short", 11, toolkit.getImage("TicketToRidePics"+File.separator+"KolnRege")));
        ticketcardsDeck.add(new TicketCard("Koln", "Saarbrucken", "short", 4, toolkit.getImage("TicketToRidePics"+File.separator+"KolnSaar")));
        ticketcardsDeck.add(new TicketCard("Koln", "Schweiz", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"KolnSchw")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Munchen", "short", 11, toolkit.getImage("TicketToRidePics"+File.separator+"LeipMunc")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Stuttgart", "long", 14, toolkit.getImage("TicketToRidePics"+File.separator+"LeipStut")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Ulm", "long", 12, toolkit.getImage("TicketToRidePics"+File.separator+"LeipUlm")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Frankfurt", "short", 10, toolkit.getImage("TicketToRidePics"+File.separator+"LiepFran")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Nurnberg", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"LiepNurn")));
        ticketcardsDeck.add(new TicketCard("Magdeburg", "Koln", "short", 11, toolkit.getImage("TicketToRidePics"+File.separator+"MagdKoln")));
        ticketcardsDeck.add(new TicketCard("Mainz", "Stuttgart", "short", 3, toolkit.getImage("TicketToRidePics"+File.separator+"MainStut")));
        ticketcardsDeck.add(new TicketCard("Mannheim", "Stuttgart", "short", 2, toolkit.getImage("TicketToRidePics"+File.separator+"MannStut")));
        ticketcardsDeck.add(new TicketCard("Mannheim", "Wurzburg", "short", 4, toolkit.getImage("TicketToRidePics"+File.separator+"MannWurz")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Freiburg", "short", 8, toolkit.getImage("TicketToRidePics"+File.separator+"MuncFrei")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Konstanz", "short", 6, toolkit.getImage("TicketToRidePics"+File.separator+"MuncKons")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Stuttgart", "short", 5, toolkit.getImage("TicketToRidePics"+File.separator+"MuncStut")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Wurzburg", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"MuncWurz")));
        ticketcardsDeck.add(new TicketCard("Munster", "Munchen", "long", 14, toolkit.getImage("TicketToRidePics"+File.separator+"MunsMunc")));
        //two paths
        ticketcardsDeck.add(new TicketCard("Munster", "Osterreich", "long", 15, toolkit.getImage("TicketToRidePics"+File.separator+"MunsOste")));
        ticketcardsDeck.add(new TicketCard("Munster", "Stuttgart", "short", 9, toolkit.getImage("TicketToRidePics"+File.separator+"MunsStut")));
        ticketcardsDeck.add(new TicketCard("Niederlande", "Berlin", "long", 13, toolkit.getImage("TicketToRidePics"+File.separator+"NiedBerl")));
        ticketcardsDeck.add(new TicketCard("Niederlande", "Frankfurt", "short", 8, toolkit.getImage("TicketToRidePics"+File.separator+"NiedFran")));
        ticketcardsDeck.add(new TicketCard("Niederlande", "Karlsruhe", "short", 9, toolkit.getImage("TicketToRidePics"+File.separator+"NiedKarl")));
        ticketcardsDeck.add(new TicketCard("Nurnberg", "Stuttgart", "short", 7, toolkit.getImage("TicketToRidePics"+File.separator+"NurnStut")));
        ticketcardsDeck.add(new TicketCard("Rostock", "Konstanz", "long", 22, toolkit.getImage("TicketToRidePics"+File.separator+"RostKons")));
        ticketcardsDeck.add(new TicketCard("Rostock", "Osterreich", "long", 22, toolkit.getImage("TicketToRidePics"+File.separator+"RostOste")));
        ticketcardsDeck.add(new TicketCard("Schwerin", "Koblenz", "long", 12, toolkit.getImage("TicketToRidePics"+File.separator+"SchKob")));
        ticketcardsDeck.add(new TicketCard("Schwerin", "Frankfurt", "long", 13, toolkit.getImage("TicketToRidePics"+File.separator+"SchwFran")));
        
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
