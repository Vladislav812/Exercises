public class RansomeNote {

    public static void main(String[] args) {
        String ransomNote = "jjhafiecg";
        String magazine = "gjjhafiecg";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder mag = new StringBuilder();
        for (int i = 0; i < magazine.length(); i++) {
            mag.append(magazine.charAt(i));
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            for (int j = 0; j < mag.length(); j++) {
                if (ransomNote.charAt(i) == mag.charAt(j)) {
                    mag.setCharAt(j, ' ');
                    break;
                }
                if (j == mag.length() - 1) return false;
            }

        }

        return true;
    }

}
