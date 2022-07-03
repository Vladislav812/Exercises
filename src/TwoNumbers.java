import java.util.Arrays;

public class TwoNumbers {
    public static void main(String[] args) {

        int x = Integer.parseInt(args[0]);


        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14, 15, 16, 17};
        System.out.println(Arrays.toString(twoSums(a, x)));


    }

    public static int[] twoSums(int[] nums, int target) {
        int[] out = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        out[0] = 0;
        out[1] = 0;
        return out;
    }

    ;

}
