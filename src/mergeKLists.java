import java.util.*;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<ListNode> pg = new PriorityQueue<>(lists.length, (a, b)->(a.val-b.val));
        for (int i = 0; i < lists.length; i++){
            pg.add(lists[i]);
        }

        while (!pg.isEmpty()){
            ListNode node = pg.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null){
                pg.add(node.next);
            }
        }
        return dummy.next;
    }
}
