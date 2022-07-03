public class ListNode {
    int val;
    ThreeWayQueue.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ThreeWayQueue.ListNode next) {
        this.val = val;
        this.next = next;
    }
}
