public class deleteNode {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null){
            node = null;
        }

        node.val = node.next.val;
        ListNode delnode = node.next;
        node.next = delnode.next;
        delnode.next = null;
    }
}
