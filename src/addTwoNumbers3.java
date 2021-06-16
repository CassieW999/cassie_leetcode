public class addTwoNumbers3 {
    public static void main(String[] args) {
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        reverseList(l1);
        reverseList(l2);
        ListNode node = new ListNode(0);
        int carry = 0;
        while (l1 != null || l2 != null){
            int curNum = 0;
            if (l1 != null && l2 != null){
                curNum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }else{
                curNum = l1 == null ? l2.val : l1.val + carry;
                l1 = l1 != null ? l1.next : l1;
                l2 = l2 != null ? l2.next : l2;
            }
            carry = curNum / 10;
            ListNode cur = new ListNode(curNum % 10);
            node.next = cur;
        }
        reverseList(node);
        return node;
    }

    private void reverseList(ListNode node){
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode prev = dummy;
        ListNode cur = node;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
