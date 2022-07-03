public class MyStack {
    int[] ar = new int[0];
    int x;

    MyStack() {

    }

    public void push(int x) {
        if (ar.length == 0) {
            ar = new int[1];
            ar[0] = x;
        } else {
            int last = ar[ar.length - 1];
            int[] br = new int[ar.length + 1];
            br[br.length - 1] = x;
            System.arraycopy(ar, 0, br, 0, ar.length);
            ar = br;
        }
    }

    public int pop() {
        int last = ar[ar.length - 1];
        int[] br = new int[ar.length - 1];
        for (int i = 0; i < br.length; i++) {
            br[i] = ar[i];
        }
        ar = br;
        return last;
    }

    public int top() {
        return ar[ar.length - 1];
    }

    public boolean empty() {
        if (ar.length == 0)
            return true;
        else return false;
    }

    public void print(int[] ar) {
        for (int j : ar) {
            System.out.print(j + " ");
        }
    }
}
