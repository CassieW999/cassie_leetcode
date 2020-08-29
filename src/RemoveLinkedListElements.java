public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // if(head == null) return head;

        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode cur = dummyhead;

        while (cur.next != null){

            if (cur.next.val == val){
                ListNode delnext = cur.next;
                cur.next = delnext.next;
                delnext.next = null;
            }else{
                cur = cur.next;
            }
        }
        return dummyhead.next;
    }
}
