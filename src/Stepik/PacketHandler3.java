package Stepik;


//Final working solution

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class PacketHandler3 {
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
        scanner.close();
        int[] processing = new int[n + 1];
        Arrays.fill(processing, -1);
        Queue<Integer> buffer = new ArrayDeque<>();
        int i = 0;
        int currentPacketIndex = i;
        int currentTime = arrival[currentPacketIndex];

        while (i < n || (i >= n && !buffer.isEmpty())) {

            if (i < n && buffer.isEmpty()) {
                if (duration[i] == 0) {
                    processing[i] = arrival[i];
                    i++;
                    currentTime = arrival[i];
                    continue;
                }
                buffer.add(i);
                i++;
            }

            currentPacketIndex = buffer.peek();
            processing[currentPacketIndex] = currentTime;

            while (i < n && (arrival[i] < (currentTime + duration[currentPacketIndex]))) {
                if (buffer.size() < maxBufSize) {
                    buffer.add(i);
                }
                i++;
            }

            buffer.poll();
            currentTime = buffer.isEmpty() ? arrival[i] : currentTime + duration[currentPacketIndex];

        }

        for (int j = 0; j < processing.length - 1; j++) {
            System.out.println(processing[j]);
        }
    }
}
