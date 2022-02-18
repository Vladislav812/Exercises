package FrontMiddleBackQueue;


public class FrontMiddleBackQueue {
    MyDeque frstDeq = new MyDeque();
    MyDeque scndDeq = new MyDeque();

    public FrontMiddleBackQueue() {

    }

    public void pushFront(int val) {
        frstDeq.addFirst(val);

        if (frstDeq.size() > scndDeq.size() + 1)
            scndDeq.addFirst(frstDeq.pollLast());

    }

    public void pushMiddle(int val) {
        if (frstDeq.size() <= scndDeq.size())
            frstDeq.addLast(val);
        else {
            scndDeq.addFirst(frstDeq.pollLast());
            frstDeq.addLast(val);
        }

    }

    public void pushBack(int val) {
        scndDeq.addLast(val);
        if (scndDeq.size() > frstDeq.size())
            frstDeq.addLast(scndDeq.pollFirst());

    }

    public int popFront() {
        if (!frstDeq.isEmpty()) {
            int out = frstDeq.pollFirst();
            if (scndDeq.size() > frstDeq.size())
                frstDeq.addLast(scndDeq.pollFirst());
            return out;
        } else return -1;
    }

    public int popMiddle() {
        if (!frstDeq.isEmpty()) {
            int out = frstDeq.pollLast();
            if (scndDeq.size() > frstDeq.size())
                frstDeq.addLast(scndDeq.pollFirst());
            return out;
        } else return -1;
    }

    public int popBack() {
        if (!scndDeq.isEmpty()) {
            int out = scndDeq.pollLast();
            if (frstDeq.size() > scndDeq.size() + 1)
                scndDeq.addFirst(frstDeq.pollLast());
            return out;
        } else if (!frstDeq.isEmpty())
            return frstDeq.pollLast();

        else return -1;
    }

    public void print() {
        System.out.println(frstDeq.toString() + " || " + scndDeq.toString());
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);
        q.print();
        q.pushBack(2);
        q.print();// [1, 2]
        q.pushMiddle(3);
        q.print();// [1, 3, 2]
        q.pushMiddle(4);
        q.print(); // [1, 4, 3, 2]
        q.popFront();
        q.print();// return 1 -> [4, 3, 2]
        q.popMiddle();
        q.print();  // return 3 -> [4, 2]
        q.popMiddle();
        q.print();// return 4 -> [2]
        q.popBack();
        q.print();      // return 2 -> []
        q.popFront();

    }
}
