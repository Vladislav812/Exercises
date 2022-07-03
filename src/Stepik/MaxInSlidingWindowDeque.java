package Stepik;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxInSlidingWindowDeque {
    public static void main(String[] args) {
        //int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        int[] nums = {7, 2, 4};
        //int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        //int[] nums = {2, 5, 6, 3, 7, 4, 8, 1};
        int m = 2;
        int[] maxs = new int[nums.length - m + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        dq.push(m - 1);
        for (int i = m - 2; i >= 0; i--) {
            if (nums[i] > nums[dq.peek()])
                dq.addFirst(i);
            else dq.addFirst(dq.peekFirst());
        }
        
        maxs[0] = nums[dq.peekFirst()];
        System.out.println(dq.toString());
        for (int i = m; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i + 1 - m)
                dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.addLast(i);
            maxs[i - m + 1] = nums[dq.peekFirst()];
            System.out.println(dq.toString());
        }
        System.out.println(Arrays.toString(maxs));
    }
}
