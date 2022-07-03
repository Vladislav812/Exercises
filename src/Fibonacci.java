public class Fibonacci {
    public static void main(String args[]) {
        long[] fb = new long[100];
        long startTime;
        long endTime, difference;
        double[] dif = new double[100];
        //the largest target that takes less than 1 hour to calculate:59
        //fb[i] = fb{i-1]*1.6
        System.out.println(Math.log(3600.0 / 1.087) / Math.log(1.6));

        for (int i = 0; i < 100; i++) {
            startTime = System.currentTimeMillis();
            fb[i] = F(i);
            endTime = System.currentTimeMillis();
            dif[i] = (endTime - startTime) / 1000.0;
            if (i > 0)
                System.out.println(i + " " + dif[i] + "  " + dif[i] / dif[i - 1]);
        }
    }



    /*public static void main(String[] args) {
        double[] fb = new double[100];
        fb[0] = 0.0;
        fb[1] = 1.0;
        for (int i = 2; i < 100; i++) {
            fb[i] = fb[i - 1] + fb[i - 2];
            StdOut.println(i + " " + fb[i]);
        }
    }*/


    public static long F(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return F(N - 1) + F(N - 2);
    }
}
