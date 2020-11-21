import java.util.*;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack();
        ListNode temp = head;
        while(temp!=null)
        {
            s.push(temp.val);
            temp =temp.next;
        }
        while(head != null){
            if(head.val != s.pop())
                return false;
            head = head.next;
        }
        return true;

    }
}
