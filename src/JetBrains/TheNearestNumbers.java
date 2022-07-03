package JetBrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheNearestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ar = new ArrayList<>();
        String[] str = scanner.nextLine().split("\\s+");
        for (String s : str) {
            ar.add(Integer.parseInt(s));
        }
        int n = scanner.nextInt();

        ArrayList<Integer> distance = new ArrayList<>();
        for (int a : ar) {
            distance.add(Math.abs(a - n));
        }

        int min = Collections.min(distance);

        ArrayList<Integer> out = new ArrayList<>();
        for (int i = 0; i < distance.size(); i++) {
            if (distance.get(i) == min) {
                out.add(ar.get(i));
            }
        }

        Collections.sort(out);

        for (int o : out) {
            System.out.print(o + " ");
        }
    }
}
