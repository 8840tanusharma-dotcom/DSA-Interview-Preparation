/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node cur = head;
        while(cur != null){
            Node copy  = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node dummy = new Node(0);
         Node copyCur = dummy;
        while(cur != null){
            copyCur.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            copyCur = copyCur.next;

        }
        return dummy.next;    
        }
}