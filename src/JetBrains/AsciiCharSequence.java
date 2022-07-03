package JetBrains;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    byte[] arr;

    AsciiCharSequence(byte[] arr) {
        this.arr = arr.clone();
    }

    public int length() {
        return this.arr.length;
    }

    public char charAt(int index) {
        return (char) arr[index];
    }

    public CharSequence subSequence(int start, int end) {
        byte[] subSeq = Arrays.copyOfRange(this.arr, start, end);
        return new AsciiCharSequence(subSeq);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append((char) i);
        }
        return sb.toString();
    }
}
