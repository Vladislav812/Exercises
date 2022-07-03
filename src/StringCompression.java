import java.util.ArrayList;

public class StringCompression {
    public static void main(String[] args) {
        //char[] ex1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        //char[] ex1 = {'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c' };
        //char[] ex1 = {'a', 'a', 'a', 'b', 'b', 'a', 'a' };
        //char[] ex1 = {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        //char[] ex1 = {'a', 'b', 'c', 'd', 'e', 'f' };
        //char[] ex1 = {'a', 'a', 'a' };
        //char[] ex1 = {'a', 'a' };
        //char[] ex1 = {'a' };
        char[] ex1 = {'a', 'a', 'a', 'a', 'a', 'b' };
        System.out.println(compress(ex1));
        System.out.println(ex1);

    }

    public static int compress(char[] chars) {
        int pointer = 0;
        int length = 0;
        if (chars.length == 1) return 1;
        while (pointer < chars.length) {
            int count = 1;
            int i = 0;

            while ((pointer + i + 1 < chars.length) && chars[pointer + i] == chars[pointer + i + 1]) {  //count the number of the same letters
                count++;
                i++;

            }

            if (count == 1) {    //in case of single letter continue the loop
                chars[length] = chars[pointer];
                pointer += count;
                length++;
                continue;
            }

            chars[length] = chars[pointer];  // place the letter in proper position

            ArrayList<Character> digs = countToDigit(count);  //write down number of letters after corresponding letter
            for (int j = 0; j < digs.size(); j++) {
                chars[length + 1 + j] = digs.get(j);
            }

            pointer += count;
            length = length + 1 + digs.size();
        }
        return length;
    }

    public static ArrayList<Character> countToDigit(int count) {
        ArrayList<Character> digs = new ArrayList<Character>();
        double k = (double) count;
        while (k >= 1) {      //count all digits and write them down into list 'digs'
            digs.add((char) ('0' + count % 10));
            count = (int) count / 10;
            k /= 10;
        }
        for (int i = 0; i < digs.size() / 2; i++) {    //invert digs
            char element = digs.get(i);
            digs.set(i, digs.get(digs.size() - 1 - i));
            digs.set(digs.size() - 1 - i, element);
        }
        return digs;
    }
}
