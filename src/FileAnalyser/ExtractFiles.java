package FileAnalyser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class ExtractFiles {
    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        String planID = "1.2.246.352.71.5.718681877440.110752.20220126150553";
        String inputDirectory = "D:/Wladislaw/Subsystems/SNS/LOGS/NTPC_Logs_TR1/";
        String outputDirectory = "C:/Users/Bolotin/Desktop/Copied/";
        File planDirectory = new File(outputDirectory + planID);
        if (!planDirectory.exists())
            planDirectory.mkdir();


        int fields = 2;
        int[] sessionID = new int[fields];

        String[] planFiles;
        File f = new File(inputDirectory);
        planFiles = f.list();
        for (String name : planFiles) {
            Scanner scanner = new Scanner(new File(inputDirectory + name));
            String[] s = new String[3];
            scanner.useDelimiter(",");
            int i = 0;

            while (scanner.hasNext()) {

                if (i > s.length - 2)
                    s = enlarge(s);
                s[i] = scanner.next();
                i++;
                if (s[i] != null && s[i].contains(planID)) {
                    Files.copy(Paths.get(inputDirectory + name), Paths.get((planDirectory + "/" + name)), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(name);
                    break;
                }

            }
            scanner.close();
        }

        /*String[] fraction;
        outputDirectory = planDirectory + "/";
        File fr = new File(outputDirectory);
        fraction = fr.list();
        for (String name : fraction) {
            String[] id = name.split("[_.]");
            System.out.println(id[2]);
        }*/
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd + "|" + time);

    }

    public static String[] enlarge(String[] s) {
        String[] out = new String[s.length * 2];
        for (int i = 0; i < s.length; i++)
            out[i] = s[i];
        return out;
    }

}

