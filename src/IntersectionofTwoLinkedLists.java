public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }

    //这题构思非常巧妙，因为两个链表的长度差异，而如果存在相同后续链表，则说明后面的长度是一致的，因此我们将两个链表合并后就能达到对齐的效果
    //时间复杂度为O(n), 空间复杂度为O(1)
}
