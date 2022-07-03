public class New {
    public static void main(String[] args) {
        /*int[] dig = {3, 5, 3, 12, 2, 5, 7, 3, 7, 5, 10, 2};
        ArrayList<int> d2 = new ArrayList<int>();
        d2.addAll(dig);

        Collections.sort(d2);
        System.out.println(dig);*/

        String s = "wefoihfhfssodoifih tyslj4k23jhsdf s__sdkjhf ";
        StringBuilder s1 = new StringBuilder();
        s1.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s.charAt(i) == s1.charAt(j))
                    break;
                if (j == s1.length() - 1)
                    s1.append(s.charAt(i));
            }
        }
        System.out.println(s1.toString());

    }
}
