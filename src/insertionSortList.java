public class insertionSortList {
//    public ListNode insertionSortList(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//
//        while (head != null) {
//            ListNode node = dummy;
//            while (node.next != null && node.next.val < head.val) {
//                node = node.next;
//            }
//            ListNode temp = head.next;
//            head.next = node.next;
//            node.next = head;
//            head = temp;
//        }
//        return dummy.next;
//    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;
        while(cur != null && cur.next != null){
            if(cur.val <= cur.next.val){
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = cur.next.next;
                prev = dummy;
                while(prev.next.val <= temp.val){
                    prev = prev.next;
                }

                temp.next = prev.next;
                prev.next = temp;
            }
        }

        return dummy.next;
    }
}
