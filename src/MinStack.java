import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> a;
    int val;

    public MinStack() {
        a = new ArrayList();
    }

    public void push(int val) {
        a.add(val);
    }

    public void pop() {
        a.remove(a.size() - 1);
    }

    public int top() {
        return a.get(a.size() - 1);
    }

    public int getMin() {
        int min = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < min)
                min = a.get(i);
        }
        return min;
    }
}

