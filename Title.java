import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
*   Creates the Title Screen that can be interacted with. Play starts the game,
*   Players lets the players choose their colors, Quit closes the game.
*
**/
public class Title {
    public Rectangle playButton = new Rectangle(625, 175,150,50);
    public Rectangle playersButton = new Rectangle(625, 250,150,50);
    public Rectangle quitButton = new Rectangle(625, 325,150,50);
    JFrame frame;
    public Title() throws IOException{
        JFrame frame = buildFrame();

        final BufferedImage image = ImageIO.read(new File("TicketToRidePics"
                    +File.separator+"Thomas3.JPG"));

        JPanel pane = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, null);

                    Graphics2D g2d = (Graphics2D) g;
                    Font font = new Font("arial",Font.BOLD, 30);
                    g.setFont(font);
                    g.setColor(Color.white);
                    g.drawString("Play", playButton.x + 48, playButton.y + 37);
                    g2d.draw(playButton);
                    g.drawString("Players", playersButton.x + 28, playersButton.y + 37);
                    g2d.draw(playersButton);
                    g.drawString("Quit", quitButton.x + 48, quitButton.y + 37);
                    g2d.draw(quitButton);
                }
            };
        frame.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked( MouseEvent e ){
                    int mx = e.getX();
                    int my = e.getY();

                    /**
                     * public Rectangle playButton = new Rectangle(625, 175,150,50);
                     * public Rectangle playersButton = new Rectangle(625, 250,150,50);
                     * public Rectangle quitButton = new Rectangle(625, 325,150,50);
                     **/

                    //play button
                    if(mx >= 625 && mx <= 775){
                        if(my >= 175 && my <= 225){
                            PlayGame.state = PlayGame.STATE.GAME;
                            PlayGame.value = true;
                            frame.dispose();
                        }
                    }
                    //players button
                    if(mx >= 625 && mx <= 775){
                        if(my >= 250 && my <= 300){
                            String[] choices = { "Red", "Black", "Blue", "White", "Yellow"};
                            String input = (String) JOptionPane.showInputDialog(null, "Player 1 Color",
                                    "Player Color", JOptionPane.QUESTION_MESSAGE, null, 

                                    choices, 
                                    choices[1]); 
                            if(input.equals("Red")){
                                Layout.c1 = Color.RED;
                            }
                            else if(input.equals("Black")){
                                Layout.c1 = Color.BLACK;
                            }
                            else if(input.equals("Blue")){
                                Layout.c1 = Color.BLUE;
                            }
                            else if(input.equals("White")){
                                Layout.c1 = Color.WHITE;
                            }
                            else {
                                Layout.c1 = Color.YELLOW;
                            }
                            String[] choices2 = { "Red", "Black", "Blue", "White", "Yellow"};
                            String input2 = (String) JOptionPane.showInputDialog(null, "Player 2 Color",
                                    "Player Color", JOptionPane.QUESTION_MESSAGE, null,
                                    choices2, 
                                    choices2[1]); 
                            int i = 0;
                            while(input2 == input){
                                input2 = choices2[i++];
                            }
                            if(input2.equals("Red")){
                                Layout.c2 = Color.RED;
                            }
                            else if(input2.equals("Black")){
                                Layout.c2 = Color.BLACK;
                            }
                            else if(input2.equals("Blue")){
                                Layout.c2 = Color.BLUE;
                            }
                            else if(input2.equals("White")){
                                Layout.c2 = Color.WHITE;
                            }
                            else {
                                Layout.c2 = Color.YELLOW;
                            }
                        }
                    }

                    //quit button
                    if(mx >= 625 && mx <= 775){
                        if(my >= 325 && my <= 375){
                            PlayGame.value = true;
                            frame.dispose();
                        }
                    }
                }
            });
        frame.add(pane);
        frame.setVisible(true);
    }

    private JFrame buildFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,632);
        frame.setVisible(true);
        return frame;
    }
}
