package Alice;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Alice {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("src/Alice/input.txt"));
        int length = scanner.nextInt();
        int[] words = new int[length];

        int i = 0;
        while (scanner.hasNext()) {
            words[i] = scanner.nextInt();
            i++;
        }

        scanner.close();
        String out = "";
        int sum = 0;
        for (int j = 0; j < words.length; j++) {
            int W = Math.abs(words[j] - sum);
            out = out + getChar(getPower(W));
            sum = words[j];
        }
        Files.writeString(Paths.get("src/Alice/output.txt"), out, StandardOpenOption.APPEND);
        System.out.println(out);
    }

    public static int getPower(int word) {
        String s = Integer.toBinaryString(word);
        return s.length() - 1;

    }


    public static char getChar(int W) {
        if (W >= 0 && W <= 25)
            return (char) (97 + W);
        else return ' ';
    }
}

