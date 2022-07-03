package Leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) throws FileNotFoundException {
        //String[] s = {"eat","tea","tan","ate","nat","bat"};
        //String[] s = {""};
        //String[] s = {"a"};
        Scanner scanner = new Scanner(new File("D:/Java_projects_and_resources/Exercises/src/Leetcode/GroupAnagrams_TestCase111"));
        //String[] s = scanner.nextLine().split("\",\"");
        System.out.println(groupAnagrams(s));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str:strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            hashMap.put(toString(chars), str);
        }
       List<List<String>> output = new ArrayList<>();
        for (String strSort: hashMap.keySet()) {
            List<String> stringList = new ArrayList<>();
            for (String s : strs) {
                if (isAnagram(strSort, s)) {
                    stringList.add(s);
                }
            }
            if (stringList.size()!=0) {
                output.add(stringList);
            }
        }
        return output;
    }

    public static boolean isAnagram(String s, String t) {
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        Arrays.sort(sCh);
        Arrays.sort(tCh);
        HashSet<String> hs = new HashSet<>();
        hs.add(Arrays.toString(sCh));
        hs.add(Arrays.toString(tCh));
        return hs.size() == 1;
    }

    static String toString(char[] ch) {
        StringBuilder sb = new StringBuilder();
        for (char c:ch) {
            sb.append(c);
        }
        return sb.toString();
    }
}
