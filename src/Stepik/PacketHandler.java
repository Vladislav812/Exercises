package Stepik;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class PacketHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxBufSize = scanner.nextInt();
        int n = scanner.nextInt();
        if (n == 0) return;
        scanner.nextLine();

        int[] arrival = new int[n + 1];
        int[] duration = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] s = (scanner.nextLine()).split("\\s+");
            arrival[i] = Integer.parseInt(s[0]);
            duration[i] = Integer.parseInt(s[1]);
        }

        int endTime = getEndTime(arrival, duration);

        int[] processing = new int[n + 1];
        Arrays.fill(processing, -1);
        Queue<Integer> buffer = new ArrayDeque<>();

        int i = 0;
        int time = 0;
        while (i < n + 1) {

            if (!buffer.isEmpty()) {
                int index = buffer.peek();
                if (processing[index] + duration[index] <= time) {
                    buffer.poll();
                }
            }

            if (time == arrival[i]) {
                if (buffer.size() < maxBufSize) {
                    buffer.add(i);
                }
                i++;
            }

            if (!buffer.isEmpty() && processing[buffer.peek()] == -1) {
                processing[buffer.peek()] = time;
            }

            if (i < n + 1 && arrival[i] != time) {
                time++;
            }
            //System.out.println(buffer.peek());
        }

       /* for (int packetTime : processing) {
            System.out.println(packetTime);
        }*/

        for (int j = 0; j < processing.length - 1; j++) {
            System.out.println(processing[j]);
        }
    }

    static int getEndTime(int[] arrival, int[] duration) {
        int[] ar = arrival.clone();
        int[] dur = duration.clone();
        Arrays.sort(ar);
        Arrays.sort(dur);
        return ar[ar.length - 1] + dur[dur.length - 1];
    }
}
