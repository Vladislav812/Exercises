import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class TwoNumsSumTexts {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/input.txt"));
        String J = "", S = "";

        if (scanner.hasNext())
            J = J + scanner.next();
        //J = scanner.nextLine();
        System.out.println(J);
        if (scanner.hasNext())
            S = S + scanner.next();
        scanner.close();
        StringBuilder JJ = new StringBuilder();
        if (J.length() > 0) {

            int coun;
            for (int i = 0; i < J.length() - 1; i++) {
                coun = 0;
                for (int j = i + 1; j < J.length(); j++) {
                    if (J.charAt(i) == J.charAt(j))
                        coun++;
                    if (coun == 0 && j == J.length() - 1)
                        JJ.append(J.charAt(i));
                }
            }
            JJ.append(J.charAt(J.length() - 1));

            //System.out.println(JJ.toString());
        }
        J = JJ.toString();

        int counter = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j))
                    counter++;
            }
        }
        Files.writeString(Paths.get("src/output.txt"), Integer.toString(counter), StandardOpenOption.APPEND);

    }
}
