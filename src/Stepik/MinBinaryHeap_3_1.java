package Stepik;

import java.util.ArrayList;
import java.util.Scanner;

public class MinBinaryHeap_3_1 {

    static int[] heap;
    static int swapCount = 0;
    static ArrayList<int[]> swaps = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        heap = new int[n];
        for (int i = 0; i < n; i++) {
            heap[i] = scanner.nextInt();
        }

        for (int i = heap.length / 2; i >= 0; i--) {//all algorithm is to recursively sift down upper half of the array starting from length/2 to zero index
            siftDown(i);
        }

        System.out.println(swapCount);
        for (int i = 0; i < swaps.size(); i++) {
            System.out.println(swaps.get(i)[0] + " " + swaps.get(i)[1]);
        }
    }

    static int leftChild(int i) {
        return 2 * i + 1;
    }

    static int rightChild(int i) {
        return 2 * i + 2;
    }

    static void siftDown(int i) {

        int minIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);
        //finding index of minimum element from parent and two children:
        if (l < heap.length && heap[l] < heap[minIndex]) {
            minIndex = l;
        }
        if (r < heap.length && heap[r] < heap[minIndex]) {
            minIndex = r;
        }

        if (i != minIndex) {
            swaps.add(new int[]{Math.min(i, minIndex), Math.max(i, minIndex)});
            swapCount++;
            int t = heap[i];
            heap[i] = heap[minIndex];
            heap[minIndex] = t;

            siftDown(minIndex);
        }
    }
}
