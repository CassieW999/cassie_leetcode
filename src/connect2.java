public class connect2 {
    public Node connect(Node root) {
        Node head = root;
        while (head != null){
            Node curr = head;
            Node nextlvhead = null;
            Node prevNode = null;

            while(curr != null){
                if (curr.left != null){
                    if (nextlvhead == null){
                        nextlvhead = curr.left;
                    }
                    if (prevNode != null){
                        prevNode.next = curr.left;
                    }
                    prevNode = curr.left;
                }

                if (curr.right != null){
                    if (nextlvhead == null){
                        nextlvhead = curr.right;
                    }
                    if (prevNode != null){
                        prevNode.next = curr.right;
                    }
                    prevNode = curr.right;
                }
                curr = curr.next;
            }
            head = nextlvhead;
        }
        return root;
    }
}
