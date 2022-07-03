import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {
    public static void main(String[] args) {
        String s = "RDDRDDRRR";
        System.out.println(predictPartyVictory(s));
    }

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> queR = new ArrayDeque<>();
        Queue<Integer> queD = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                queR.add(i);
            else queD.add(i);
        }

        while (!queD.isEmpty() && !queR.isEmpty()) {
            int voterR = queR.poll();
            int voterD = queD.poll();

            if (voterR < voterD)
                queR.add(voterR + n);
            else queD.add(voterD + n);
        }
        return (queD.isEmpty() ? "Radiant" : "Dire");
    }
}
