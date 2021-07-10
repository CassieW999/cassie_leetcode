public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode prev = res;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                prev.next = l2;
                l2 = l2.next;
            }else{
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        if (l1 != null || l2 != null){
            prev.next = l1 != null ? l1 : l2;
        }
        return res.next;
    }
}
