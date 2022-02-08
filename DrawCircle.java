package LogsAnalyser;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    int winX = 1000, winY = 900;

    public DrawCircle() {
        setTitle("Title");
        setSize(winX, winY);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        int multiplicator = 2;
        int frameX = multiplicator * 300, frameY = multiplicator * 400;
        int frameStartX = (winX - frameX) / 2, frameStartY = (winY - frameY) / 2;
        int winCentrX = winX / 2, winCentrY = winY / 2;

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(frameStartX, frameStartY, frameX, frameY);
        g2d.drawString(ParseCSV.fileName, frameStartX, frameStartY - 10);
        int startSpotX = winCentrX - multiplicator * (int) Math.round(ParseCSV.fieldX / 2),
                startSpotY = winCentrY + multiplicator * (int) Math.round(ParseCSV.fieldY / 2);

        double t1 = System.nanoTime();

        for (int i = 0; i < ParseCSV.x.size(); i++) {
            int spotX = startSpotX + multiplicator * ((int) Math.round(ParseCSV.fieldXMax)) - multiplicator * (int) Math.round(ParseCSV.x.get(i) / 1000);
            int spotY = startSpotY + multiplicator * ((int) Math.round(ParseCSV.fieldYMin)) - multiplicator * (int) Math.round(ParseCSV.y.get(i) / 1000);
            int widthX = 5;
            int widthY = 4;
            g2d.setColor(Color.black);
            g2d.fillOval(spotX, spotY, multiplicator * widthX, multiplicator * widthY);

            try {
                Thread.currentThread().sleep(Math.round(1000 * ParseCSV.spotTime.get(i)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        double t2 = System.nanoTime();
        double t3 = (t2 - t1) / 1000000000.0;
        g2d.drawString("Irradiation time is " + t3 + " sec", frameStartX + 5, frameStartY + 15);
        //JOptionPane.showMessageDialog(null, "Irradiation time is " + t3 + " sec");
        //System.out.println("Irradiation time is " + t3 + " sec");


    }

    public static void main(String[] args) {
        new DrawCircle();
    }
}
