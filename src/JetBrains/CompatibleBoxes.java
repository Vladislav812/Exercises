package JetBrains;

import java.util.Scanner;

public class CompatibleBoxes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        for (int i = 0; i < box1.length; i++) {
            box1[i] = scanner.nextInt();
        }
        for (int i = 0; i < box2.length; i++) {
            box2[i] = scanner.nextInt();
        }

        int[][] positionsBox2 = getPositions(box2);
        for (int i = 0; i < positionsBox2.length; i++) {
            if (checkCompatibilty(positionsBox2[i], box1)) {
                System.out.println("Box 1 > Box 2");
                return;
            }
        }
        int[][] positionsBox1 = getPositions(box1);
        for (int i = 0; i < positionsBox1.length; i++) {
            if (checkCompatibilty(positionsBox1[i], box2)) {
                System.out.println("Box 1 < Box 2");
                return;
            }
        }
        System.out.println("Incompatible");

    }

    public static boolean checkCompatibilty(int[] innerBox, int[] outerBox) {
        for (int i = 0; i < innerBox.length; i++) {
            if (outerBox[i] <= innerBox[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[][] getPositions(int[] box) {
        return new int[][]{{box[0], box[1], box[2]},
                {box[0], box[2], box[1]},
                {box[1], box[0], box[2]},
                {box[1], box[2], box[0]},
                {box[2], box[1], box[0]},
                {box[2], box[0], box[1]},
        };
    }
}
