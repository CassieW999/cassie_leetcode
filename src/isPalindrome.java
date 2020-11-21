

public class isPalindrome {
             //////     solution 1    //////   time complex: O(n) space O(n)
//    public boolean isPalindrome(ListNode head) {
//        Stack<Integer> s = new Stack();
//        ListNode temp = head;
//        while(temp!=null)
//        {
//            s.push(temp.val);
//            temp =temp.next;
//        }
//        while(head != null){
//            if(head.val != s.pop())
//                return false;
//            head = head.next;
//        }
//        return true;
//    }
    //////////      solution two      /////////////           time space O(n) space O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;

        while (fast != null && fast.next != null){
            if(fast.val!=slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
