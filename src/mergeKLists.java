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


                            ////////////////////      解题思路      //////////////////////
    //做该题时，首先的intuition就是，假如lists.length为3，每次往新的listnode里面新增元素时，它排序后位置变动最多为2，也就是lists.length-1,
    //随后，意识到该题应该使用一个长度为lists.length的优先队列，维持队列长度的办法为，每次从队列中poll出去一个元素时，需要把poll出去的node的下一个
        //node给add进来队列，直至node.next为null，不继续添加，只出不进
    //然后就大功告成啦！
}
