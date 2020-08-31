public class sortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = null;

        ListNode leftHalf = sortList(head), rightHalf = sortList(slow);

        return merge(leftHalf, rightHalf);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode p1 = left, p2 = right, head = new ListNode(-1), tmp = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tmp.next = p1;
                p1 = p1.next;
            } else {
                tmp.next = p2;
                p2 = p2.next;
            }
            tmp = tmp.next;
        }

        if (p1 != null) tmp.next = p1;
        if (p2 != null) tmp.next = p2;
        return head.next;
    }
}
