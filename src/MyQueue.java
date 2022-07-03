import java.util.Stack;

class MyQueue {

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();


    public MyQueue() {

    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.pop();
    }

    public int peek() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.peek();
    }

    public boolean empty() {
        return st1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(9);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }


}



