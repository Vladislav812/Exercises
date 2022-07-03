package LogsAnalyser;

import javax.swing.*;
import java.awt.*;

public class ParseVar {
    ParseVar(String filePath, String var) {
    }

    public static String getFileName() {
        JFileChooser chooser = new JFileChooser("D:/Wladislaw/Subsystems/SNS/LOGS/LogsTR2 - SNS - NTPC_Morning_beam_pos");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setPreferredSize(new Dimension(900, 500));
        chooser.showSaveDialog(null);
        String filename = chooser.getSelectedFile().getName();
        return filename;
    }

    public static void main(String[] args) {
        getFileName();

    }

}
