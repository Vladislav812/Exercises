package Sandbox;

class StackWithMax {
    ListNode head;


    int pop() {
        int out = head.val;
        head = head.next;
        return out;
    }

    void push(int value) {
        if (head == null) {
            head = new ListNode(value);
            head.max = value;
        } else {
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            newHead.max = Math.max(value, head.max);
            head = newHead;
        }
    }

    int max() {
        return head.max;
    }

    boolean isEmpty() {
        return head == null;
    }
}
