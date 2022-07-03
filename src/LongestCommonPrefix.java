public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] a = {"cat", "dog", "tiger", "lynx", "bobcat", "excavator", "doggy"};
        String[] b = {"cat", "catza", "catka", "catichhe"};
        String[] c = {"flower", "flow", "flight", "flooooo", "flaer", "fla"};
        String[] d = {"a"};
        System.out.println("\"" + longestCommonPrefix(d) + "\"");
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j].length() < strs[i].length()) {
                    String t = strs[i];
                    strs[i] = strs[j];
                    strs[j] = t;
                }
            }
        }
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) return out.toString();
                if (j == strs.length - 2) out.append(strs[j].charAt(i));
            }
        }
        return out.toString();

    }

}
