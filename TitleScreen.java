import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * Write a description of class Title here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TitleScreen extends JPanel
{
    private Toolkit toolkit = Toolkit.getDefaultToolkit();;
    private Icon image;
    private int height, width;
    JFrame frame;
    /**
     * Constructor for objects of class Title
     */
    public TitleScreen()
    {
        super();
        setOpaque(true);
        JPanel jp = new JPanel();
        jp.add(new JLabel(new ImageIcon("Thomas.gif")));
        frame.add(jp, java.awt.BorderLayout.CENTER);
    }

    public static void main(String[] args){
        Icon icon = new ImageIcon("TicketToRidePics"+File.separator+"Thomas.gif");
        JLabel label = new JLabel(icon);

        JFrame f = new JFrame("Ticket to Ride");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    public void paintComponent(Graphics g ){
        super.paintComponents(g);
        Dimension d = getSize();
        // g.drawImage(image, 0,0,d.width,d.height,this);  
    }
}

// private static void createAndShowGUI() {
// //Create and set up the window.
// JFrame frame = new JFrame("TitleScreen");
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// //Add the ubiquitous "Hello World" label.
// TitleScreen panel = new TitleScreen();
// frame.getContentPane().add(panel);

// //Display the window.
// frame.pack();
// frame.setVisible(true);
// }

// public static void main(String[] args) {
// //Schedule a job for the event-dispatching thread:
// //creating and showing this application's GUI.
// javax.swing.SwingUtilities.invokeLater(new Runnable() {
// public void run() {
// createAndShowGUI();
// }
// });
// }

// @Override
// public void paintComponent(Graphics g) {
// // Icon imgIcon = new ImageIcon(this.getClass().getResource("Thomas.gif"));
// // JLabel label = new JLabel(imgIcon);
// // label.setBounds(668, 43, 46, 14);
// // frame.getContentPane().add(label);

// // super.paintComponent(g);
// // g.drawImage(background, 0, 0, this);
// }

