package decorator;
import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
    Panel() {
        setPreferredSize(new Dimension(450,450));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D)graphics;
        BasicStroke pen1 = new BasicStroke(5);
        g.setStroke(pen1);
        g.setColor(Color.lightGray);
        g.drawRect(0, 0, 400, 400);

        g.drawRoundRect(0,   0, 100, 100, 20, 20);   //0 0
        g.drawRoundRect(0, 100, 100, 100, 20, 20);   //1 0
        g.drawRoundRect(0, 200, 100, 100, 20, 20);   //2 0
        g.drawRoundRect(0, 300, 100, 100, 20, 20);   //3 0

        g.drawRoundRect(100,   0, 100, 100, 20, 20); //0 1
        g.drawRoundRect(100, 100, 100, 100, 20, 20); //1 1
        g.drawRoundRect(100, 200, 100, 100, 20, 20); //2 1
        g.drawRoundRect(100, 300, 100, 100, 20, 20); //3 1

        g.drawRoundRect(200,   0, 100, 100, 20, 20); //0 2
        g.drawRoundRect(200, 100, 100, 100, 20, 20); //1 2
        g.drawRoundRect(200, 200, 100, 100, 20, 20); //2 2
        g.drawRoundRect(200, 300, 100, 100, 20, 20); //3 2

        g.drawRoundRect(300,   0, 100, 100, 20, 20); //0 3
        g.drawRoundRect(300, 100, 100, 100, 20, 20); //1 3
        g.drawRoundRect(300, 200, 100, 100, 20, 20); //2 3
        g.drawRoundRect(300, 300, 100, 100, 20, 20); //3 3
    }
}