import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{


    public MainPanel(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1200, 900));
        GridBagConstraints a = new GridBagConstraints();
        a.fill = GridBagConstraints.HORIZONTAL;
        a.gridx = 0;
        a.gridy = 0;

        BoardPanel bPanel = new BoardPanel();
        CardPanel cPanel = new CardPanel();

        add(bPanel, a);
        add(cPanel);
    }

}
