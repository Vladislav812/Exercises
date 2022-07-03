public class FunctionGrowth {
    public static void main(String[] args) {
        int[] a = {0, 2, 1};
        for (int i : a) {
            a[i]++;
        }
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
    }

}
