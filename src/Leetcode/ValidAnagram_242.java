package Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class ValidAnagram_242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s,t));

        /*char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        int[] sHash = new int[26];
        int[] tHash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sHash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tHash[t.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(sHash));*/
        //System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        Arrays.sort(sCh);
        Arrays.sort(tCh);
        HashSet<String> hs = new HashSet<>();
        hs.add(Arrays.toString(sCh));
        hs.add(Arrays.toString(tCh));
        System.out.println(hs);
        return hs.size() == 1;
    }
}
