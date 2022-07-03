import edu.princeton.cs.algs4.In;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 12, 4, 7, 11};

        ThreeWayQueue.ListNode transit = straightList(arr);
        printList(transit);

        transit = reverseList(arr);
        printList(transit);

        transit = oddAndEvenList(arr);
        printList(transit);

    }

    public static ThreeWayQueue.ListNode oddAndEvenList(int[] arr) {
        ThreeWayQueue.ListNode dummy, transit;
        dummy = new ThreeWayQueue.ListNode();
        transit = dummy;
        for (int i = 1; i < arr.length; i += 2) {
            transit.next = new ThreeWayQueue.ListNode();
            transit.next.val = arr[i];
            transit = transit.next;
        }

        for (int i = 0; i < arr.length; i += 2) {
            transit.next = new ThreeWayQueue.ListNode();
            transit.next.val = arr[i];
            transit = transit.next;
        }

        return dummy.next;
    }

    public static ThreeWayQueue.ListNode reverseList(int[] arr) {
        ThreeWayQueue.ListNode guard, transit;
        guard = new ThreeWayQueue.ListNode();
        transit = guard;
        for (int i = arr.length - 1; i >= 0; i--) {
            transit.next = new ThreeWayQueue.ListNode();
            transit.next.val = arr[i];
            transit = transit.next;
        }
        return guard.next;
    }

    public static ThreeWayQueue.ListNode straightList(int[] arr) {
        ThreeWayQueue.ListNode sentinel = new ThreeWayQueue.ListNode();
        ThreeWayQueue.ListNode transit = sentinel;
        for (int i = 0; i < arr.length; i++) {
            transit.next = new ThreeWayQueue.ListNode();
            transit.next.val = arr[i];
            transit = transit.next;
        }
        return sentinel.next;
    }

    In in = new In();

    public static void printList(ThreeWayQueue.ListNode head) {
        ThreeWayQueue.ListNode list = head;
        while (list != null) {
            if (list.next != null) System.out.print(list.val + "->");
            else System.out.println(list.val + "->null");
            list = list.next;
        }
    }
}



