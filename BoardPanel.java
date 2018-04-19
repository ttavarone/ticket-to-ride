import javax.swing.*;
import java.awt.*;

/**
 * GUI for the board
 *
 * @author (Logan, Tucker, Josh, Eamonn, Tom)
 * @version (4 / 8 / 18)
 */
public class BoardPanel extends JPanel {
    private Toolkit toolkit;
    private Image board;
    private int bHeight;
    private int bWidth;

    public BoardPanel() {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        toolkit = Toolkit.getDefaultToolkit();
        board = toolkit.getImage("TTRGermanyMap.jpg");
        bHeight = board.getHeight(this);
        bWidth = board.getWidth(this);

        board = board.getScaledInstance(550, 850, Image.SCALE_SMOOTH);

        setPreferredSize(new Dimension(550, 850));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(board, bWidth, bHeight, this);
    }
}
