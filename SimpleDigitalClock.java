package server;

import javax.swing.*;

import java.awt.*;

import java.util.Date;

public class SimpleDigitalClock extends JPanel {
    JFrame frame;

    int currentHour;
    int currentMinute;
    int currentSecond;

    // Font that will be use to show digital clock
    Font myFont = new Font("Tahoma", Font.BOLD + Font.ITALIC, 20);

    // Color that will be use to show digital clock
    Color myColor = new Color(64, 64, 64);

    // Font metrics that will use to store font informations
    // For example, width of a character
    FontMetrics fm;

    public SimpleDigitalClock() {
        // Create a window using JFrame with title ( Simple Digital Clock )
        frame = new JFrame("Simple Digital Clock");

        // add(this) mean add created panel into JFrame
        // Which panel ?
        // See line 81 and 7 (I hope you understand it)
        frame.add(this);

        // Set default close operation for JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set JFrame size
        frame.setSize(300, 100);

        // Make JFrame locate at center
        frame.setLocationRelativeTo(null);

        // Make JFrame visible
        frame.setVisible(true);

        /*
         * Loop that will make sure panel show current time like current second, current
         * minute and current hour.
         */
        while (true) {
            // It will do all code in method paint(See line 67)
            repaint();

            try {
                Thread.sleep(900);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        /*
         * Create current Date object. It means it store information about current hour,
         * minute and second.
         */
        Date myDate = new Date();

        currentHour = myDate.getHours();
        currentMinute = myDate.getMinutes();
        currentSecond = myDate.getSeconds();

        // Set font that will use to draw digital number
        g.setFont(myFont);

        // Information about distance between number in digital clock
        fm = g.getFontMetrics();
        int hourXCoordinate = 20;
        int minuteXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 2);
        int secondXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 4);

        // Set color that will use to draw digital number
        g.setColor(myColor);

        // Draw hour, draw (:) between number, draw minute and draw second.
        g.drawString(Integer.toString(currentHour), hourXCoordinate, 20);
        g.drawString(":", (hourXCoordinate + minuteXCoordinate) / 2, 20);
        g.drawString(Integer.toString(currentMinute), minuteXCoordinate, 20);
        g.drawString(":", (secondXCoordinate + minuteXCoordinate) / 2, 20);
        g.drawString(Integer.toString(currentSecond), secondXCoordinate, 20);
    }

    public static void main(String[] args) {
        SimpleDigitalClock sdc = new SimpleDigitalClock();
    }
}