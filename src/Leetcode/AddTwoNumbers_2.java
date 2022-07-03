package Leetcode;

public class AddTwoNumbers_2 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        StringBuilder sb = new StringBuilder();
        while(node1.next != null) {
            sb.append(node1.val);
            node1 = node1.next;
        }
        int num1 = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder();
        while(node2.next != null) {
            sb.append(node1.val);
            node2 = node1.next;
        }
        int num2 = Integer.parseInt(sb.reverse().toString());
        int num = num1 + num2;
        sb = new StringBuilder(Integer.toString(num));
        sb.reverse();

        ListNode out = new ListNode();
        ListNode head = out;
        for (int i = 0; i < sb.length(); i++) {
            out.next = new ListNode(Integer.parseInt(String.valueOf(sb.charAt(i))));
            out = out.next;
        }
        return head;
    }
}
