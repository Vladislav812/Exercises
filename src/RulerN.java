public class RulerN{
    public static void main(String[] args) {
        /*String ruler1 = " 1 ";
        String ruler2 = ruler1 + "2" + ruler1;
        String ruler3 = ruler2 + "3" + ruler2;
        String ruler4 = ruler3 + "4" + ruler3;
        String ruler5 = ruler4 + "5" + ruler4;

        System.out.println(ruler1);
        System.out.println(ruler2);
        System.out.println(ruler3);
        System.out.println(ruler4);
        System.out.println(ruler5);*/

        int n = Integer.parseInt(args[0]);
        StringBuilder ruler = new StringBuilder();
        StringBuilder rulPrev = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            ruler.append(i);
            ruler.append(rulPrev);
            System.out.println(ruler);
            //rulPrev.insert(0, ruler);
            //rulPrev.setLength(ruler.length());
            rulPrev.replace(0, ruler.length(), ruler.toString());
        }


    }

}
