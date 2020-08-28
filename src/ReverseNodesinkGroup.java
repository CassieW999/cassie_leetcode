public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // if (k == 1 || head.next == null) return head;
        int n = 0;
        ListNode cur = head;
        while (cur != null) {   // get length first
            n++;
            cur = cur.next;
        }

        // main reversion logic
        ListNode dh = new ListNode(0), prev = dh;
        dh.next = head;
        for (int i = k; i <= n; i += k) {   // divide the list into section of k elements
            ListNode con = prev, tail = head;   // before each reversion, keep pointer of prev and the expected tail
            for (int j = 0; j < k; j++) {   // for each section use standard linkedList reversal algorithm
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            con.next = prev;    // connected the previous section to the just reversed section.
            tail.next = head;   // connected the tail to the next section
            prev = tail;    // reset the prev to the node before the next section.
        }
        return dh.next;
    }
}
