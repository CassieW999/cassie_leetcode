public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode curr = head;
        int endval = 0; // value of the very last node
        while(curr!=null){
            int count = 0;
            // count = number of identical element
            while(curr.next!= null && curr.val == curr.next.val){
                count ++;
                curr = curr.next;
            }
            // count == 0 means no identical element
            if (count==0){
                temp.next = curr;
                temp = temp.next;
            }
            if (curr.next == null){
                endval = curr.val;
            }
            curr = curr.next;
            count = 0;
        }
        // if temp.val != endval
        // the last element in original linked list has duplicates
        if (temp.val != endval){
            temp.next = null;
        }
        return dummy.next;
    }
}
