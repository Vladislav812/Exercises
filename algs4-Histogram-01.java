public class Main {
    public static void main(String[] args) {
        int[] ar = {3, 4, 5, 5, 5, 1, 6, 7, 1, 1, 1, 1, 4, 7, 6, 8, 3, 3, 4, 5};
        System.out.println(histogram(ar, 10)[7]);
        //System.out.println(exR1(6));

    }

    static int[] histogram(int[] a, int M) {
        int[] b = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i)
                    b[i]++;
            }
        }
        return b;
    }

    static int sum(int[] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
        }
        return sum;
    }
    
}

