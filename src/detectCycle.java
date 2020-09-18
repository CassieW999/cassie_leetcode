public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        while(fast != null && slow != null){
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;

        while(head != slow){
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
