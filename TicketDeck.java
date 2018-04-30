////////////////////////////////////////////////////////////////////////////////
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Initializes and constructs short and long tickets.
 * 
 * This class also gets the image objects that will eventually be used 
 * to paint on a JPanel
 *
 * @author (Tucker Tavarone, Logan Brandt, Josh DelSignore, Eamonn Conway)
 * @version (4/30/18)
 */
public class TicketDeck
{
    private static Image orangeDest;
    private static Image blueDest;
    private static ArrayList<TicketCard> ticketcardsDeck = 
        new ArrayList<TicketCard>();
    protected Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static String[] cityNames = new String[39];
    private static ArrayList<TicketCard> shortRoutesDeck = 
        new ArrayList<TicketCard>();
    private static ArrayList<TicketCard> longRoutesDeck = 
        new ArrayList<TicketCard>();
    
    public TicketDeck(){

        orangeDest = toolkit.getImage("TicketToRidePics"+
            File.separator+"OrangeDest.jpg");
        blueDest = toolkit.getImage("TicketToRidePics"+
            File.separator+"BlueDest.jpg");

        ticketcardsDeck.add(new TicketCard("Berlin","Chemnitz","short",6, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlChem.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin","Dusseldorf","long",13, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlDuss.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Erfurt", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BurlErfu.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Frankfurt","long", 14, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlFran.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Koln","long", 14, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlKoln.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Leipzig", "short", 4, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlLeip.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Mainz", "long", 15, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlMain.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Munchen","long", 15, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+""+
            File.separator+"BerlMunc.jpg")));
            
