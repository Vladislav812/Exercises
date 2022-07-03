package FileAnalyser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class Analyser {


    public static void main(String[] args) throws Exception {
        String planID = "1.2.246.352.71.5.718681877440.110752.20220126150553";
        String inputDirectory = "D:/Wladislaw/Subsystems/SNS/LOGS/NTPC_Logs_TR1/";
        String outputDirectory = "C:/Users/Bolotin/Desktop/Copied/";
        int fields = 2;
        int[] sessionID = new int[fields];

        String[] sessionFiles;
        File f = new File(inputDirectory);
        sessionFiles = f.list();
        for (String name : sessionFiles) {
            if (name.contains("IrradiationPlan")) {
                String[] s = new String[2];
                Scanner scanner = new Scanner(new File(inputDirectory + name));
                scanner.useDelimiter(",");
                s[0] = scanner.next();
                s[1] = scanner.next();
                scanner.close();
                if (s[1].contains(planID))
                    Files.copy(Paths.get(inputDirectory + name), Paths.get(outputDirectory + name), StandardCopyOption.REPLACE_EXISTING);
            }
        }

        String[] fraction;
        File fr = new File(outputDirectory);
        fraction = fr.list();
        for (String name : fraction) {
            String[] id = name.split("[_.]");
            System.out.println(id[2]);
        }


    }


}

