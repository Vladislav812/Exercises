package Leetcode;

public class CanMakeArithmeticProgressionFromSequence_1502_2 {
    public static void main(String[] args) {
        //int[] arr = {5, 1, 3};
        int[] arr = {1, 2, 4};
        //int[] arr = {20, 17, -18, -13, 13, -14, -8, 10, 1, 14, -19, 21};
        //int[] arr = {-9, 6, 9, -3, 12, 0, -6, 3, -12};
        // int[] arr = {1, 2, 4, 5, 3, 7};

        System.out.println(canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3)
            return true;

        //progression: An=Ao+k*n

        //find first and last progression elements
        int first = arr[0], last = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < first)
                first = arr[i];
            else if (arr[i] > last)
                last = arr[i];
        }

        //difference
        int k;
        if ((last - first) % (arr.length - 1) != 0)
            return false;
        else k = (last - first) / (arr.length - 1);
        if (k == 0) return true;

        //check if all sequence elements are in progression
        //An=Ao+k*n => n = (An-Ao)/k
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - first) % k == 0) {  //n must be integer
                int n = (arr[i] - first) / k;
                if (n == i) {  //element is in its exact position
                    continue;
                }
                if (arr[n] != arr[i] && n < arr.length) {  //no duplicates and n is in progression range
                    int t = arr[n];
                    arr[n] = arr[i];
                    arr[i] = t;
                } else return false;
            } else return false;
        }

        return true;
    }
}
