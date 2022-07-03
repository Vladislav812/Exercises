package LogsAnalyser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParseCSV {

    public static String filePath = "D:/Wladislaw/Subsystems/SNS/LOGS/LogsTR2 - SNS - NTPC_Morning_beam_pos/";
    public static String fileName = getFileName();

    public static String getFileName() {
        JFileChooser chooser = new JFileChooser(filePath);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setPreferredSize(new Dimension(900, 500));
        chooser.showSaveDialog(null);
        String filename = chooser.getSelectedFile().getName();
        return filename;
    }

    public static String path = filePath + fileName;

    public static ArrayList<Double> parseVar(String filePath, int start, int period) throws IOException {
        Scanner scanner = new Scanner(new File(path));
        scanner.useDelimiter(",|\\n");
        ArrayList<String> in = new ArrayList<>();
        while (scanner.hasNext())
            in.add(scanner.next());
        scanner.close();
        ArrayList<Double> out = new ArrayList<>();
        int j = 0;
        for (int i = start; i < in.size(); i++) {
            if (j == period) {
                out.add(Double.parseDouble(in.get(i)));
                j = 0;
            }
            j++;
        }
        return out;
    }


    public static ArrayList<Double> spotTime;

    static {
        try {
            spotTime = parseVar(path, 21, 18);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static ArrayList<Double> x;

    static {
        try {
            x = parseVar(path, 9, 18);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static ArrayList<Double> y;

    static {
        try {
            y = parseVar(path, 10, 18);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static double fieldXMin = (Collections.min(x)) / 1000;
    static double fieldXMax = (Collections.max(x)) / 1000;
    static double fieldYMin = (Collections.min(y)) / 1000;
    static double fieldYMax = (Collections.max(y)) / 1000;
    static double fieldX = (Collections.max(x) - Collections.min(x)) / 1000;
    static double fieldY = (Collections.max(y) - Collections.min(y)) / 1000;


    public static void main(String[] args) throws Exception {
        /*double sum = 0;
        for (int i = 0; i < spotTime.size(); i++) {
            System.out.println(Math.round(1000 * spotTime.get(i)));
            sum += spotTime.get(i);
        }
        System.out.println(sum);
        System.out.println(fileName);*/
    }

}
