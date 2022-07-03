package Exercises2;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] nums = new long[n];
        int i = 0;
        while (scanner.hasNext()) {
            nums[i] = Long.parseLong(scanner.next());
            i++;
        }
        //System.out.println(Arrays.toString(nums));
        long startSum = sum(nums);
        long diff = 0L;
        for (int p = 1; p <= k; p++) {
            nums = oneIteration(nums);
        }
        long finSum = sum(nums);
        //System.out.println(Arrays.toString(nums));
        System.out.println(finSum - startSum);

    }


    static long[] oneIteration(long[] nums) {
        long maxSum = sum(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            long[] copy = nums.clone();
            copy[i] = maximize(nums[i]);
            if (sum(copy) > maxSum) {
                index = i;
                maxSum = sum(copy);
            }
        }
        nums[index] = maximize(nums[index]);
        return nums;
    }

    static long sum(long[] nums) {
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    static long maximize(long n) {
        ArrayList<Long> digits = new ArrayList<>();
        if (n == 0)
            digits.add(0L);
        while (n >= 1) {
            digits.add(n % 10);
            n /= 10;
        }
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits.get(i) == 9) continue;
            else {
                digits.set(i, 9L);
                break;
            }
        }
        n = 0;
        for (int i = 0; i < digits.size(); i++) {
            n += digits.get(i) * Math.pow(10, i);
        }
        return n;
    }
}
