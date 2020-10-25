public class splitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        //if the length of root < k, the output == root --> null .... --> null
        //if the length of root > k:
        // int n = getLength(root) / k;
        // int carry = getLength(root) % k;
        // for (int i = 0; i < k; i++) if i < k , put n+1 node, else put n node

        //return res;
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }
}
