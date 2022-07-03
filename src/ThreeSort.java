public class ThreeSort {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        //int mid = Math.max(Math.min(a, b), Math.max(Math.min(a, c), Math.min(b, c)));
        int mid = Math.min(Math.max(a, b), Math.min(Math.max(a, c), Math.max(b, c)));
        System.out.println(min);
        System.out.println(mid);
        System.out.println(max);
    }
}

