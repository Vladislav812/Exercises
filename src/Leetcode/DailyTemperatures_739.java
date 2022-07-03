package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;

public class DailyTemperatures_739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        dailyTemperatures(temperatures);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        ArrayList<Temp> ar = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {
            ar.add(new Temp(i, temperatures[i]));
        }
        Comparator<Temp> compareByValue = new Comparator<Temp>() {
            public int compare(Temp o1, Temp o2) {
                return o1.value - o2.value;
            }
        };
        ar.sort(compareByValue);

        int[] out = new int[temperatures.length];

        for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if (ar.get(i).index < ar.get(j).index && ar.get(i).value < ar.get(j).value) {
                    out[ar.get(i).index] = ar.get(j).index - ar.get(i).index;
                    break;
                }
            }
        }


        printTemp(ar);
        return out;
    }

    static void printTemp(ArrayList<Temp> ar) {
        for (Temp t : ar) {
            System.out.print("{" + t.index + " | " + t.value + "},  ");
        }
    }

}
