import java.util.*;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode prev = new ListNode(), curr = prev;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);
        for(int i = 0; i < lists.length; i++) if (lists[i] != null) pq.add(lists[i]);
        while(!pq.isEmpty()){
            ListNode next = pq.poll();
            if(next.next != null) pq.add(next.next);
            curr = curr.next = next;
        }
        return prev.next;
    }
}
