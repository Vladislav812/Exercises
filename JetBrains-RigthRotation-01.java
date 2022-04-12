import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();

        String[] items = s.split("\\s+");
        int[] ar = new int[items.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(items[i]);
        }
        ar = rotateArray(ar, k);
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]);
            if (i < ar.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int[] rotateArray(int[] ar, int n) {
        for (int i = 0; i < n % ar.length; i++) {
            int t = ar[ar.length - 1];
            System.arraycopy(ar, 0, ar, 1, ar.length - 1);
            ar[0] = t;
        }
        return ar;
    }
}