        ticketcardsDeck.add(new TicketCard("Berlin", "Schweiz", "long", 20, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlSchw.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Stuttgart", "long", 18, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BerlStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Bremen", "Berlin", "short", 10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BremBerl.jpg")));
        ticketcardsDeck.add(new TicketCard("Berlin", "Dusseldorf", "short", 5, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BremDuss.jpg")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven","Frankreich","long",
            12, toolkit.getImage("TicketToRidePics"+
            File.separator+"BremFran.jpg")));
        ticketcardsDeck.add(new TicketCard("Bremen", "Kassel", "short", 6, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BremKass.jpg")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven", "koln", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"BremKoln.jpg")));
        ticketcardsDeck.add(new TicketCard("Bremerhaven","Regensburg","long",
            16, toolkit.getImage("TicketToRidePics"+
            File.separator+"BremRege.jpg")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Berlin", "short", 10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DaneBerl.jpg")));
        ticketcardsDeck.add(new TicketCard("Danemark", "Lindau", "long", 22, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DaneLind.jpg")));
        ticketcardsDeck.add(new TicketCard("Danemark","Niederlande","short",10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DaneNied.jpg")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Erfurt", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DortErfu.jpg")));
        ticketcardsDeck.add(new TicketCard("Dortmund","Magdeburg","short",9, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DortMagd.jpg")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Mannheim", "short", 6, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DortMann.jpg")));
        ticketcardsDeck.add(new TicketCard("Dortmund", "Munchen", "long", 13, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DortMunc.jpg")));
        ticketcardsDeck.add(new TicketCard("Dresden", "Augsburg", "long", 12, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DresAugs.jpg")));
        ticketcardsDeck.add(new TicketCard("Dresden","Saarbrucken","long",16, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DresSaar.jpg")));
        ticketcardsDeck.add(new TicketCard("Dusseldorf","Konstanz","short",10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"DussKons.jpg")));
        ticketcardsDeck.add(new TicketCard("Emden", "Freiburg", "long", 15, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"EmdeFrei.jpg")));
        ticketcardsDeck.add(new TicketCard("Emden", "hamburg", "short", 6, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"EmdeHamb.jpg")));
        //two paths
        ticketcardsDeck.add(new TicketCard("Emden", "Osterreich", "long", 20, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"EmdeOste.jpg")));
        ticketcardsDeck.add(new TicketCard("Erfurt", "Wurzburg", "short", 6, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"ErfuWurz.jpg")));
        ticketcardsDeck.add(new TicketCard("Frankreich","Danemark","long",17, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"FranDane.jpg")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Munchen", "short", 9, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"FrankfMunc.jpg")));
        ticketcardsDeck.add(new TicketCard("Frankreich","Munchen", "short",8, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"FrankrMunc.jpg")));
        ticketcardsDeck.add(new TicketCard("Frankreich","Leipzig","long",15, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"FranLeip.jpg")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Lindau", "short", 8, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"FranLind.jpg")));
        ticketcardsDeck.add(new TicketCard("Frankfurt", "Osterreich", "short",
            10, toolkit.getImage("TicketToRidePics"+
            File.separator+"FranOste.jpg")));
        ticketcardsDeck.add(new TicketCard("Frankfurt","Stuttgart","short",4, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"FranStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Berlin", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambBerl.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Dresden", "long", 12, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambDres.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg","Frankfurt","short",11, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambFran.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Karlsruhe", "long", 14, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambKarl.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Kassel", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambKass.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Koblenz", "short", 10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambKobl.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Koln", "short", 9, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambKoln.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Leipzig", "short", 10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambLeip.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Munchen", "long", 18, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambMunc.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Rostock", "short", 4, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambRost.jpg")));
        ticketcardsDeck.add(new TicketCard("Hamburg", "Stuttgart", "long", 15, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HambStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Hannover","Frankfurt","short",7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HannFran.jpg")));
        ticketcardsDeck.add(new TicketCard("Hannover", "Leipzig", "short", 6, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"HannLeip.jpg")));
        ticketcardsDeck.add(new TicketCard("Hannover","Saarbrucken","short",
            11, toolkit.getImage("TicketToRidePics"+
            File.separator+"HannSaar.jpg")));
        ticketcardsDeck.add(new TicketCard("Karlsruhe","Augsburg","short",4, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KarlAugs.jpg")));
        ticketcardsDeck.add(new TicketCard("Karlsruhe","Regensburg","short",9, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KarlRege.jpg")));
        ticketcardsDeck.add(new TicketCard("Kassel", "Freiburg", "short", 10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KassFrei.jpg")));
        ticketcardsDeck.add(new TicketCard("Keil", "Nurnberg", "long", 15, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KielNurn.jpg")));
        ticketcardsDeck.add(new TicketCard("Keil", "Schweiz", "long", 20, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KielSchw.jpg")));
        ticketcardsDeck.add(new TicketCard("Keil", "Stuttgart", "long", 17, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KielStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Koblenz", "Ulm", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KoblUlm.jpg")));
        ticketcardsDeck.add(new TicketCard("Koln", "Frankfurt", "short", 4, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KolnFran.jpg")));
        ticketcardsDeck.add(new TicketCard("Koln", "Leipzig", "long", 12, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KolnLeip.jpg")));
        ticketcardsDeck.add(new TicketCard("Koln", "Munchen", "short", 11, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KolnMunc.jpg")));
        ticketcardsDeck.add(new TicketCard("Koln", "Nurnberg", "short", 8, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KolnNurn.jpg")));
        ticketcardsDeck.add(new TicketCard("Koln", "Regensburg", "short", 11, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KolnRege.jpg")));
        ticketcardsDeck.add(new TicketCard("Koln", "Saarbrucken", "short", 4, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KolnSaar.jpg")));
        ticketcardsDeck.add(new TicketCard("Koln", "Schweiz", "short", 10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"KolnSchw.jpg")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Munchen", "short", 11, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"LeipMunc.jpg")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Stuttgart", "long",14, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"LeipStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Ulm", "long",12, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"LeipUlm.jpg")));
        ticketcardsDeck.add(new TicketCard("Leipzig","Frankfurt","short",10, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"LiepFran.jpg")));
        ticketcardsDeck.add(new TicketCard("Leipzig", "Nurnberg", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"LiepNurn.jpg")));
        ticketcardsDeck.add(new TicketCard("Magdeburg", "Koln", "short", 11, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MagdKoln.jpg")));
        ticketcardsDeck.add(new TicketCard("Mainz", "Stuttgart", "short", 3, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MainStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Mannheim","Stuttgart","short",2, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MannStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Mannheim", "Wurzburg", "short", 4, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MannWurz.jpg")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Freiburg", "short", 8, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MuncFrei.jpg")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Konstanz", "short", 6, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MuncKons.jpg")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Stuttgart", "short", 5, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MuncStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Munchen", "Wurzburg", "short", 7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MuncWurz.jpg")));
        ticketcardsDeck.add(new TicketCard("Munster", "Munchen", "long", 14, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MunsMunc.jpg")));
        //two paths
        ticketcardsDeck.add(new TicketCard("Munster","Osterreich","long",15, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MunsOste.jpg")));
        ticketcardsDeck.add(new TicketCard("Munster","Stuttgart","short",9, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"MunsStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Niederlande","Berlin","long",13, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"NiedBerl.jpg")));
        ticketcardsDeck.add(new TicketCard("Niederlande","Frankfurt","short",8, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"NiedFran.jpg")));
        ticketcardsDeck.add(new TicketCard("Niederlande","Karlsruhe","short",9, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"NiedKarl.jpg")));
        ticketcardsDeck.add(new TicketCard("Nurnberg","Stuttgart","short",7, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"NurnStut.jpg")));
        ticketcardsDeck.add(new TicketCard("Rostock","Konstanz","long",22, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"RostKons.jpg")));
        ticketcardsDeck.add(new TicketCard("Rostock","Osterreich","long",22, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"RostOste.jpg")));
        ticketcardsDeck.add(new TicketCard("Schwerin","Koblenz","long",12, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"SchKob.jpg")));
        ticketcardsDeck.add(new TicketCard("Schwerin","Frankfurt","long",13, 
            toolkit.getImage("TicketToRidePics"+
            File.separator+"SchwFran.jpg")));
        
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

        blueDest = blueDest.getScaledInstance(
            70, 118, Image.SCALE_FAST);
        orangeDest = orangeDest.getScaledInstance(
            70, 118, Image.SCALE_FAST);
    }
    
    /**
     * This method removes the top card of the deck, then 
     * returns the card that was on top.
     * 
     * @return - The card that was on top of the deck, 
     * or nothing if the deck is empty.
     */
    public TicketCard dequeueShort()
    {
        if(shortEmpty())
        {
            return null;
        }
        TicketCard answer = shortRoutesDeck.get(0);
        shortRoutesDeck.remove(0);
        return answer;
    }
    
    public TicketCard dequeueLong()
    {
        if(longEmpty())
        {
            return null;
        }
        TicketCard answer = longRoutesDeck.get(0);
        longRoutesDeck.remove(0);
        return answer;
    }
    
    public boolean shortEmpty()
    {
        if(shortRoutesDeck.size() == 0)
        {
            return true;
        }
        return false;
    }
    
    public boolean longEmpty()
    {
        if(longRoutesDeck.size() == 0)
        {
            return true;
        }
        return false;
    }
    
    public void discardShort(TicketCard t)
    {
        shortRoutesDeck.add(shortRoutesDeck.size() - 1, t);
    }
    
    public void discardLong(TicketCard t)
    {
        longRoutesDeck.add(longRoutesDeck.size() - 1, t);
    }
}
