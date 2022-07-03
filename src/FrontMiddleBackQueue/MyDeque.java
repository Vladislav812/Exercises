package FrontMiddleBackQueue;

public class MyDeque {
    ListNode head, node, tail;

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        int size = 0;
        node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    void addFirst(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;

        } else {
            head.prev = new ListNode(val);
            head.prev.next = head;
            head = head.prev;
        }

    }

    void addLast(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            head = tail;
        } else {
            tail.next = new ListNode(val);
            tail.next.prev = tail;
            tail = tail.next;
        }

    }

    int pollFirst() {
        int out;
        if (head == null)
            return -1;
        else out = head.val;
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = head;
        }
        return out;
    }

    int pollLast() {
        int out;
        if (tail == null)
            return -1;
        else out = tail.val;
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            tail = null;
            head = tail;
        }
        return out;
    }

    public String toString() {
        String s = "[";
        node = head;
        if (node == null)
            return s += "]";
        while (node.next != null) {
            s = s + node.val + " ,";
            node = node.next;
        }
        s = s + node.val + "]";
        return s;
    }

    public static void main(String[] args) {
        MyDeque deq = new MyDeque();
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addFirst(3);
        System.out.println(deq.toString());
        deq.addLast(4);
        deq.addLast(5);
        System.out.println(deq.toString());
        deq.pollFirst();
        System.out.println(deq.toString());
        deq.pollFirst();
        System.out.println(deq.toString());
        deq.pollFirst();
        System.out.println(deq.toString());
        deq.pollFirst();

        System.out.println(deq.toString());
        System.out.println(deq.size());
        deq.pollFirst();
        System.out.println(deq.toString());
        System.out.println(deq.size());
    }
}
