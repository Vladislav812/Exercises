public class Shuffle {
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 3, 4, 7};
        for (int ind = 0; ind < a.length; ind++) {
            System.out.print(" " + shuffle(a, 3)[ind]);
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        int l = nums.length;
        int[] output = new int[l];

        for (int i = l / 2; i < l; i++) {
            for (int j = 1; j < l; j = j + 2) {
                output[j] = nums[i];
            }
        }
        for (int i = 0; i < l / 2; i++) {
            for (int j = 0; j < l; j = j + 2) {
                output[j] = nums[i];
            }
        }

        return output;
    }
}
