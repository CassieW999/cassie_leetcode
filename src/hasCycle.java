import java.util.HashSet;
import java.util.Set;

public class hasCycle {

    ////////     solution one using hashset     ////////
    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            if (nodesSeen.contains(head)) {
//                return true;
//            } else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    ////////     solution two using two pointers     ////////
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head, slow = head.next;
        while(fast != head){
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }

}
