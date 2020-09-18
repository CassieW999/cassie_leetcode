public class reorderList {
    public void reorderList(ListNode head) {
        if ( head == null || head.next == null || head.next.next == null ) return;

        ListNode half = head;
        ListNode full = head;

        while( full != null && full.next != null ){
            half = half.next;
            full = full.next.next;
        }

        ListNode prev = half;
        ListNode temp = half.next;
        half.next = null;
        while( temp != null ){
            ListNode tempNext = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempNext;
        }
        // 1 -> 2 -> 3 <- 4 <- 5

        ListNode tailPrev = null;
        ListNode tail = prev;
        ListNode forward = head;

        while( tail != null && tail != forward ){ // tail != forward avoid circular reference.
            ListNode tailNext = tail.next;
            ListNode forwardNext = forward.next;

            if ( tailPrev != null ) tailPrev.next = forward;
            forward.next = tail;
            tailPrev = tail;

            tail = tailNext;
            forward = forwardNext;
        }
        // 1 -> 4 -> 2 -> 3
        // 1 -> 5 -> 2 -> 4 -> 3
    }
}
