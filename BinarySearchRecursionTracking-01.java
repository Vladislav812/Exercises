public class BinarySearch {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.print("lo:" + lo + ", hi:" + hi + "\n");
        depth++;
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key, a, lo, mid - 1, depth);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, depth);
        else return mid;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 6, 7, 8, 9, 10, 11, 14, 20, 34, 40, 43, 55, 70, 100, 120};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        rank(120, a);
    }
}
