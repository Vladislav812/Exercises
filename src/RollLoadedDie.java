public class RollLoadedDie  {
    public static void main(String[] args) {
        double n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0;
        int i = 0;
        for (i = 0; i < 100000; i++) {
            //int a = (int) Math.round(Math.random() * 8 + 0.5);
            int a = (int) (Math.random() * 8 + 1);
            if (a >= 6) a = 6;
            switch (a) {
                case 1:
                    n1++;
                    break;
                case 2:
                    n2++;
                    break;
                case 3:
                    n3++;
                    break;
                case 4:
                    n4++;
                    break;
                case 5:
                    n5++;
                    break;
                case 6:
                    n6++;
                    break;
            }
            //System.out.print(a + "  ");
        }
        System.out.print("\n" + n1 / i + "  " + n2 / i + "  " + n3 / i + "  " + n4 / i + "  " + n5 / i + "  " + n6 / i);
    }
}
