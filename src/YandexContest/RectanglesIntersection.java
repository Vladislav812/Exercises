package YandexContest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class RectanglesIntersection {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("src/YandexContest/input.txt"));
        int number = scanner.nextInt();
        int[][] rectangles = new int[number][4];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < 4; j++) {
                rectangles[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        int[] counts = new int[number];
        for (int i = 0; i < number; i++) {
            int xLB1 = rectangles[i][0], yLB1 = rectangles[i][1], xRT1 = rectangles[i][2], yRT1 = rectangles[i][3];
            int xLT1 = xLB1, yLT1 = yRT1, xRB1 = xRT1, yRB1 = yLB1;

            for (int j = 0; j < number; j++) {
                if (i == j) continue;
                int xLB2 = rectangles[j][0], yLB2 = rectangles[j][1], xRT2 = rectangles[j][2], yRT2 = rectangles[j][3];
                int xLT2 = xLB2, yLT2 = yRT2, xRB2 = xRT2, yRB2 = yLB2;

                if (xRB1 > xLT2 && yRB1 < yLT2 && xLT1 < xRB2 && yLT1 < yRB2) counts[i]++;
                else if (xRT1 > xLB2 && yRT1 > yLB2 && xLB1 < xRT2 && yLB1 < yRT2) counts[i]++;
                else if (xLT1 < xRB2 && yLT1 > yRB2 && xRB1 > xLT2 && yRB1 < yLT2) counts[i]++;
                else if (xLB1 < xRT2 && yLB1 < yRT2 && xRT1 > xLB2 && yRT1 > yLB2) counts[i]++;
            }
        }

        for (int i = 0; i < number; i++) {
            Files.writeString(Paths.get("src/YandexContest/output.txt"), counts[i] + " ", StandardOpenOption.APPEND);
        }

    }
}
