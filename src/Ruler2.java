public class Ruler2 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StringBuilder ruler = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            ruler.append(i).append(ruler);
            ruler.setLength(ruler.length() - 1);
            System.out.println(ruler);

        }
    }
}
