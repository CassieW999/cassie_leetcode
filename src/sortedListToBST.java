public class sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        //always look for the middle one
        if (head == null) return null;
        ListNode mid = this.findMiddleNode(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) return node;

        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }

    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null){
            prev.next = null;
        }

        return slow;
    }
}
