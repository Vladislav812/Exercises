package ThreeWayQueue;

class FrontMiddleBackQueue {
    ListNode head, node;
    int length;

    public FrontMiddleBackQueue() {
        length = 0;
    }

    public void pushFront(int val) {
        if (length == 0) {
            head = new ListNode();
            node = head;
        } else {
            node = head;
            node.prev = new ListNode();
            node.prev.next = node;
            node = node.prev;
            head = node;
        }
        node.val = val;
        length++;

    }

    public void pushMiddle(int val) {
        if (length == 0 || length == 1)
            pushFront(val);
        else {
            node = head;
            int iter = 0;
            while (node.next != null && iter != (int) length / 2 - 1) {
                node = node.next;
                iter++;
            }
            ListNode mid = node.next;
            node.next = new ListNode();
            node.next.prev = node;
            node = node.next;
            node.next = mid;
            mid.prev = node;
            node.val = val;
            length++;
        }
    }

    public void pushBack(int val) {
        if (length == 0) {
            head = new ListNode();
            node = head;
        } else {
            node = head;
            int iter = 0;
            while (iter != length - 1) {
                node = node.next;
                iter++;
            }
            node.next = new ListNode();
            node.next.prev = node;
            node = node.next;
        }
        node.val = val;
        length++;
    }

    public int popFront() {
        if (length == 0)
            return -1;

        int out = head.val;
        if (length == 1) {
            head = null;
            length--;
            return out;
        }

        head = head.next;
        head.prev = null;
        length--;
        return out;
    }

    public int popMiddle() {
        if (length == 0 || length == 1)
            return popFront();

        node = head;
        int iter = 0;
        while (iter != (int) Math.round(length / 2.0)) {
            node = node.next;
            iter++;
        }
        int out = node.prev.val;
        node.prev = node.prev.prev;
        if (node.prev != null)
            node.prev.next = node;
        else
            head = node;
        length--;
        return out;

    }

    public int popBack() {
        if (length == 0 || length == 1)
            return popFront();

        node = head;
        int iter = 0;
        while (iter != (int) length - 2) {
            node = node.next;
            iter++;
        }
        int out = node.next.val;
        node.next = null;
        length--;
        return out;
    }

    public void print() {
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("l=" + length + "\n");
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        q.popFront();     // return 1 -> [4, 3, 2]
        q.popMiddle();    // return 3 -> [4, 2]
        q.popMiddle();    // return 4 -> [2]
        q.popBack();      // return 2 -> []
        q.popFront();     // return -1 -> [] (The queue is empty)b
        q.pushBack(11);
        q.pushMiddle(12);
        q.print();
        q.popBack();
        q.print();

    }
}

class ListNode {
    int val;
    ListNode next, prev;
}

