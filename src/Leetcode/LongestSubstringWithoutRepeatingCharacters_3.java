package Leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  s = scanner.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    public  static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<>();
        int maxLength = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            if (!hash.contains(s.charAt(right))) {
                hash.add(s.charAt(right));
                right++;
            } else {
                maxLength = Math.max(maxLength, hash.size());
                hash.remove(s.charAt(left));
                left++;
            }
        }
        return Math.max(maxLength, hash.size());
    }
}
