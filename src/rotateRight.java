public class rotateRight {
    //solution 1 O(n) O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;

        if (k == 0) return head;

        for (int i = 0; i < k; i++){
            q = q.next;
            if (q == null){
                q = head;
            }
        }
        if (q.next == null) return head;

        while(q.next != null){
            p = p.next;
            q = q.next;
        }

        ListNode con = p.next;
        p.next = null;
        dummy.next = con;
        q.next = head;

        return dummy.next;
    }
}
