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
        ticketCardsDeck[0] = new TicketCard("Berlin", "Chemnitz","short", 6, toolkit.getImage("TicketToRidePics\\BerlChem"));
        ticketCardsDeck[1] = new TicketCard("Berlin", "Dusseldorf", "long", 13, toolkit.getImage("TicketToRidePics\\BerlDuss"));
        ticketCardsDeck[2] = new TicketCard("Berlin", "Erfurt", "short",  7, toolkit.getImage("TicketToRidePics\\BurlErfu"));
        ticketCardsDeck[3] = new TicketCard("Berlin", "Frankfurt","long", 14, toolkit.getImage("TicketToRidePics\\BerlFran"));
        ticketCardsDeck[4] = new TicketCard("Berlin", "Koln","long", 14, toolkit.getImage("TicketToRidePics\\BerlKoln"));
        ticketCardsDeck[5] = new TicketCard("Berlin", "Leipzig", "short", 4, toolkit.getImage("TicketToRidePics\\BerlLeip"));
        ticketCardsDeck[6] = new TicketCard("Berlin", "Mainz", "long", 15, toolkit.getImage("TicketToRidePics\\BerlMain"));
        ticketCardsDeck[7] = new TicketCard("Berlin", "Munchen","long", 15, toolkit.getImage("TicketToRidePics\\BerlMunc"));
        ticketCardsDeck[8] = new TicketCard("Berlin", "Schweiz", "long", 20, toolkit.getImage("TicketToRidePics\\BerlSchw"));
        ticketCardsDeck[9] = new TicketCard("Berlin", "Stuttgart", "long", 18, toolkit.getImage("TicketToRidePics\\BerlStut"));
        ticketCardsDeck[10] = new TicketCard("Bremen", "Berlin", "short", 10, toolkit.getImage("TicketToRidePics\\BremBerl"));
        ticketCardsDeck[11] = new TicketCard("Berlin", "Dusseldorf", "short", 5, toolkit.getImage("TicketToRidePics\\BremDuss"));
        ticketCardsDeck[12] = new TicketCard("Bremerhaven", "Frankreich", "long", 12, toolkit.getImage("TicketToRidePics\\BremFran"));
        ticketCardsDeck[13] = new TicketCard("Bremen", "Kassel", "short", 6, toolkit.getImage("TicketToRidePics\\BremKass"));
        ticketCardsDeck[14] = new TicketCard("Bremerhaven", "koln", "short", 7, toolkit.getImage("TicketToRidePics\\BremKoln"));
        ticketCardsDeck[15] = new TicketCard("Bremerhaven", "Regensburg", "long", 16, toolkit.getImage("TicketToRidePics\\BremRege"));
        ticketCardsDeck[16] = new TicketCard("Danemark", "Berlin", "short", 10, toolkit.getImage("TicketToRidePics\\DaneBerl"));
        ticketCardsDeck[17] = new TicketCard("Danemark", "Lindau", "long", 22, toolkit.getImage("TicketToRidePics\\DaneLind"));
        ticketCardsDeck[18] = new TicketCard("Danemark", "Niederlande", "short",10, toolkit.getImage("TicketToRidePics\\DaneNied"));
        ticketCardsDeck[19] = new TicketCard("Dortmund", "Erfurt", "short", 7, toolkit.getImage("TicketToRidePics\\DortErfu"));
        ticketCardsDeck[20] = new TicketCard("Dortmund", "Magdeburg", "short", 9, toolkit.getImage("TicketToRidePics\\DortMagd"));
        ticketCardsDeck[21] = new TicketCard("Dortmund", "Mannheim", "short", 6, toolkit.getImage("TicketToRidePics\\DortMann"));
        ticketCardsDeck[22] = new TicketCard("Dortmund", "Munchen", "long", 13, toolkit.getImage("TicketToRidePics\\DortMunc"));
        ticketCardsDeck[23] = new TicketCard("Dresden", "Augsburg", "long", 12, toolkit.getImage("TicketToRidePics\\DresAugs"));
        ticketCardsDeck[24] = new TicketCard("Dresden", "Saarbrucken", "long", 16, toolkit.getImage("TicketToRidePics\\DresSaar"));
        ticketCardsDeck[25] = new TicketCard("Dusseldorf", "Konstanz", "short", 10, toolkit.getImage("TicketToRidePics\\DussKons"));
        ticketCardsDeck[26] = new TicketCard("Emden", "Freiburg", "long", 15, toolkit.getImage("TicketToRidePics\\EmdeFrei"));
        ticketCardsDeck[27] = new TicketCard("Emden", "hamburg", "short", 6, toolkit.getImage("TicketToRidePics\\EmdeHamb"));
        //two paths
        ticketCardsDeck[28] = new TicketCard("Emden", "Osterreich", "short", 20, toolkit.getImage("TicketToRidePics\\EmdeOste"));
        ticketCardsDeck[29] = new TicketCard("Erfurt", "Wurzburg", "short", 6, toolkit.getImage("TicketToRidePics\\ErfuWurz"));
        ticketCardsDeck[30] = new TicketCard("Frankreich", "Danemark", "long", 17, toolkit.getImage("TicketToRidePics\\FranDane"));
        ticketCardsDeck[31] = new TicketCard("Frankfurt", "Munchen", "short", 9, toolkit.getImage("TicketToRidePics\\FrankfMunc"));
        ticketCardsDeck[32] = new TicketCard("Frankreich", "Munchen", "short", 8, toolkit.getImage("TicketToRidePics\\FrankrMunc"));
        ticketCardsDeck[33] = new TicketCard("Frankreich", "Leipzig", "long", 15, toolkit.getImage("TicketToRidePics\\FranLeip"));
        ticketCardsDeck[34] = new TicketCard("Frankfurt", "Lindau", "short", 8, toolkit.getImage("TicketToRidePics\\FranLind"));
        ticketCardsDeck[35] = new TicketCard("Frankfurt", "Osterreich", "short", 10, toolkit.getImage("TicketToRidePics\\FranOste"));
        ticketCardsDeck[36] = new TicketCard("Frankfurt", "Stuttgart", "short", 4, toolkit.getImage("TicketToRidePics\\FranStut"));
        ticketCardsDeck[37] = new TicketCard("Hamburg", "Berlin", "short", 7, toolkit.getImage("TicketToRidePics\\HambBerl"));
        ticketCardsDeck[38] = new TicketCard("Hamburg", "Dresden", "long", 12, toolkit.getImage("TicketToRidePics\\HambDres"));
        ticketCardsDeck[39] = new TicketCard("Hamburg", "Frankfurt", "short", 11, toolkit.getImage("TicketToRidePics\\HambFran"));
        ticketCardsDeck[40] = new TicketCard("Hamburg", "Karlsruhe", "long", 14, toolkit.getImage("TicketToRidePics\\HambKarl"));
        ticketCardsDeck[41] = new TicketCard("Hamburg", "Kassel", "short", 7, toolkit.getImage("TicketToRidePics\\HambKass"));
        ticketCardsDeck[42] = new TicketCard("Hamburg", "Koblenz", "short", 10, toolkit.getImage("TicketToRidePics\\HambKobl"));
        ticketCardsDeck[43] = new TicketCard("Hamburg", "Koln", "short", 9, toolkit.getImage("TicketToRidePics\\HambKoln"));
        ticketCardsDeck[44] = new TicketCard("Hamburg", "Leipzig", "short", 10, toolkit.getImage("TicketToRidePics\\HambLeip"));
        ticketCardsDeck[45] = new TicketCard("Hamburg", "Munchen", "long", 18, toolkit.getImage("TicketToRidePics\\HambMunc"));
        ticketCardsDeck[46] = new TicketCard("Hamburg", "Rostock", "short", 4, toolkit.getImage("TicketToRidePics\\HambRost"));
        ticketCardsDeck[47] = new TicketCard("Hamburg", "Stuttgart", "long", 15, toolkit.getImage("TicketToRidePics\\HambStut"));
        ticketCardsDeck[48] = new TicketCard("Hannover", "Frankfurt", "short", 7, toolkit.getImage("TicketToRidePics\\HannFran"));
        ticketCardsDeck[49] = new TicketCard("Hannover", "Leipzig", "short", 6, toolkit.getImage("TicketToRidePics\\HannLeip"));
        ticketCardsDeck[50] = new TicketCard("Hannover", "Saarbrucken", "short", 11, toolkit.getImage("TicketToRidePics\\HannSaar"));
        ticketCardsDeck[51] = new TicketCard("Karlsruhe", "Augsburg", "short", 4, toolkit.getImage("TicketToRidePics\\KarlAugs"));
        ticketCardsDeck[52] = new TicketCard("Karlsruhe", "Regensburg", "short", 9, toolkit.getImage("TicketToRidePics\\KarlRege"));
        ticketCardsDeck[53] = new TicketCard("Kassel", "Freiburg", "short", 10, toolkit.getImage("TicketToRidePics\\KassFrei"));
        ticketCardsDeck[54] = new TicketCard("Keil", "Nurnberg", "long", 15, toolkit.getImage("TicketToRidePics\\KielNurn"));
        ticketCardsDeck[55] = new TicketCard("Keil", "Schweiz", "long", 20, toolkit.getImage("TicketToRidePics\\KielSchw"));
        ticketCardsDeck[56] = new TicketCard("Keil", "Stuttgart", "long", 17, toolkit.getImage("TicketToRidePics\\KielStut"));
        ticketCardsDeck[57] = new TicketCard("Koblenz", "Ulm", "short", 7, toolkit.getImage("TicketToRidePics\\KoblUlm"));
        ticketCardsDeck[58] = new TicketCard("Koln", "Frankfurt", "short", 4, toolkit.getImage("TicketToRidePics\\KolnFran"));
        ticketCardsDeck[59] = new TicketCard("Koln", "Leipzig", "long", 12, toolkit.getImage("TicketToRidePics\\KolnLeip"));
        ticketCardsDeck[60] = new TicketCard("Koln", "Munchen", "short", 11, toolkit.getImage("TicketToRidePics\\KolnMunc"));
        ticketCardsDeck[61] = new TicketCard("Koln", "Nurnberg", "short", 8, toolkit.getImage("TicketToRidePics\\KolnNurn"));
        ticketCardsDeck[62] = new TicketCard("Koln", "Regensburg", "short", 11, toolkit.getImage("TicketToRidePics\\KolnRege"));
        ticketCardsDeck[63] = new TicketCard("Koln", "Saarbrucken", "short", 4, toolkit.getImage("TicketToRidePics\\KolnSaar"));
        ticketCardsDeck[64] = new TicketCard("Koln", "Schweiz", "short", 10, toolkit.getImage("TicketToRidePics\\KolnSchw"));
        ticketCardsDeck[65] = new TicketCard("Leipzig", "Munchen", "short", 11, toolkit.getImage("TicketToRidePics\\LeipMunc"));
        ticketCardsDeck[66] = new TicketCard("Leipzig", "Stuttgart", "long", 14, toolkit.getImage("TicketToRidePics\\LeipStut"));
        ticketCardsDeck[67] = new TicketCard("Leipzig", "Ulm", "long", 12, toolkit.getImage("TicketToRidePics\\LeipUlm"));
        ticketCardsDeck[68] = new TicketCard("Leipzig", "Frankfurt", "short", 10, toolkit.getImage("TicketToRidePics\\LiepFran"));
        ticketCardsDeck[69] = new TicketCard("Leipzig", "Nurnberg", "short", 7, toolkit.getImage("TicketToRidePics\\LiepNurn"));
        ticketCardsDeck[70] = new TicketCard("Magdeburg", "Koln", "short", 11, toolkit.getImage("TicketToRidePics\\MagdKoln"));
        ticketCardsDeck[71] = new TicketCard("Mainz", "Stuttgart", "short", 3, toolkit.getImage("TicketToRidePics\\MainStut"));
        ticketCardsDeck[72] = new TicketCard("Mannheim", "Stuttgart", "short", 2, toolkit.getImage("TicketToRidePics\\MannStut"));
        ticketCardsDeck[73] = new TicketCard("Mannheim", "Wurzburg", "short", 4, toolkit.getImage("TicketToRidePics\\MannWurz"));
        ticketCardsDeck[74] = new TicketCard("Munchen", "Freiburg", "short", 8, toolkit.getImage("TicketToRidePics\\MuncFrei"));
        ticketCardsDeck[75] = new TicketCard("Munchen", "Konstanz", "short", 6, toolkit.getImage("TicketToRidePics\\MuncKons"));
        ticketCardsDeck[76] = new TicketCard("Munchen", "Stuttgart", "short", 5, toolkit.getImage("TicketToRidePics\\MuncStut"));
        ticketCardsDeck[77] = new TicketCard("Munchen", "Wurzburg", "short", 7, toolkit.getImage("TicketToRidePics\\MuncWurz"));
        ticketCardsDeck[78] = new TicketCard("Munster", "Munchen", "long", 14, toolkit.getImage("TicketToRidePics\\MunsMunc"));
        //two paths
        ticketCardsDeck[79] = new TicketCard("Munster", "Osterreich", "long", 15, toolkit.getImage("TicketToRidePics\\MunsOste"));
        ticketCardsDeck[80] = new TicketCard("Munster", "Stuttgart", "short", 9, toolkit.getImage("TicketToRidePics\\MunsStut"));
        ticketCardsDeck[81] = new TicketCard("Niederlande", "Berlin", "long", 13, toolkit.getImage("TicketToRidePics\\NiedBerl"));
        ticketCardsDeck[82] = new TicketCard("Niederlande", "Frankfurt", "short", 8, toolkit.getImage("TicketToRidePics\\NiedFran"));
        ticketCardsDeck[83] = new TicketCard("Niederlande", "Karlsruhe", "short", 9, toolkit.getImage("TicketToRidePics\\NiedKarl"));
        ticketCardsDeck[84] = new TicketCard("Nurnberg", "Stuttgart", "short", 7, toolkit.getImage("TicketToRidePics\\NurnStut"));
        ticketCardsDeck[85] = new TicketCard("Rostock", "Konstanz", "long", 22, toolkit.getImage("TicketToRidePics\\RostKons"));
        ticketCardsDeck[86] = new TicketCard("Rostock", "Osterreich", "long", 22, toolkit.getImage("TicketToRidePics\\RostOste"));
        ticketCardsDeck[87] = new TicketCard("Schwerin", "Koblenz", "long", 12, toolkit.getImage("TicketToRidePics\\SchKob"));
        ticketCardsDeck[88] = new TicketCard("Schwerin", "Frankfurt", "long", 13, toolkit.getImage("TicketToRidePics\\SchwFran"));
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
