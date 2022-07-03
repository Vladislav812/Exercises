package Sandbox;

public class GenericStack<T> {
    ListNode<T> head;

    void push(T val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }
    }

    T pop() {
        if (head == null) {
            System.out.println("Ничого нету!");
            return null;
        } else {
            T pop = head.val;
            head = head.next;
            return pop;
        }
    }

    T peek() {
        if (head == null) {
            System.out.println("Ничого нету!");
            return null;
        } else {
            return head.val;
        }
    }
}
